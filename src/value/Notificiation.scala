package value

case class Notification(private val noteType: String) extends Value {
    override def toString = f"${noteType}"
}

object Notification {
  
  val OK = "ok"
  val DONE = "done"
  val UNSPECIFIED = "unspecified"
  
  def apply(noteType: String) = noteType match {
    case OK | DONE | UNSPECIFIED => new Notification(noteType)
    case _ => "Type needs to be either OK, DONE, or UNSPECIFIED" 
  }
}