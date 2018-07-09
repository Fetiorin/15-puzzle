package puzzleN

import generic.BoardState

case class PuzzleNBoardState(board: Vector[Int], side: Int) extends BoardState[Move, PuzzleNBoardState] {

  val emptyLabel = side * side

  def moveToLabel(move: Move): Option[Int] = move match {
    case Move.Down => board.lift(emptyPosition - side)
    case Move.Up   => board.lift(emptyPosition + side)
    case Move.Left if (emptyPosition + 1) % side != 0 => Some(board(emptyPosition + 1))
    case Move.Right if emptyPosition      % side >= 1 => Some(board(emptyPosition - 1))
    case _ => None
  }

  def emptyPosition: Int = board.indexOf(emptyLabel)

  def swapByLabels(x: Int, y: Int): Vector[Int] = {
    val xIdx = board.indexOf(x)
    val yIdx = board.indexOf(y)
    board.updated(xIdx, board(yIdx)).updated(yIdx, board(xIdx))
  }

  def doMove(move: Move): Option[PuzzleNBoardState] =
    moveToLabel(move).map(it => this.copy(swapByLabels(emptyLabel, it)))

}
