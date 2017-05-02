package ViewModels.SaleBarn

import GameObjects.Creature

import scala.collection.mutable.ListBuffer
import scalafx.beans.property.{DoubleProperty, StringProperty}

class SaleBarnViewModel {

  var purchasePrice: Double = 0.0
  val purchasePriceText = StringProperty("")
  val selectedCreatures: ListBuffer[Creature] = ListBuffer.empty[Creature]

}
