package Views.NewGameDialog

import scalafx.scene.control.TextInputDialog

object NewGameDialog {

  def newGameDialog: TextInputDialog = {
    new TextInputDialog {
      title = "Create New Game"
      headerText = "New Game"
      contentText = "Enter Name of New Game: "
    }
  }
}
