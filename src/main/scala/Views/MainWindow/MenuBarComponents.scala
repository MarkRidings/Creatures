package Views.MainWindow

import scalafx.application.Platform
import scalafx.event.ActionEvent
import scalafx.scene.control.{MenuBar, SeparatorMenuItem, Menu, MenuItem}
import scalafx.scene.input.KeyCombination
import scalafx.Includes._

object MenuBarComponents {

  def newGameMenuItem: MenuItem = {
    new MenuItem {
      text = "New Game"
      accelerator = KeyCombination("Ctrl +N")
      onAction = (event: ActionEvent) => { println("Creating new game...")}
    }
  }

  def exitMenuItem: MenuItem = {
    new MenuItem {
      text = "Exit"
      accelerator = KeyCombination("Esc")
      onAction = (event: ActionEvent) => { Platform.exit() }
    }
  }

  def gameMenu: Menu = {
    new Menu("Game") {
      items.addAll(newGameMenuItem, new SeparatorMenuItem(), exitMenuItem)
    }
  }

  def MainMenuBar: MenuBar = {
    new MenuBar {
      style = "-fx-background-color: gainsboro; -fx-text-inner-color: black"
      menus.addAll(gameMenu)
    }
  }


}
