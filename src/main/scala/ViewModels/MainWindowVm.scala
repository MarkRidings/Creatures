package ViewModels

import scalafx.beans.property.{BooleanProperty, StringProperty, IntegerProperty}

object MainWindowVm {

  var CurrentYear = StringProperty("")
  var CurrentWeek = StringProperty("")
  var RacingOrgName = StringProperty("")
  var PlayerMoney = StringProperty("")

  var TimeBoxVisible = BooleanProperty(false)

}
