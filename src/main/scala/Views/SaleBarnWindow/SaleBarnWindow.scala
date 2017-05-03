package Views.SaleBarnWindow

import javafx.scene.Node

import Controllers.MainWindowController
import GameObjects.{Creature, SaleBarn}
import Settings.GameSettings
import ViewModels.SaleBarn.SaleBarnViewModel
import Views.Common.Alerts

import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.control.{Button, CheckBox, Label}
import scalafx.scene.layout.GridPane
import scalafx.stage.Stage

class SaleBarnWindow {

  var viewModel = new SaleBarnViewModel

  val saleBarnRoot = new GridPane()
  saleBarnRoot.setVgap(6)
  saleBarnRoot.setHgap(4)

  SaleBarn.creaturesForSale.zipWithIndex.foreach {
    case(creature, index) =>
      val speedText = new Label { text = "Speed: %2d".format(creature.Speed) }
      val accText = new Label { text = "Acc: %2d".format(creature.Acc) }
      val endText = new Label { text = "End: %2d".format(creature.Endurance) }
      val priceText = new Label { text = "$%.2f".format(creature.salePrice) }

      val checkBox = new CheckBox(creature.Name) {
        onAction = (e : ActionEvent) => { handleCheckBox(e, creature) }
      }

      saleBarnRoot.add(checkBox, 0, index)
      saleBarnRoot.add(speedText, 1, index)
      saleBarnRoot.add(accText, 2, index)
      saleBarnRoot.add(endText, 3, index)
      saleBarnRoot.add(priceText, 4, index)
  }

  val purchasePriceLabel = new Label
  purchasePriceLabel.textProperty() <== viewModel.purchasePriceText

  val purchaseButton = new Button {
    id = "purchaseButton"
    text = "Purchase"
    onAction = {
      e : ActionEvent =>
        if (viewModel.purchasePrice > GameSettings.currentMoney) {
          Alerts.errorAlert("You do not have enough money for this purchase").showAndWait()
        } else {
          GameSettings.currentMoney -= viewModel.purchasePrice
          GameSettings.ownedCreatures ++= viewModel.selectedCreatures
          MainWindowController.updateStable()
          e.getSource.asInstanceOf[Node].getScene.getWindow.hide()
        }
    }
  }

  val cancelButton = new Button {
    id = "cancelButton"
    text = "Cancel"
    onAction = {
      e: ActionEvent => e.getSource.asInstanceOf[Node].getScene.getWindow.hide()
    }
  }

  saleBarnRoot.add(purchasePriceLabel, 0, SaleBarn.creaturesForSale.size)
  saleBarnRoot.add(cancelButton, 1, SaleBarn.creaturesForSale.size + 1)
  saleBarnRoot.add(purchaseButton, 0, SaleBarn.creaturesForSale.size + 1)

  val saleBarnScene = new Scene(800, 600) {
    root = saleBarnRoot
  }
  val stage = new Stage {
    scene = saleBarnScene
    title = "Sale Barn"
  }

  def handleCheckBox(e: ActionEvent, creature: Creature): Unit = {

    if (e.source.asInstanceOf[javafx.scene.control.CheckBox].isSelected) {
      viewModel.purchasePrice += creature.salePrice
      viewModel.selectedCreatures.append(creature)
    }
    else {
      viewModel.purchasePrice -= creature.salePrice
      viewModel.selectedCreatures --= viewModel.selectedCreatures.filter(c => c.Id == creature.Id)
    }

    viewModel.purchasePriceText() = "Purchase Price: $%.2f".format(viewModel.purchasePrice)
  }
}

