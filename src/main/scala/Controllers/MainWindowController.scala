package Controllers

import FileIO.FileCreator
import Settings.GameSettings


object MainWindowController {

  def createNewGame(saveName: String, orgName: String): Unit = {
    GameSettings.saveName = saveName
    GameSettings.orgName = orgName
    GameSettings.week = 1
    GameSettings.year = 1

    FileCreator.createSavedGameFile(saveName)
  }
}
