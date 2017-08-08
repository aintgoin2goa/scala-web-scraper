package test

import org.scalatest._
import org.scalamock.scalatest.MockFactory



class GuardianSpec extends FlatSpec with Matchers with MockFactory {


	"The getArticle method" should "fetch a guardian article and return the HTML" in {
		val url = "https://www.theguardian.com/us-news/2017/aug/03/donald-trump-west-virginia-rally-russia-grand-jury"
		val expectedHeadline = "Trump blasts Russia investigation as Mueller convenes grand jury"
		var expectedStandfirst = "Rally for thousands of diehard supporters held on same day news emerged that special counsel has set up panel to examine evidence of alleged collusion"
		val result = scraper.Guardian.getArticle(url)
		result.headline shouldEqual expectedHeadline
		result.standfirst shouldEqual expectedStandfirst
		result.body should startWith ("Donald Trump has sought to rally thousands of diehard supporters against the investigation into his campaign’s alleged collusion with Russia")
	}
}
