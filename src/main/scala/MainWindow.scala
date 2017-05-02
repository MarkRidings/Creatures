import Views.MainWindow.{CreatureStableComponents, MenuBarComponents, RacingOrgComponents, TimeDisplayComponents}

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.layout.BorderPane

object MainWindow  extends JFXApp {

  val mainRoot = new BorderPane {
    styleClass.add("mainRoot")
    top = MenuBarComponents.mainMenuBar
    right = TimeDisplayComponents.timeBox
    left = RacingOrgComponents.orgBox
    center = CreatureStableComponents.stableBox
  }

  val mainScene = new Scene(800, 600) {
    stylesheets = List(getClass.getResource("MainWindow/MainWindowStylesheet.css").toExternalForm)
    root = mainRoot
  }

  stage = new PrimaryStage {
    scene = mainScene
  }
}
