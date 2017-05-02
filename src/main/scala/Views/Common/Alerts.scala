package Views.Common

import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType


object Alerts {

  def errorAlert(message: String): Alert = {
    new Alert(AlertType.Error) {
      title = "Error!"
      contentText = message
    }
  }

  def infoAlert(message: String): Alert = {
    new Alert(AlertType.Information) {
      title = "Info"
      contentText = message
    }
  }
}
