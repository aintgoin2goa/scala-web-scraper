package test

import org.scalatest._
import com.amazonaws.services.lambda.runtime.Context
import org.scalamock.scalatest.MockFactory
import org.json4s._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{write}


class TestSpec extends FlatSpec with Matchers with MockFactory {
	implicit val formats = Serialization.formats(NoTypeHints)

	"The test handler" should "return TEST" in {
		val params = scraper.PathParameters()
		val req = new scraper.Request(params)
		val context = stub[Context]
		val expectedBody = write(scraper.Body("prop", "TEST MESSAGE"))
		var expectedResponse = scraper.Response(200, expectedBody)
		var result = scraper.Main.test(req, context)
		result shouldEqual expectedResponse
	}
}
