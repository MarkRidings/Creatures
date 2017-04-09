package Views.OrgNameDialog

import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control.{Alert, TextInputDialog}

object OrgNameDialog {

  def orgNameDialog: TextInputDialog = {
    new TextInputDialog {
      title = "Organization Name?"
      headerText = "Enter the name of your Organization"
      contentText = "Name: "
    }
  }

  def invalidNameAlert: Alert = {
    new Alert(AlertType.Error) {
      title = "Error!"
      headerText = "Invalid Name!"
      contentText = "Organization name cannot be blank"
    }
  }

}
