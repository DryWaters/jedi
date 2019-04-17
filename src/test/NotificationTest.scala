package test

import value._

object NotificationTest extends App {
  println(Notification.OK)
  println(Notification.DONE)
  println(Notification.UNSPECIFIED)
  println(Notification("Something else"))
}