package lisa.settheory
import lisa.kernel.fol.FOL._
import lisa.KernelHelpers.{given, _}
/**
 * Axioms for the Tarski-Grothendieck theory (TG)
 */
private[settheory] trait SetTheoryTGAxioms extends SetTheoryZFAxioms {

  final val tarskiAxiom: Axiom = forall(x, in(x, universe(x)) /\
    forall(y, in(y, universe(x)) ==> (in(powerSet(y), universe(x)) /\ subset(powerSet(y), universe(x))) /\
      forall(z, subset(z, universe(x)) ==> (sim(y, universe(x)) /\ in(y, universe(x))))
    )
  )

  runningSetTheory.addAxiom(tarskiAxiom)

  override def axioms: Set[Axiom] = super.axioms + tarskiAxiom

}