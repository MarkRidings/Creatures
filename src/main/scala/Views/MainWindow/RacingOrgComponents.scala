package Views.MainWindow

import ViewModels.MainWindowVm

import scalafx.scene.control.Label
import scalafx.scene.layout.VBox

import scalafx.Includes._

object RacingOrgComponents {

  val orgLabel = new Label {
    id = "orgLabel"
  }

  val moneyLabel = new Label {
    id = "moneyLabel"
  }

  orgLabel.textProperty() <== MainWindowVm.RacingOrgName
  moneyLabel.textProperty() <== MainWindowVm.PlayerMoney

  def orgBox: VBox = {
    return new VBox {
      children.addAll(orgLabel, moneyLabel)
    }
  }
}