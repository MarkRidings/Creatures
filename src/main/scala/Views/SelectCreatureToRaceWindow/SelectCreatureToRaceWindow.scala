package Views.SelectCreatureToRaceWindow

import javafx.scene.Node

import Controllers.MainWindowController
import Settings.GameSettings

import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.control.{Button, Label}
import scalafx.scene.layout.GridPane
import scalafx.stage.Stage

class SelectCreatureToRaceWindow {

  val selectCreatureGridRoot = new GridPane()
  selectCreatureGridRoot.setHgap(2)
  selectCreatureGridRoot.setVgap(2)

  GameSettings.ownedCreatures.zipWithIndex.foreach {
    case (creature, index) =>

      val nameText = new Label { text= creature.Name }
      val speedText = new Label { text = "Speed: %2d".format(creature.Speed) }
      val accText = new Label { text = "Acc: %2d".format(creature.Acc) }
      val endText = new Label { text = "End: %2d".format(creature.Endurance) }

      val selectButton = new Button {
        text = "Select"
        onAction = (e: ActionEvent) => {
          GameSettings.creatureRacing = creature
          MainWindowController.doRace()
          e.getSource.asInstanceOf[Node].getScene.getWindow.hide()
        }
      }

      selectCreatureGridRoot.add(selectButton, 0, index)
      selectCreatureGridRoot.add(nameText, 1, index)
      selectCreatureGridRoot.add(speedText, 2, index)
      selectCreatureGridRoot.add(accText, 3, index)
      selectCreatureGridRoot.add(endText, 4, index)
  }

  val selectCreatureScene = new Scene(400, 400) {
    root = selectCreatureGridRoot
  }

  val stage = new Stage {
    scene = selectCreatureScene
    title = "Select Creature to Race"
  }
}
