package generic

trait BoardView[T <: Board] {

  def show(state: T): Unit

}
