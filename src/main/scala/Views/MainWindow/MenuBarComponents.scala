package Views.MainWindow

import Controllers.MainWindowController
import Settings.GameSettings
import ViewModels.MainWindowVm
import Views.NewGameDialog.NewGameDialog
import Views.OrgNameDialog.OrgNameDialog

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

        // save name cannot contain whitespace
        if ("""\s""".r.findFirstIn(str).isDefined) {
          return false
        }

        true
      }

      def getSaveName: String = {
        while (true) {
          val saveNameResult = NewGameDialog.newGameDialog.showAndWait()
          if (saveNameResult.isDefined && validate(saveNameResult.get)) {
            return saveNameResult.get
          }
          else {
            NewGameDialog.newGameErrorAlert.showAndWait()
          }
        }
        ""
      }

      def getOrgName: String = {
        while (true) {
          val orgNameResult = OrgNameDialog.orgNameDialog.showAndWait()
          if (orgNameResult.isDefined && orgNameResult.get.trim != "") {
            return orgNameResult.get.trim
          }
          else {
            OrgNameDialog.invalidNameAlert.showAndWait()
          }
        }
        ""
      }

      onAction = (event: ActionEvent) => {
        val saveNameResult = getSaveName
        val orgNameResult = getOrgName
        MainWindowController.createNewGame(saveNameResult, orgNameResult)
        MainWindowVm.CurrentYear() = GameSettings.year.toString
        MainWindowVm.CurrentWeek() = GameSettings.week.toString
        MainWindowVm.TimeBoxVisible() = true
        NewGameDialog.newGameCreatedAlert(saveNameResult).showAndWait()
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
