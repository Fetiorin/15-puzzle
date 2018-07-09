package object puzzleN {

  sealed trait Move

  object Move {
    case object Left  extends Move
    case object Right extends Move
    case object Up    extends Move
    case object Down  extends Move
  }

}
