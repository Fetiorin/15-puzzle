import org.scalatest._
import puzzleN._

import scala.util.Random

class Puzzle15Spec extends FlatSpec with Matchers {

  // TODO: no point to test if generated puzzle is valid with built-in valid as it used inside
  // but it can be tested with A* algorithm like follows https://github.com/b-studios/parametric-a-star.
  // Also it'll cover almost any possible edge case in Puzzle.

  "View" should "return correct string" in {
    val board = PuzzleNBoardState((1 to 16).toVector, 4)
    val game: PuzzleNGame = PuzzleNGame(board)

    GameConsoleWriter.puzzleStateToString(game.state) shouldBe "1\t2\t3\t4\n5\t6\t7\t8\n9\t10\t11\t12\n13\t14\t15\t  \n"
  }

  "Puzzle" should "be solved in simple case" in {
    val board = PuzzleNBoardState(Vector(1,2,3,4,
                                          5,6,7,8,
                                          9,10,11,12,
                                          13,14,16,15), 4)
    val game: PuzzleNGame = PuzzleNGame(board)

    game.doMove(Move.Left).get.solved shouldBe true
  }

  it should "handle corner cases" in {
    val board = PuzzleNBoardState(Vector(16,2,3,4,
                                          5,6,7,8,
                                          9,10,11,12,
                                          13,14,1,15), 4)
    val game: PuzzleNGame = PuzzleNGame(board)

    game.doMove(Move.Right) shouldBe None
    game.doMove(Move.Down) shouldBe None

    val board2 = PuzzleNBoardState(Vector(1,2,3,4,
                                          5,6,7,8,
                                          9,10,11,12,
                                          13,14,15,16), 4)
    val game2: PuzzleNGame = PuzzleNGame(board2)

    game2.doMove(Move.Left) shouldBe None
    game2.doMove(Move.Up) shouldBe None
  }

}
