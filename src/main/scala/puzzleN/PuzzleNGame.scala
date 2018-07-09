package puzzleN

import generic.PuzzleState

import scala.util.Random

case class PuzzleNGame(state: PuzzleNBoardState) extends PuzzleState {

  def solved: Boolean = state.board == state.board.sorted

  def doMove(move: Move): Option[PuzzleNGame] =
    state.doMove(move).map(it => PuzzleNGame(it))

}

object PuzzleNGame {

  // ref: https://www.geeksforgeeks.org/check-instance-15-puzzle-solvable/
  def valid(board: Vector[Int], side: Int): Boolean = {
    def inversions(board: List[Int], acc: Int): Int = board match {
      case x :: xs => inversions(xs, acc + xs.count(_ < x))
      case Nil     => acc
    }
    val inv          = inversions(board.toList.filterNot(_ == side * side), 0)
    val emptyTileRow = board.indexOf(side * side) / side + 1

    val isOddAndOk  = side % 2 == 1 && (inv          % 2 == 0)
    val isEvenAndOk = side % 2 == 0 && (emptyTileRow % 2 != inv)

    isOddAndOk || isEvenAndOk
  }

  def apply(random: util.Random, side: Int): PuzzleNGame = {
    def stream(random: util.Random): Stream[Vector[Int]] =
      random.shuffle((1 to side * side).toVector) #:: stream(new Random(random.nextInt()))

    stream(random)
      .filter(it => valid(it, side))
      .map(it => PuzzleNGame(PuzzleNBoardState(it, side)))
      .filterNot(_.solved)
      .head
  }

}
