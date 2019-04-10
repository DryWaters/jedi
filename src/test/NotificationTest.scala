package test

import value._

object NotificationTest extends App {
  val n1 = Notification(Notification.OK)
  val n2 = Notification(Notification.DONE)
  val n3 = Notification(Notification.UNSPECIFIED)
  val n4 = Notification("WrongType")
  println(n1);
  println(n2);
  println(n3);
  println(n4);
}