import scalafx.application.{Platform, JFXApp}
import scalafx.application.JFXApp.PrimaryStage
import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.control.{MenuBar, SeparatorMenuItem, Menu, MenuItem}
import scalafx.scene.input.KeyCombination
import scalafx.Includes._
import scalafx.scene.layout.BorderPane
import scalafx.scene.paint.Color

object MainWindow  extends JFXApp {

  def exitMenuItem: MenuItem = {

    val exitMenuItem = new MenuItem {
      text = "Exit"
      accelerator = KeyCombination("Esc")
      onAction = (event: ActionEvent) => { Platform.exit() }
    }

    exitMenuItem
  }

  def newMenuItem: MenuItem = {

    val newMenuItem = new MenuItem {
      text = "New Game"
      accelerator = KeyCombination("Ctrl +N")
      onAction = (event: ActionEvent) => { println("Creating new game...") }
    }

    newMenuItem
  }

  def gameMenu: Menu = {
    val gameMenu = new Menu("Game") {
      items.addAll(newMenuItem, new SeparatorMenuItem(), exitMenuItem)
      style
    }

    gameMenu
  }

  val MenuBar = new MenuBar {
    style = "-fx-background-color: gainsboro; -fx-text-inner-color: black"
    menus.addAll(gameMenu)
  }

  val Root =new BorderPane {
    style = "-fx-background-color: transparent"
    top = MenuBar
  }

  val Scene = new Scene(1200, 800) {
    root = Root
    fill = Color.web("#070338")
  }

  stage = new PrimaryStage {
    scene = Scene
  }
}
