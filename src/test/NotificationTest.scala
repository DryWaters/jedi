package test

import value._

object NotificationTest extends App {
  Notification.OK
  Notification.DONE
  Notification.UNSPECIFIED
  Notification("WrongType")
}