package Views.NewGameDialog

import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control.{Alert, TextInputDialog}

object NewGameDialog {

  def newGameDialog: TextInputDialog = {
    new TextInputDialog {
      title = "Create New Game"
      headerText = "New Game"
      contentText = "Enter Name of New Game: "
    }
  }

  def newGameErrorAlert: Alert = {
    new Alert(AlertType.Error) {
      title = "Invalid Save Name"
      contentText = "Save name must contain only alphanumeric characters and no spaces"
      dialogPane().setMinWidth(600)
    }
  }

  def newGameCreatedAlert(saveName: String): Alert = {
    new Alert(AlertType.Confirmation) {
      title = "Success!"
      headerText = "New game successfully created"
      contentText = s"$saveName has been created"
    }
  }
}
