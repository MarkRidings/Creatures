package Views.MainWindow

import ViewModels.MainWindowVm

import scalafx.scene.control.Label
import scalafx.scene.layout.{GridPane, VBox}
import scalafx.Includes._

object CreatureStableComponents {

  val stableTitleLabel = new Label {
    id = "stableTitleLabel"
    text = "Creatures Owned"
  }

  val creatureInStable = new GridPane()

  def stableBox: VBox = {
    val stableBox = new VBox {
      id = "stableBox"
      children.addAll(stableTitleLabel, creatureInStable)
    }

    stableBox.visibleProperty() <== MainWindowVm.StableTextVisible
    stableBox
  }

}
