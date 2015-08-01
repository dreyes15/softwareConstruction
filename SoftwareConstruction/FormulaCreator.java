/* This class is the main driver of the Output Generation subsystem.  It receives
 * a Property object and it returns an LTL Formula that matches the given Property data.
 * This class contains one method called createFormula()
 */

public class FormulaCreator {
	/*createFormula() receives a Property object from LTLGenerator.  It passes the Scope
	 * and Pattern objects to a method it calls from the SubstitionTable class and returns
	 * a FinalFormula string to LTLGenerator.  
	 */

	public String createFormula(Property P){
		//Assigns the Property received to a local property variable
		//Assigns the Scope and Pattern obtained from the local property to local scope and pattern variables
		//Assigns the Propositions obtained form the local scope and pattern to local proposition variables
		
		SubstitutionTable subTable = new SubstitutionTable();
		SpecialOperatorUpdater updater = new SpecialOperatorUpdater();
		PropSubstitutor propSub = new PropSubstitutor();
		SpecialOperator specOp = new SpecialOperator();
		
		Property property = P;
		Scope scope = property.getScope();
		//String localScope = scope.getScopeType();
		Pattern pattern = property.getPattern();
		//String localPattern = pattern.getPatternType();
		Proposition propP = pattern.getPropositionP();
		Proposition propQ = pattern.getPropositionQ();
		Proposition propL = scope.getPropositionL();
		Proposition propR = scope.getPropositionR();

		//Passes the scope and pattern to SubstitutionTable and gets a baseFormula in return
		String baseFormula = subTable.getTable(scope, pattern);

		//Passes the baseFormulal to specialOperationsReplacement to get an updatedBaseFormula
		String updatedBaseFormula = updater.specialOperationsReplacement(property, baseFormula);

		//Performs proposition substitution on the updatedBaseFormula conditioned on the scope and pattern 
		//types to obtain a modifiedFormula
		
		String pModifiedFormula = propSub.substituteCompositeProps(updatedBaseFormula, propP);
		String qModifiedFormula = propSub.substituteCompositeProps(pModifiedFormula, propQ);
		String lModifiedFormula = propSub.substituteCompositeProps(qModifiedFormula, propL);
		String modifiedFormula = propSub.substituteCompositeProps(lModifiedFormula, propR);
		




		//Passes the modifiedFormula to the SpecialOperator and receives a finalFormula in return
		String finalFormula = specOp.performSpecialOperations(modifiedFormula);

		//Returns the finalFormula to LTLGenerator
		return finalFormula;
	}
}