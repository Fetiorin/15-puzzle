import puzzleN.{ConsolePuzzleNInputReader, GameConsoleWriter, PuzzleNGame}

object MainLoop {

  def run(game: PuzzleNGame): Unit = {
    GameConsoleWriter.show(game.state)

    ConsolePuzzleNInputReader.readInput() match {
      case Some(move: puzzleN.Move) =>
        game.doMove(move) match {
          case Some(newGame) if newGame.solved =>
            GameConsoleWriter.show(newGame.state)
            GameConsoleWriter.sayWin()
          case Some(newGame) => run(newGame)
          case None =>
            GameConsoleWriter.sayIncorrectMove()
            run(game)
        }
      case None =>
        GameConsoleWriter.sayIncorrectInput()
        run(game)
    }
  }

}
