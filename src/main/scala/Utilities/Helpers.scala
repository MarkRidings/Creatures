package Utilities

object Helpers {

  def formatTime(seconds: Double): String = {

    if (seconds >= 3600) {
      val hour: Int = (seconds / 3600).asInstanceOf[Int]
      val min: Int = ((seconds % 3600) / 60).asInstanceOf[Int]
      val sec: Double = seconds % 60

      if (sec < 10) {
        f"$hour%d:$min%02d:0$sec%1.3f"
      }
      else {
        f"$hour%d:$min%02d:$sec%2.3f"
      }
    }
    else {
      val min: Int = (seconds / 60).asInstanceOf[Int]
      val sec: Double = seconds % 60

      if (sec < 10) {
        f"$min%d:0$sec%1.3f"
      }
      else {
        f"$min%d:$sec%2.3f"
      }
    }
  }
}
