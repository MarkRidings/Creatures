package Views.ViewStableWindow

import javafx.scene.Node

import GameObjects.Stable

import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.control.{Button, Label}
import scalafx.scene.layout.GridPane
import scalafx.stage.Stage
import scalafx.Includes._

class ViewStableWindow (stable: Stable) {

  val viewStableRoot = new GridPane()
  viewStableRoot.setHgap(6)
  viewStableRoot.setVgap(2)

  stable.creatures.zipWithIndex.foreach {
    case(creature, index) =>
      val nameText = new Label { text = creature.Name }
      val speedText = new Label { text = "Speed: %2d".format(creature.Speed) }
      val accText = new Label { text = "Acc: %2d".format(creature.Acc) }
      val endText = new Label { text = "Endurance: %2d".format(creature.Endurance) }

      viewStableRoot.add(nameText, 0, index)
      viewStableRoot.add(speedText, 1, index)
      viewStableRoot.add(accText, 2, index)
      viewStableRoot.add(endText, 3, index)
  }

  val closeButton = new Button {
    text = "Close"
    onAction = (e: ActionEvent) => e.getSource.asInstanceOf[Node].getScene.getWindow.hide()
  }

  viewStableRoot.add(closeButton, 0, stable.creatures.size + 1)

  val viewStableScene = new Scene(400, 200) {
    root = viewStableRoot
  }

  val stage = new Stage {
    scene = viewStableScene
    title = "Opposing Stable: %s".format(stable.name)
  }
}
