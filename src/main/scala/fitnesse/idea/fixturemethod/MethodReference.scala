package fitnesse.idea.fixturemethod

import com.intellij.psi._
import com.intellij.psi.search.{GlobalSearchScope, PsiShortNamesCache}
import fitnesse.idea.scripttable.ScenarioName

class MethodReference(referer: FixtureMethod) extends PsiPolyVariantReferenceBase[FixtureMethod](referer) {

  val project = referer.getProject

  override def getVariants = Array()

  override def multiResolve(b: Boolean): Array[ResolveResult] = getReferencedMethods.toArray

  protected def createReference(element: PsiElement): ResolveResult = new PsiElementResolveResult(element)

  protected def getReferencedMethods: Seq[ResolveResult] = {
    referer.getFixtureClass match {
      case Some(fixtureClass) =>
        // TODO: take into account Library and Import tables. Search for ancestors.
        Option(fixtureClass.getReference) match {
          case Some(reference) => reference.resolve match {
            case c: PsiClass => c.findMethodsByName (referer.fixtureMethodName, true /* checkBases */ ).map (createReference)
            case s: ScenarioName => List (createReference (s) )
            }
          case None =>
            val cache = PsiShortNamesCache.getInstance(project)
            cache.getMethodsByName(referer.fixtureMethodName, GlobalSearchScope.projectScope(project)).map(createReference)
        }
      case None =>
        val cache = PsiShortNamesCache.getInstance(project)
        cache.getMethodsByName(referer.fixtureMethodName, GlobalSearchScope.projectScope(project)).map(createReference)
    }
  }

}
