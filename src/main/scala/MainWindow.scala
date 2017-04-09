import ViewModels.MainWindowVm
import Views.MainWindow.MenuBarComponents.MainMenuBar

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.StringProperty
import scalafx.scene.Scene
import scalafx.scene.control.Label
import scalafx.scene.layout.{BorderPane, HBox, VBox}

import scalafx.Includes._

object MainWindow  extends JFXApp {


  val yearLabel = new Label {
    id = "yearLabel"
    text = "Year => "
  }

  val yearText = new Label {
    id = "yearText"
  }

  yearText.textProperty().bind(MainWindowVm.CurrentYear)

  val yearBox = new HBox {
    id = "yearBox"
    children.addAll(yearLabel, yearText)
  }

  val weekLabel = new Label {
    id = "weekLabel"
    text = "Week => "
  }

  val weekText = new Label {
    id = "weekText"
    text = "1"
  }

  val weekBox = new HBox(5) {
    id = "weekBox"
    children.addAll(weekLabel, weekText)
  }

  val timeBox = new VBox(2) {
    children.addAll(yearBox, weekBox)
  }

  val mainRoot = new BorderPane {
    styleClass.add("mainRoot")
    top = MainMenuBar
    right = timeBox
  }

  val mainScene = new Scene(1200, 800) {
    stylesheets = List(getClass.getResource("MainWindow/MainWindowStylesheet.css").toExternalForm)
    root = mainRoot

  }

  stage = new PrimaryStage {
    scene = mainScene
  }
}
