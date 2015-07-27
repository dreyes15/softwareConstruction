/*This class is the main driver of the Output Generation subsystem.  It receives
 * a Property object and it returns an LTL Formula that matches the given Property data.
 This class contains one method called createFormula()*/

public class FormulaCreator {
	
	/*createFormula() receives a Property object from LTLGenerator.  It passes the Scope
	 * and Pattern objects to a method it calls from the SubstitionTable class and returns
	 * a FinalFormula string to LTLGenerator.
	 */
	
	//Assigns the Property received to a local property variable
	
	//Assigns the Scope and Pattern obtained from the local property to local scope and pattern variables
	
	//Assigns the Propositions obtained form the local scope and pattern to local proposition variables
	
	//Passes the scope and pattern to SubstitutionTable and gets a baseFormula in return
	
	//Passes the baseFormulal to specialOperationsReplacement to get an updatedBaseFormula
	
	//Performs proposition substitution on the updatedBaseFormula conditioned on the scope and pattern 
	//types to obtain a modifiedFormula
	//If the scope is Global
		//And the pattern is Absence or Existence
			//Performs propositions substitution on propP
		//Otherwise
			//Performs propositions substitution on propP and propQ
	//If the scope is BeforeR
		//And the pattern is Absence or Existence
			//Performs propositions substitution on propP and propR
		//Otherwise
			//Performs propositions substitution on propP, propR, and propQ
	//If the scope is AfterL
		//And the pattern is Absence or Existence
			//Performs propositions substitution on propP and propL
		//Otherwise
			//Performs propositions substitution on propP, propQ, and propL
	//Otherwise
		//If the pattern is Absence or Existence
			//Performs propositions substitution on propP, propL, and propR
		//Otherwise
			//Performs propositions substitution on propP, propQ, propL, and propR
	
	//Passes the modifiedFormula to the SpecialOperator and receives a finalFormula in return
	
	//Returns the finalFormula to LTLGenerator

}
