package shapely

trait Nat {
  type N <: Nat
}

object Nat {

  def toInt[N <: Nat](implicit N: ToInt[N]): Int = N.value
}

object Zero0 extends Nat {
  type N = Zero0.type
}

case class Succ[N0 <: Nat](n: N0) extends Nat {
  type N = Succ[N0]
}
