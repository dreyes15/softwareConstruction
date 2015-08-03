package ltlGenerator.formulaBuilder;

import ltlGenerator.formulaBuilder.propSubstitutor.PropSubstitutor;
import ltlGenerator.formulaBuilder.specialOperator.SpecialOperator;
import ltlGenerator.formulaBuilder.table.SubstitutionTable;
import ltlGenerator.propertyBuilder.Property;
import ltlGenerator.propertyBuilder.patterns.Pattern;
import ltlGenerator.propertyBuilder.proposition.Proposition;
import ltlGenerator.propertyBuilder.scopes.*;

/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity,
 * 		 Lucia Rodriguez, and David Reyes
 * Project: LTL Generator
 * Sprint: LTL Generator
 * Due Date: July 3, 2015
 * Purpouse: This class is the main driver of the Output Generation subsystem.  It receives
 * a Property object and it returns an LTL Formula that matches the given Property data.
 * This class contains one method called createFormula() 
 */

public class FormulaCreator {
	/* createFormula() receives a Property object from LTLGenerator. It passes
	 * the Scope and Pattern objects to a method it calls from the
	 * SubstitionTable class and returns a FinalFormula string to LTLGenerator.
	 */

	public static String createFormula(Property P) {

		Property property = P;
		Scope scope = property.getScope();
		Pattern pattern = property.getPattern();

		String baseFormula = "";
		if (scope instanceof Global) {
			baseFormula = SubstitutionTable.getTable((Global) scope, pattern);
		}
		else if (scope instanceof AfterL) {
			baseFormula = SubstitutionTable.getTable((AfterL) scope, pattern);
		}
		else if (scope instanceof BeforeR) {
			baseFormula = SubstitutionTable.getTable((BeforeR) scope, pattern);
		}
		else if (scope instanceof BetweenLandR) {
			baseFormula = SubstitutionTable.getTable((BetweenLandR) scope, pattern);
		}
		else if (scope instanceof AfterLuntilR) {
			baseFormula = SubstitutionTable.getTable((AfterLuntilR) scope, pattern);
		}

		Proposition propP = pattern.getPropositionP();
		Proposition propQ = pattern.getPropositionQ();
		Proposition propL = scope.getPropositionL();
		Proposition propR = scope.getPropositionR();

		String updatedBaseFormula = SpecialOperatorUpdater.specialOperationsReplacement(property, baseFormula);

		String pModifiedFormula = PropSubstitutor.substituteCompositeProps(updatedBaseFormula, propP);
		String qModifiedFormula = "";
		String lModifiedFormula = "";
		String modifiedFormula = "";
		if (propQ != null) {
			qModifiedFormula = PropSubstitutor.substituteCompositeProps(pModifiedFormula, propQ);
		}
		else {
			qModifiedFormula = pModifiedFormula;
		}
		if (propL != null) {
			lModifiedFormula = PropSubstitutor.substituteCompositeProps(qModifiedFormula, propL);
		}
		else {
			lModifiedFormula = qModifiedFormula;
		}
		if (propR != null) {
			modifiedFormula = PropSubstitutor.substituteCompositeProps(lModifiedFormula, propR);
		}
		else {
			modifiedFormula = lModifiedFormula;
		}
		
		String finalFormula = SpecialOperator.performSpecialOperations(modifiedFormula);

		return finalFormula;
	}
}