package generic

trait InputReader[Move] {

  def readInput(): Option[Move]

}
