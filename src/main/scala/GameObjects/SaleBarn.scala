package GameObjects

import scala.collection.mutable.ListBuffer

object SaleBarn {

  val creaturesForSale: ListBuffer[Creature] = ListBuffer.empty[Creature]

  def init(): Unit = {
    1 to 20 foreach { _ => creaturesForSale += new Creature() }
  }

  def computeCreatureValue(creature: Creature): Double = {
    0.00
  }

}
