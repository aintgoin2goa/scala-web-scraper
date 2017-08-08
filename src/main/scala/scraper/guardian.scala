package scraper

import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._
import net.ruippeixotog.scalascraper.model._

case class ParsedArticle(headline: String, standfirst: String, body: String)

object Guardian {

	val getArticle = (url: String) => {
		val browser = JsoupBrowser();
		val document = browser.get(url)
		val headline = document >> text(".content__headline")
		val standfirst = document >> text(".content__standfirst p")
		val content = document >> text(".content__article-body")
		ParsedArticle(headline, standfirst, content)
	}
}
