package ltlGenerator.formulaBuilder.specialOperator;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity,
 * 		 Lucia Rodriguez, and David Reyes
 * Project: LTL Generator
 * Sprint: LTL Generator
 * Due Date: July 3, 2015
 * Purpouse: The purpose of this class is to add information to the each state of the portion of the
 * LTL Formula to which the &r special operator pertains.
 */
public class AndR{
	
	FormulaSplicer splicer = new FormulaSplicer();
	private static final String END_PARENTHESIS = "\\)";
	private static final String NEXT_OPERATOR = "X";
	
	/*
     * The replaceAndR() method will receive a formula and search it for any &r or &e operators.
     * It will determine the portion of the formula after the &r/&e operator that applies to it, remove
     * this portion from the formula, and add it to the each section(state) of the original formula to
     * which the special operator pertains. Once all of the &r/&e operations have been performed, it will
     * return the resulting andRModifiedFormula.
     */
	public String replaceAndR(String formula){

		String andRModifiedFormula = formula;
		int searchPosition = andRModifiedFormula.length() - 1;
		
		//Starts searching from the end of the formula to the beginning of the formula 
		while (searchPosition > 0){
			
			//Searches for the &r operator
			if (andRModifiedFormula.charAt(searchPosition) == '&'){
				
				//Check for &r operators of a Condition type
				if (andRModifiedFormula.charAt(searchPosition + 1) == 'r'){
					
					//Perform the AndR operation at this location in the andRModifiedFormula string
					andRModifiedFormula = performAndROperation(andRModifiedFormula, searchPosition);	
				}
				
				//Check for &r operators of an Event type
				else if (andRModifiedFormula.charAt(searchPosition + 1) == 'e'){
					
					//Perform the AndR operation at this location in the andRModifiedFormula string
					andRModifiedFormula = performAndEOperation(andRModifiedFormula, searchPosition);
				}
			}
			//Decrements until it has searched formula from end to beginning looking for &r operators
			searchPosition--;
		}
		return andRModifiedFormula;
	}
	
	private String performAndROperation(String formula, int searchPosition) {
		
		//Gets the portion of the formula after the &r operator
		String subformulaToAdd = splicer.getSubformulaToAdd(formula, searchPosition + 1);
		
		//Removes the &r operator and the subformula it is splicing into the portion before the &r
		formula = splicer.removeSubformula(formula, searchPosition, searchPosition + 1 + subformulaToAdd.length());
		
		
		//Gets the beginning position of the portion of the formula that needs to be spliced into
		int startPosition = splicer.getBeginSubformulaToSplicePosition(formula, searchPosition);
		
		//Searches the portion of formula that needs to be spliced into for the places the splice needs to be added
		while (startPosition < searchPosition){
			startPosition++;
			
			//Finds all the sets of close parentheses
			if (formula.substring(startPosition,startPosition+1).matches(END_PARENTHESIS) && !formula.substring(startPosition-1,startPosition).matches(END_PARENTHESIS)){
				
				//Adds the splice in front of these sets
				formula = splicer.addSubformula(formula, "^" + subformulaToAdd, startPosition);
			}
			
			//Finds all the "next" operators
			else if (formula.substring(startPosition,startPosition+1).matches(NEXT_OPERATOR)){
				
				//Adds the splice in front of these operators
				formula = splicer.addSubformula(formula, subformulaToAdd + "^", startPosition);
			}
		}
		return formula;
	}
	
	private String performAndEOperation(String formula, int searchPosition) {
		
		//Gets the portion of the formula after the &e operator
		String subformulaToAdd = splicer.getSubformulaToAdd(formula, searchPosition + 1);
		
		//Removes the &e operator and the subformula it is splicing into the portion before the &e
		formula = splicer.removeSubformula(formula, searchPosition, searchPosition + 1 + subformulaToAdd.length());
		
		//Gets the beginning position of the portion of the formula that needs to be spliced into
		int startPosition = splicer.getBeginSubformulaToSplicePosition(formula, searchPosition);
		
		//Searches the portion of formula that needs to be spliced into for the places the splice needs to be added
		while (searchPosition > startPosition+1){
			searchPosition--;
			
			//Finds all the sets of multiple close parentheses
			if (formula.substring(searchPosition-1,searchPosition).matches(END_PARENTHESIS)){
				searchPosition--;
				if (formula.substring(searchPosition-1,searchPosition).matches(END_PARENTHESIS)){
					
					//Finds the beginning of this set of parentheses
					while (formula.substring(searchPosition-1,searchPosition).matches(END_PARENTHESIS)){
						searchPosition--;
					}
					
					//Adds the splice after the first of these close parentheses
					formula = splicer.addSubformula(formula, "^" + subformulaToAdd, searchPosition+1);
				}
			}
		}
		return formula;	
	}
}