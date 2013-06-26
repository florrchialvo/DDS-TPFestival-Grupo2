package reservaDeStock
import scala.collection.mutable.ListBuffer

class Logger {

  val fecha = new Fecha(0, 0, 0)

  val logueos: List[Log] = List()

  def loguear(mensaje: String) {

    logueos :+ new Log(fecha.fechaActualAsInt, mensaje) 
  }
  
  def mostrarLogueos = logueos.foreach(_.mostrarLog)
  
}

class Log(fecha: Int, mensaje: String) {

  def mostrarLog = println(fecha.toString() + mensaje)
}
