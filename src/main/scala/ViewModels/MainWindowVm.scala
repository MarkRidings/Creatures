package ViewModels

import scalafx.beans.property.{BooleanProperty, StringProperty, IntegerProperty}

object MainWindowVm {

  val CurrentYear = StringProperty("")
  val CurrentWeek = StringProperty("")
  val RacingOrgName = StringProperty("")
  val PlayerMoney = StringProperty("")

  val TimeBoxVisible = BooleanProperty(false)
  val StableTextVisible = BooleanProperty(false)

}
