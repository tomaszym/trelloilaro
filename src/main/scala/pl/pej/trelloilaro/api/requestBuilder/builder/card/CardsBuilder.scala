package pl.pej.trelloilaro.api.requestBuilder.builder.card

import pl.pej.trelloilaro.api.requestBuilder.{AllRequestParam, RequestParam, RequestBuilder}

trait CardsBuilder[T] { this: RequestBuilder[T] =>

  protected def cardsParamName = "cards"

  def withCards(card: Card) = withOnlyParam(cardsParamName, card)

}

trait Card extends RequestParam

object Card {
  case object all extends Card
  case object none extends Card
  case object visible extends Card
  case object open extends Card
  case object closed extends Card
}