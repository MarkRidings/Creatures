package Commands

import GameObjects.{Creature, Stable}
import Settings.GameSettings

class CreateOpposingStablesCommand {

  val numStables = 20
  val numCreaturesPerStable = 3

  def execute(): Unit = {
    1 to numStables foreach (_ => createNewStable())
  }

  def createNewStable(): Unit = {
    val newStable = new Stable()

    1 to numCreaturesPerStable foreach (_ => newStable.addCreature(new Creature()))

    GameSettings.opposingStables += newStable
  }
}
