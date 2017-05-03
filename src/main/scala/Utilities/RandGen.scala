package Utilities

import scala.util.Random

object RandGen {

  def genGauss(mean: Double, stdev: Double): Double = {
    Random.nextGaussian() * stdev + mean
  }

}
