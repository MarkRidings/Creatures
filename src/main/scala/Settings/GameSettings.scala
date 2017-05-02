package Settings

import GameObjects.{Creature, Stable}

import scala.collection.mutable.ListBuffer

object GameSettings {

  var saveName: String = ""
  var orgName: String = ""
  var week: Int = 1
  var year: Int = 1

  var currentMoney: Double = 0

  val ownedCreatures: ListBuffer[Creature] = ListBuffer.empty[Creature]

  val opposingStables: ListBuffer[Stable] = ListBuffer.empty[Stable]

}
