package Commands

import GameObjects.{Creature, Race}
import Settings.GameSettings

import scala.collection.mutable.ListBuffer

class DoRaceCommand(distance: Int) {

  def execute(): List[(Creature, Double)] = {
    val creatures: List[Creature] = getRaceParticipants
    val race = new Race(creatures, distance)
    race.execute

    race.Results
  }

  def getRaceParticipants: List[Creature] = {
    val creatures: ListBuffer[Creature] = ListBuffer.empty[Creature]
    GameSettings.opposingStables.foreach {
      stable => {
        creatures += stable.creatures.maxBy(c => c.salePrice * c.Condition)
      }
    }

    creatures += GameSettings.creatureRacing

    creatures.toList
  }
}
