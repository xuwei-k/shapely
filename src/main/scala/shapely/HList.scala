package shapely

trait HList {
  type Append[L <: HList] <: HList

  def ++[L <: HList](xs: L): Append[L]
}

final case class HCons[H, T <: HList](head: H, tail: T) extends HList {
  type Append[L <: HList] = H :: T#Append[L]

  def ++[L <: HList](xs: L) = HCons(head, tail ++ xs)
}

case class HNil() extends HList {
  type Append[L <: HList] = L

  def ++[L <: HList](xs: L) = xs
}

