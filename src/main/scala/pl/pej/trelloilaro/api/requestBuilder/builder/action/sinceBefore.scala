package pl.pej.trelloilaro.api.requestBuilder.builder.action

import pl.pej.trelloilaro.api.requestBuilder.{RequestParam, RequestBuilder}
import pl.pej.trelloilaro.api.requestBuilder.builder.DateParam


trait ActionSinceBuilder[T] { this: RequestBuilder[T] =>

  def withActionsSince(params: ActionSince) = withOnlyParam("actions_since", params)
}

trait ActionSince extends RequestParam

object ActionSince {
  case object `null` extends ActionSince
  case object lastView extends ActionSince
  case class ActionSinceDate(d: String) extends DateParam(d) with ActionSince
}

//trait ActionBeforeBuilder[T] { this: RequestBuilder[T] =>
//
//def withActionBefore(params: ActionBeforeParam) = withOnlyParam("action_before", params)
//}
//
//trait ActionBeforeParam extends RequestParam
//
//object ActionBefore {
//  case object `null` extends ActionBeforeParam
//  case class ActionBeforeDate(d: String) extends DateParam(d) with ActionBeforeParam
//}