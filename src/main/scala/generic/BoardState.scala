package generic

trait BoardState[Move, T <: BoardState[Move, T]] extends Board {

  def doMove(move: Move): Option[T]

}
