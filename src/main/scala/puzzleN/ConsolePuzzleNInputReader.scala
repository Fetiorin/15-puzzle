package puzzleN

import generic.InputReader

object ConsolePuzzleNInputReader extends InputReader[Move] {

  def lineToMove(line: String): Option[Move] = line match {
    case "l" | "left"  => Some(Move.Left)
    case "r" | "right" => Some(Move.Right)
    case "u" | "up"    => Some(Move.Up)
    case "d" | "down"  => Some(Move.Down)
    case _             => None
  }

  def readInput(): Option[Move] = lineToMove(io.StdIn.readLine())

}
