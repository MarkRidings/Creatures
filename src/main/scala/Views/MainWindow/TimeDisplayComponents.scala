package Views.MainWindow

import ViewModels.MainWindowVm

import scalafx.scene.control.Label
import scalafx.scene.layout.{VBox, HBox}

import scalafx.Includes._

object TimeDisplayComponents {

  val yearLabel = new Label {
    id = "yearLabel"
    text = "Year: "
  }

  val yearText = new Label {
    id = "yearText"
  }

  yearText.textProperty() <== MainWindowVm.CurrentYear

  val yearBox = new HBox(8) {
    id = "yearBox"
    children.addAll(yearLabel, yearText)
  }

  val weekLabel = new Label {
    id = "weekLabel"
    text = "Week: "
  }

  val weekText = new Label {
    id = "weekText"
  }

  weekText.textProperty() <== MainWindowVm.CurrentWeek

  val weekBox = new HBox(8) {
    id = "weekBox"
    children.addAll(weekLabel, weekText)
  }

  def timeBox: VBox = {
    val timeBox = new VBox(2) {
      prefWidth = 100
      children.addAll(yearBox, weekBox)
    }
    timeBox.visibleProperty() <== MainWindowVm.TimeBoxVisible
    timeBox
  }
}
