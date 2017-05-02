package GameObjects

import scala.collection.mutable.ListBuffer

class Stable {

  val id: Int = Stable.NumStablesCreated
  val name: String = s"Stable_$id"

  val creatures: ListBuffer[Creature] = ListBuffer.empty[Creature]

  Stable.NumStablesCreated += 1

  def addCreature(creature: Creature): Unit = {
    creatures += creature
  }
}

object Stable {

  var NumStablesCreated = 1
}