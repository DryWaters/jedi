package value

case class Notification(private val msg: String) extends Value {
  override def toString = msg
}

object Notification {
  val OK = new Notification("ok")
  val DONE = new Notification("done")
  val UNSPECIFIED = new Notification("unspecified")

  def apply(msg: String) = new Notification(msg)
}