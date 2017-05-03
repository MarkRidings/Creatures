package GameObjects

import Utilities.RandGen

class Race (val creatures: List[Creature], val distance: Int) {

  val Creatures: List[Creature] = creatures
  val Distance: Int = distance
  var Results: List[(Creature, Double)] = List.empty[(Creature, Double)]

  def execute: Boolean = {
    Results = Creatures.map(getTime)
    true
  }

  def getTime(creature: Creature): (Creature, Double) = {
    val time = RaceDriver.race(creature, Distance)
    creature.Condition = creature.Condition * (1 - (distance / 100000.00))
    println(creature.Condition)
    (creature, time)
  }
}

object RaceDriver {

  def race(creature: Creature, raceDistance: Double): Double = {

    def doLoop(distance: Double, velocity: Double, seconds: Double): Double = {

      val decChange = RandGen.genGauss(0, 1)

      if (distance > raceDistance) {
        seconds - ((distance - raceDistance) / velocity)
      }
      else if (seconds < (creature.currentEnd * 2)) {
        val acc = computeAcc(creature.currentAcc)
        if (acc + velocity > creature.currentSpeed * 3) {
          doLoop(distance + computeDistance(velocity, 0.0), creature.currentSpeed * 3, seconds + 1)
        }
        else {
          doLoop(distance + computeDistance(velocity, acc), velocity + acc, seconds + 1)
        }
      }
      else if (decChange > 0) {
        val dec = computeDec(creature.currentEnd)
        if (velocity - dec < creature.currentSpeed / 2) {
          doLoop(distance + computeDistance(creature.currentSpeed/2, 0.0), creature.currentSpeed/2, seconds +1)
        }
        else {
          doLoop(distance + computeDistance(velocity, dec), velocity - dec, seconds + 1)
        }
      }
      else {
        doLoop(distance + computeDistance(velocity, 0.0), velocity, seconds + 1)
      }
    }

    doLoop(0.0, 0.0, 0.0)
  }

  def computeAcc(acc: Double): Double = {
    RandGen.genGauss(acc, 2.5)
  }

  def computeDec(endurance: Double): Double = {
    RandGen.genGauss(1/(endurance * 4), 0.5)
  }

  def computeDistance(velocity: Double, acc: Double): Double = {
    velocity + (0.5 * acc)
  }

}