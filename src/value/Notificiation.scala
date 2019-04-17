package value

case class Notification(private val msg: String) extends Value {
  println(msg);
  override def toString = msg
}

object Notification {
  def apply(msg: String) = new Notification(msg)

  val OK = new Notification("ok")
  val DONE = new Notification("done")
  val UNSPECIFIED = new Notification("unspecified")

}