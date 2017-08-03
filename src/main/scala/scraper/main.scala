package scraper

import awscala._
import com.amazonaws.services.lambda.runtime.Context
import org.json4s._
import org.json4s.native.Serialization
import org.json4s.native.Serialization._
import scala.beans.BeanProperty


object Main{

	implicit val formats = Serialization.formats(NoTypeHints)

	def test(input: Request, context: Context): Response = {
		val body = Serialization.write(Body("prop", "TEST MESSAGE"))
		Response(200, body)
	}
}


case class PathParameters(@BeanProperty var id:String = "") {
	def this() = this("")
}

class Request(@BeanProperty var pathParameters: PathParameters) {
	def this() = this(PathParameters(""))
}

case class Body(prop:String, message:String)

case class Response(@BeanProperty statusCode: Int, @BeanProperty body: String)


