import Views.MainWindow.MenuBarComponents.MainMenuBar

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.layout.BorderPane
import scalafx.scene.paint.Color
`
object MainWindow  extends JFXApp {

  val mainRoot = new BorderPane {
    style = "-fx-background-color: transparent"
    top = MainMenuBar
  }

  val mainScene = new Scene(1200, 800) {
    root = mainRoot
    fill = Color.web("#070338")
  }

  stage = new PrimaryStage {
    scene = mainScene
  }
}
