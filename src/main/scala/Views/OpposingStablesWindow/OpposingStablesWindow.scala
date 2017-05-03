package Views.OpposingStablesWindow

import javafx.scene.Node

import Controllers.MainWindowController
import Settings.GameSettings

import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.control.{Button, Label}
import scalafx.scene.layout.GridPane
import scalafx.stage.Stage

class OpposingStablesWindow {

  val stableGridRoot = new GridPane()
  stableGridRoot.setVgap(2)
  stableGridRoot.setHgap(2)

  GameSettings.opposingStables.zipWithIndex.foreach {
    case(stable, index) =>
      val viewStableButton = new Button {
        text = "View"
        onAction = (_: ActionEvent) => {
          MainWindowController.viewStableWindow(stable)
        }
      }

      val stableNameLabel = new Label { text = stable.name }
      stableGridRoot.add(viewStableButton, 0, index)
      stableGridRoot.add(stableNameLabel, 1, index)
  }

  val closeButton = new Button {
    text = "Close"
    onAction = (e: ActionEvent) => e.getSource.asInstanceOf[Node].getScene.getWindow.hide()
  }

  stableGridRoot.add(closeButton, 0, GameSettings.opposingStables.size + 1)

  val opposingStablesScene = new Scene(400, 600) {
    root = stableGridRoot
  }

  val stage = new Stage {
    scene = opposingStablesScene
    title = "Opposing Stables"
  }
}
