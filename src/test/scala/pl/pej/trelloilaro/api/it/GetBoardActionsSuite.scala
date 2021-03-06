package pl.pej.trelloilaro.api.it

import com.typesafe.scalalogging.LazyLogging
import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.ApiTestBase
import pl.pej.trelloilaro.api.data.GetBoardActionsTestData
import pl.pej.trelloilaro.api.requestBuilder.GetBoardActions
import pl.pej.trelloilaro.api.model.ActionJson

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

class GetBoardActionsSuite extends FunSuite with ApiTestBase with GetBoardActionsTestData with LazyLogging {

  def testHelper(request: GetBoardActions)(assertions: List[ActionJson] => Unit): List[ActionJson] = {
    val responseFuture: Future[List[ActionJson]] = client.getBoardActions(request)

    val response: List[ActionJson] = Await.result(responseFuture, 10 seconds)

    assertions(response)

    logger.debug(response.toString)
    response
  }

  ignore("Minimal actions (with no fields)") {
    testHelper(BoardActionsTestDataMinimal.request)(BoardActionsTestDataMinimal.assertFieldsDefined)
  }
  ignore("All primitive fields of actions") {
    testHelper(BoardActionsTestDataPrimitiveFields.request)(BoardActionsTestDataPrimitiveFields.assertFieldsDefined)
  }
  test("Actions with data") {
    testHelper(BoardActionsFullTestDataNoMembers.request)(BoardActionsFullTestDataNoMembers.assertFieldsDefined)
  }

}
