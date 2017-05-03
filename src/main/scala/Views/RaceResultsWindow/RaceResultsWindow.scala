package Views.RaceResultsWindow

import GameObjects.Creature
import Settings.GameSettings
import Utilities.Helpers

import scalafx.Includes._
import scalafx.scene.Scene
import scalafx.scene.control.{Button, Label}
import scalafx.scene.layout.GridPane
import scalafx.stage.Stage

class RaceResultsWindow (results: List[(Creature, Double)]) {

  val raceResultsRoot = new GridPane()
  raceResultsRoot.setHgap(2)
  raceResultsRoot.setVgap(2)

  results.zipWithIndex.foreach {
    case(result, index) =>

      val placeText = new Label { text = "%d".format(index + 1) }
      val nameText = new Label { text = result._1.Name }
      val timeText = new Label { text = Helpers.formatTime(result._2) }

      if (result._1.Id == GameSettings.creatureRacing.Id) {
        println("our creature")
        placeText.setTextFill("purple")
        nameText.setTextFill("purple")
        timeText.setTextFill("purple")
      }

      raceResultsRoot.add(placeText, 0, index)
      raceResultsRoot.add(nameText, 1, index)
      raceResultsRoot.add(timeText, 2, index)
  }

  val raceResultsScene = new Scene(400, 800) {
    root = raceResultsRoot
  }

  val stage = new Stage {
    scene = raceResultsScene
    title = "Race Results"
  }
}
