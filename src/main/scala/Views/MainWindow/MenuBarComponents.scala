package Views.MainWindow

import Controllers.MainWindowController
import Settings.GameSettings
import ViewModels.MainWindowVm
import Views.NewGameDialog.NewGameDialog

import scalafx.application.Platform
import scalafx.event.ActionEvent
import scalafx.scene.control.{MenuBar, SeparatorMenuItem, Menu, MenuItem}
import scalafx.scene.input.KeyCombination
import scalafx.Includes._

object MenuBarComponents {

  def newGameMenuItem: MenuItem = {
    new MenuItem {
      text = "New Game"
      accelerator = KeyCombination("Shift +N")

      def validate(str: String): Boolean = {
        if (str.length == 0) {
          return false
        }

        if ("""\s""".r.findFirstIn(str).isDefined) {
          return false
        }

        true
      }

      onAction = (event: ActionEvent) => {
        val saveNameResult = NewGameDialog.newGameDialog.showAndWait()
        if (saveNameResult.isDefined) {
          if (validate(saveNameResult.get)) {
            MainWindowController.createNewGame(saveNameResult.get)
            MainWindowVm.CurrentYear() = GameSettings.year.toString
            MainWindowVm.CurrentWeek() = GameSettings.week.toString
            MainWindowVm.TimeBoxVisible() = true
            NewGameDialog.newGameCreatedAlert(saveNameResult.get).showAndWait()
          }
          else {
            NewGameDialog.newGameErrorAlert.showAndWait()
          }
        }
      }
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

  def mainMenuBar: MenuBar = {
    new MenuBar {
      styleClass.add("mainMenuBar")
      menus.addAll(gameMenu)
    }
  }


}
