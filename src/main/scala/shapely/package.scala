package object shapely {
  type ::[H, T <: HList] = HCons[H, T]

  type Zero = Zero0.type
  val Zero = Zero0

  type _0 = Zero0.type
  val _0: _0 = Zero
  type _1 = Succ[_0]
  val _1: _1 = Succ(_0)
  type _2 = Succ[_1]
  val _2: _2 = Succ(_1)
  type _3 = Succ[_2]
  val _3: _3 = Succ(_2)

  implicit class HListSyntax[L <: HList](val self: L) extends AnyVal {

    def ::[H](head: H): H :: L = HCons(head, self)

    def remove[A](implicit R: Remover[A, L]): R.Out = R(self)

    def map[P <: Poly](p: P)(implicit M: Mapper[L, P]): M.Out = M(self)

    def nth(n: Nat)(implicit N: Nther[L, n.N]): N.Out = N(self)
  }

  implicit class NatSyntax[N <: Nat](val self: N) extends AnyVal {

    def toInt(implicit N: ToInt[N]): Int = N.value
  }
}
