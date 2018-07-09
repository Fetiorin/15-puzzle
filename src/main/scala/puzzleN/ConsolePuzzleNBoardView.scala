package puzzleN

import generic.BoardView

trait ConsolePuzzleNBoardView extends BoardView[PuzzleNBoardState] {

  def puzzleStateToString(state: PuzzleNBoardState): String =
    state.board
      .grouped(state.side)
      .foldLeft("")((acc, row) => acc + row.mkString("", "\t", "\n"))
      .replace(state.emptyLabel.toString, "  ")

  def show(state: PuzzleNBoardState): Unit = println(puzzleStateToString(state))

}

object GameConsoleWriter extends ConsolePuzzleNBoardView {

  def sayIncorrectInput(): Unit =
    println("Input is incorrect. Use 'r', 'l', 'u', 'd' as direction input.")

  def sayHi(): Unit =
    println("""
      |Hi. A tile can be moved to a neighbour empty place. 
      |To succeed in the game you need to order tiles from 1 to N,
      |where tile number 1 is at the top left corner and empty one is at the bottom right corner. 
      |Type 'r', 'l', 'u' or 'd' to move tile. 
    """.stripMargin)

  def sayIncorrectMove(): Unit = println("There is no way to move this piece.")

  def sayWin(): Unit = println("Well done. Bye.")

}
