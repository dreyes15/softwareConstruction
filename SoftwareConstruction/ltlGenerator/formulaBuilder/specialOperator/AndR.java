package ltlGenerator.formulaBuilder.specialOperator;
/* 
 * The purpose of this class is to add information to the each state of the LTL Formula before the
 * &r special operator.
 */
public class AndR{
	
	private static final String END_PARENTHESIS = "\\)";
	
	/*
     * The replaceAndR() method will receive the modifiedFormula and search it for any &r operators.
     * It will determine the portion of the formula after the &r operator that applies to it, remove
     * this portion from the formula, and add it to the each section(state) of the ModifiedFormula.
     * Once all of the &r operations have been performed, it will return the resulting 
     * andRModifiedFormula to the SpecialOperator class.
     */
	public String replaceAndR(String modifiedFormula){

		FormulaSplicer splicer = new FormulaSplicer();
		String andRModifiedFormula = modifiedFormula;
		int searchPosition = andRModifiedFormula.length() - 1;
		
		//Starts searching from the end of the formula to the beginning of the formula 
		while (searchPosition > 0){
			//Searches for the &r operator
			if (andRModifiedFormula.charAt(searchPosition) == '&'){
				//Check for &r operators of a Condition type
				if (andRModifiedFormula.charAt(searchPosition + 1) == 'r'){
					//Gets the portion of the formula after the &r operator
					String subFormulaToAdd = splicer.getSubformulaToAdd(andRModifiedFormula, searchPosition + 1);
					//Removes the &r operator and the subformula it is splicing into the portion before the &r
					andRModifiedFormula = splicer.removeSubformula(andRModifiedFormula, searchPosition, searchPosition + 1 + subFormulaToAdd.length());
					//Gets the beginning position of the portion of the formula that needs to be spliced into
					int startPosition = splicer.getBeginSubformulaToSplicePosition(andRModifiedFormula, searchPosition);
					//Searches the portion of formula that needs to be spliced into for the places the splice needs to be added
					while (startPosition < searchPosition){
						startPosition++;
						//Finds all the sets of close parentheses
						if (andRModifiedFormula.substring(startPosition,startPosition+1).matches(END_PARENTHESIS) && !andRModifiedFormula.substring(startPosition-1,startPosition).matches("\\)")){
							//Adds the splice in front of these sets
							andRModifiedFormula = splicer.addSubformula(andRModifiedFormula, "^" + subFormulaToAdd, startPosition);
							//Normalizes the search and start positions after the subformula is added
							searchPosition += subFormulaToAdd.length();							
							startPosition += subFormulaToAdd.length()+1;
						}
						//Finds all the "next" operators
						else if (andRModifiedFormula.substring(startPosition,startPosition+1).matches("X")){
							//Adds the splice in front of these operators
							andRModifiedFormula = splicer.addSubformula(andRModifiedFormula, subFormulaToAdd + "^", startPosition);
							//Normalizes the search and start positions after the subformula is added
							searchPosition += subFormulaToAdd.length();	
							startPosition += subFormulaToAdd.length()+1;
						}
					}
				}
				//Check for &r operators of an Event type
				else if (andRModifiedFormula.charAt(searchPosition + 1) == 'e'){
					//Gets the portion of the formula after the &e operator
					String subformulaToAdd = splicer.getSubformulaToAdd(andRModifiedFormula, searchPosition + 1);
					//Removes the &e operator and the subformula it is splicing into the portion before the &e
					andRModifiedFormula = splicer.removeSubformula(andRModifiedFormula, searchPosition, searchPosition + 1 + subformulaToAdd.length());
					//Gets the beginning position of the portion of the formula that needs to be spliced into
					int startPosition = splicer.getBeginSubformulaToSplicePosition(andRModifiedFormula, searchPosition);
					//Searches the portion of formula that needs to be spliced into for the places the splice needs to be added
					while (searchPosition > startPosition+1){
						searchPosition--;
						//Finds all the sets of close parentheses
						if (andRModifiedFormula.substring(searchPosition-1,searchPosition).matches(END_PARENTHESIS)){
							searchPosition--;
							if (andRModifiedFormula.substring(searchPosition-1,searchPosition).matches(END_PARENTHESIS)){
								while (andRModifiedFormula.substring(searchPosition-1,searchPosition).matches(END_PARENTHESIS)){
									searchPosition--;
								}
								//Adds the splice after the first of these close parentheses
								andRModifiedFormula = splicer.addSubformula(andRModifiedFormula, "^" + subformulaToAdd, searchPosition+1);
							}
						}
					}
				}
			}
			//Decrements until it has searched formula from end to beginning looking for &r operators
			searchPosition--;
		}
		//returns the formula with splices inserted in accordance with all &r operators contained in original formula
		return andRModifiedFormula;
	}
}