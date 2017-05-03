package Controllers

import Commands.{CreateOpposingStablesCommand, DoRaceCommand}
import FileIO.FileCreator
import GameObjects.{SaleBarn, Stable}
import Settings.GameSettings
import ViewModels.MainWindowVm
import Views.MainWindow.CreatureStableComponents
import Views.OpposingStablesWindow.OpposingStablesWindow
import Views.RaceResultsWindow.RaceResultsWindow
import Views.SaleBarnWindow.SaleBarnWindow
import Views.SelectCreatureToRaceWindow.SelectCreatureToRaceWindow
import Views.ViewStableWindow.ViewStableWindow

import scalafx.scene.control.Label


object MainWindowController {

  def createNewGame(saveName: String, orgName: String): Unit = {
    GameSettings.saveName = saveName
    GameSettings.orgName = orgName
    GameSettings.week = 1
    GameSettings.year = 1
    GameSettings.currentMoney = 5000

    SaleBarn.init()

    FileCreator.createSavedGameFile(saveName)

    val command = new CreateOpposingStablesCommand()
    command.execute()

    MainWindowVm.CurrentYear() = GameSettings.year.toString
    MainWindowVm.CurrentWeek() = GameSettings.week.toString
    MainWindowVm.TimeBoxVisible() = true
    MainWindowVm.RacingOrgName() = GameSettings.orgName
    MainWindowVm.PlayerMoney() = "$%.2f".format(GameSettings.currentMoney)
    MainWindowVm.StableTextVisible() = true
  }

  def viewSaleBarnWindow(): Unit = {

    val saleBarnWindow = new SaleBarnWindow
    val stage = saleBarnWindow.stage
    stage.showAndWait()
  }

  def viewOpposingStablesWindow(): Unit = {

    val opposingStablesWindow = new OpposingStablesWindow
    val stage = opposingStablesWindow.stage
    stage.showAndWait()
  }

  def viewStableWindow(stable: Stable): Unit = {
    val viewStableWindow = new ViewStableWindow(stable)
    val stage = viewStableWindow.stage
    stage.showAndWait()
  }

  def selectCreatureToRaceWindow(): Unit = {
    val creatureToRaceWindow = new SelectCreatureToRaceWindow
    val stage = creatureToRaceWindow.stage
    stage.showAndWait()
  }

  def updateStable(): Unit = {
    CreatureStableComponents.creatureInStable.getChildren.clear()
    GameSettings.ownedCreatures.zipWithIndex.foreach {
      case(creature, index) => {
        CreatureStableComponents.creatureInStable.add(
          new Label {
            id = "stableGrid"
            text = creature.toString },
          0, index )
      }
    }

    MainWindowVm.PlayerMoney() = "$%.2f".format(GameSettings.currentMoney)
  }

  def doRace(): Unit = {
    val command = new DoRaceCommand(10000)
    val results = command.execute().sortBy(_._2)

    val showRaceResultsWindow = new RaceResultsWindow(results)
    val stage = showRaceResultsWindow.stage
    stage.showAndWait()

    GameSettings.week += 1

    if (GameSettings.week > 52) {
      GameSettings.week = 1
      GameSettings.year += 1
    }

    MainWindowVm.CurrentWeek() = GameSettings.week.toString
    MainWindowVm.CurrentYear() = GameSettings.year.toString

    updateStable()
  }
}
