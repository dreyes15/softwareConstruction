/*This class is the main driver of the Output Generation subsystem.  It receives
 * a Property object and it returns an LTL Formula that matches the given Property data.
 This class contains one method called createFormula()*/

public class FormulaCreator {

	/*createFormula() receives a Property object from LTLGenerator.  It passes the Scope
	 * and Pattern objects to a method it calls from the SubstitionTable class and returns
	 * a FinalFormula string to LTLGenerator.  
	 */

	public void createFormula(Property prop){
		//Assigns the Property received to a local property variable
		//Assigns the Scope and Pattern obtained from the local property to local scope and pattern variables
		//Assigns the Propositions obtained form the local scope and pattern to local proposition variables
		Property localProperty = prop;
		Scope scope = prop.getScope();
		String localScope = scope.getScopeType();
		Pattern pattern = prop.getPattern();
		String localPattern = pattern.getPatternType();

		//Passes the scope and pattern to SubstitutionTable and gets a baseFormula in return
		String baseFormula = getTable(scope, pattern);

		//Passes the baseFormulal to specialOperationsReplacement to get an updatedBaseFormula
		String updatedBaseFormula = specialOperationsReplacement(basedFormula);

		//Performs proposition substitution on the updatedBaseFormula conditioned on the scope and pattern 
		//types to obtain a modifiedFormula

		public void 
		//If the scope is Global 
		
		if(localScope.equals("Global")){
			//And the pattern is Absence or Existence
			if(localPattern.equals("Absence") || localPattern.equals("Existence")){
				//get the Prop p
				Proposition propP = pattern.getPropositionP();
				//Performs propositions substitution on propP
				String modifiedFormula = propSubstitutor.substituteCompositeProps(updatedBasedFormula, propP);
				
			}
			//Otherwise
			else{
				//Performs propositions substitution on propP and propQ
				String modifiedFormula = propSubstitutor.substituteCompositeProps(updatedBasedFormula, propP);
				modifiedFormula = propSubstitutor.substituteCompositeProps(modifiedFormula, propQ);
			}
		}
		
		//if the scope is Global
		public String getModifiedFormula(Global scope, Absense Pattern){
					Proposition propP = pattern.getPropositionP();
					//Performs propositions substitution on propP
					String modifiedFormula = propSubstitutor.substituteCompositeProps(updatedBasedFormula, propP);
					return modifiedFormula;
				}
		public String getModifiedFormula(Global scope, Existence Pattern){
			Proposition propP = pattern.getPropositionP();
			//Performs propositions substitution on propP
			String modifiedFormula = propSubstitutor.substituteCompositeProps(updatedBasedFormula, propP);
			return modifiedFormula;
			
		}
		
				//Otherwise
				else{
					//Performs propositions substitution on propP and propQ
					String modifiedFormula = propSubstitutor.substituteCompositeProps(updatedBasedFormula, propP);
					modifiedFormula = propSubstitutor.substituteCompositeProps(modifiedFormula, propQ);
				}
			}
			
		}
		
		
		
		
		
		

		//If the scope is BeforeR
		else if(localScope.equals("BeforeR")){
			//And the pattern is Absence or Existence
			if(localPattern.equals("Absence") || localPattern.equals("Existence")){
				//Performs propositions substitution on propP and propR
				String modifiedFormula = propSubstitutor.substituteCompositeProps(updatedBasedFormula, propP);
				modifiedFormula = propSubstitutor.substituteCompositeProps(modifiedFormula, propR);
				
			}
			//Otherwise
			else{
				//Performs propositions substitution on propP, propR, and propQ
				String modifiedFormula = propSubstitutor.substituteCompositeProps(updatedBasedFormula, propP);
				modifiedFormula = propSubstitutor.substituteCompositeProps(modifiedFormula, propR);
				modifiedFormula = propSubstitutor.substituteCompositeProps(modifiedFormula, propQ);

			}
		}

		//If the scope is AfterL
		else if(localScope.equals("AfterL")){
			//And the pattern is Absence or Existence
			if(localPattern.equals("Absence") || localPattern.equals("Existence")){
				//Performs propositions substitution on propP and propL
				String modifiedFormula = propSubstitutor.substituteCompositeProps(updatedBasedFormula, propP);
				modifiedFormula = propSubstitutor.substituteCompositeProps(modifiedFormula, propL);
			}
			//Otherwise
			else{
				//Performs propositions substitution on propP, propQ, and propL
				String modifiedFormula = propSubstitutor.substituteCompositeProps(updatedBasedFormula, propP);
				modifiedFormula = propSubstitutor.substituteCompositeProps(modifiedFormula, propQ);
				modifiedFormula = propSubstitutor.substituteCompositeProps(modifiedFormula, propL);
			}
		}

		//Otherwise
		else{
			//If the pattern is Absence or Existence
			if(localPattern.equals("Absence") || localPattern.equals("Existence")){
				//Performs propositions substitution on propP, propL, and propR
				String modifiedFormula = propSubstitutor.substituteCompositeProps(updatedBasedFormula, propP);
				modifiedFormula = propSubstitutor.substituteCompositeProps(modifiedFormula, propL);
				modifiedFormula = propSubstitutor.substituteCompositeProps(modifiedFormula, propR);
			}
			//Otherwise
			else{
				//Performs propositions substitution on propP, propQ, propL, and propR
				String modifiedFormula = propSubstitutor.substituteCompositeProps(updatedBasedFormula, propP);
				modifiedFormula = propSubstitutor.substituteCompositeProps(modifiedFormula, propQ);
				modifiedFormula = propSubstitutor.substituteCompositeProps(modifiedFormula, propL);
				modifiedFormula = propSubstitutor.substituteCompositeProps(modifiedFormula, propR);
			}
		}

		//Passes the modifiedFormula to the SpecialOperator and receives a finalFormula in return
		String finalFormula = performSpecialOperations(modifiedFormula);

		//Returns the finalFormula to LTLGenerator
		return finalFormula;
	}

}
