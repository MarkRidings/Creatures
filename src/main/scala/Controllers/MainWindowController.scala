package Controllers

import FileIO.FileCreator
import Settings.GameSettings


object MainWindowController {

  def createNewGame(saveName: String): Unit = {
    GameSettings.saveName = saveName
    GameSettings.week = 1
    GameSettings.year = 1

    FileCreator.createSavedGameFile(saveName)
  }
}
