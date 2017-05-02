package Controllers

import FileIO.FileCreator
import GameObjects.SaleBarn
import Settings.GameSettings
import ViewModels.MainWindowVm
import Views.MainWindow.CreatureStableComponents
import Views.SaleBarnWindow.SaleBarnWindow

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
}
