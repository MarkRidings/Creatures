package GameObjects

import scala.util.Random

class Creature (val genome: List[Int]) {

  def this() {
    this(List.fill(Creature.GenomeSize * Creature.NumGenome)(Creature.genByte))
  }

  val Id: Int = Creature.NumCreated
  val Genome: List[Int] = genome
  val Speed: Int = getSpeed
  val Acc: Int = getAcc
  val Endurance: Int = getEndurance

  var Name: String = s"Creature_$Id"
  Creature.NumCreated += 1

  def getSpeed: Int = {
    val speed = Genome.zipWithIndex map { case(e, i) => computeSpeed(e, i) } sum

    if (speed > 0) speed else 1
  }

  def computeSpeed(byte: Int, index: Int): Int = {
    if (index % Creature.GenomeSize < 7) {
      byte
    }
    else {
      index % Creature.GenomeSize match {
        case 7 | 8 | 13 | 14 | 15 | 20 => byte
        case 11 | 16 => byte * -1
        case _ => 0
      }
    }
  }

  def getAcc: Int = {
    val acc = Genome.zipWithIndex map { case (e, i) => computeAcc(e, i) } sum

    if (acc > 0) acc else 1
  }

  def computeAcc(byte: Int, index: Int): Int = {
    if (index % Creature.GenomeSize > 6 && index % Creature.GenomeSize < 14) {
      byte
    }
    else {
      index % Creature.GenomeSize match {
        case 0 | 1 | 6 | 18 => byte
        case 4 | 14 | 15 | 20 => byte * -1
        case _ => 0
      }
    }
  }

  def getEndurance: Int = {
    val endurance = Genome.zipWithIndex map { case (e, i) => computeEndurance(e, i) } sum

    if (endurance > 0) endurance else 1
  }

  def computeEndurance(byte: Int, index: Int): Int = {
    if (index % Creature.GenomeSize > 13) {
      byte
    }
    else {
      index % Creature.GenomeSize match {
        case 0 | 6 | 7 => byte
        case 1 | 3 | 4 | 10 | 11 | 12 => byte * -1
        case _ => 0
      }
    }
  }

  def salePrice: Double = {
    (Speed + Acc + Endurance) * 100
  }

  override def toString: String = {
    s"$Name: Speed: $Speed  Acc: $Acc  Endurance: $Endurance"
  }
  
}

object Creature {
  val GenomeSize = 21
  val NumGenome = 4

  var NumCreated = 1

  def genByte: Int = {
    if (Random.nextFloat > 0.5) 1 else 0
  }
}
