import puzzle15.Puzzle15Game
import puzzleN.GameConsoleWriter

import scala.util.Random

object Main extends App {
  val random = new Random(10)
  val game   = Puzzle15Game(random)

  GameConsoleWriter.sayHi()

  MainLoop.run(game)
}
