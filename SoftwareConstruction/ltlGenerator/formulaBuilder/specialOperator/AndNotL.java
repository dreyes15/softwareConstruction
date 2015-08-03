package ltlGenerator.formulaBuilder.specialOperator;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity,
 * 		 Lucia Rodriguez, and David Reyes
 * Project: LTL Generator
 * Sprint: LTL Generator
 * Due Date: July 3, 2015
 * The purpose of this class is to add information to the each state, except the last, of the LTL
 * Formula before the &-l special operator.
 */
public class AndNotL {
	
	FormulaSplicer splicer = new FormulaSplicer();
	private static final String END_PARENTHESIS = "\\)";
	private static final String NEXT_OPERATOR = "X";
	private static final String UNTIL_OPERATOR = "U";
	/*
     * The replaceAndNotL() method will receive a formula string and search it for any &-l operators.
     * It will determine the portion of the formula after the &-l operator that applies to it, remove
     * this portion from the formula, and add it to the each section(state) of the formula string to
     * which the special operator applies except the last. Once all of the &-l operations have been 
     * performed, it will return the resulting andNotLModifiedFormula.
     */
	public String replaceAndNotL(String modifiedFormula) {

		String andNotLModifiedFormula = modifiedFormula;
		int searchPosition = andNotLModifiedFormula.length() - 1;
		
		while (searchPosition > 0) {
			if (andNotLModifiedFormula.charAt(searchPosition) == '-') {
				
				//Check to see if proposition before operator is AtLeastOneC or ParallelC
				if (andNotLModifiedFormula.charAt(searchPosition+1) == 'l') {
					
					//Perform the AndNotL operation at this location in the andRModifiedFormula string
					andNotLModifiedFormula = performAndNotLOperation(andNotLModifiedFormula, searchPosition);
				}
				
				//Check to see if proposition before operator is ConsecutiveC or EventualC
				else if (andNotLModifiedFormula.charAt(searchPosition+1) == 'c'){
					
					//Perform the AndNotC operation at this location in the andRModifiedFormula string
					andNotLModifiedFormula = performAndNotCOperation(andNotLModifiedFormula, searchPosition);
				}
				//Check to see if proposition before operator is AtLeastOneE or ParallelE
				else if (andNotLModifiedFormula.charAt(searchPosition+1) == 'x'){
					
					//Perform the AndNotX operation at this location in the andRModifiedFormula string
					andNotLModifiedFormula = performAndNotXOperation(andNotLModifiedFormula, searchPosition);
				}
				
				//Check to see if proposition before operator is ConsecutiveE or EventualE
				else if (andNotLModifiedFormula.charAt(searchPosition+1) == 'e'){
					
					//Perform the AndNotE operation at this location in the andRModifiedFormula string
					andNotLModifiedFormula = performAndNotEOperation(andNotLModifiedFormula, searchPosition);
				}
					
					
			}
			
			//Decrements searchPosition to keep searching through the string
			searchPosition--;
		}
		return andNotLModifiedFormula;
	}
	
	private String performAndNotLOperation(String formula, int searchPosition) {
		
		//Remove the "-l"
		formula = splicer.removeSubformula(formula, searchPosition, searchPosition + 1);
		
		//Change the "&" to an "^"
		formula = formula.replaceAll("&", "^");
		
		return formula;
	}
	
	private String performAndNotCOperation(String formula, int searchPosition) {

		//Get the portion of the formula after the &-c that it applies to
		String subformulaToAdd = splicer.getSubformulaToAdd(formula, searchPosition + 1);
		
		//Remove the special operator and the subFormulaToAdd
		formula = splicer.removeSubformula(formula, searchPosition-1, searchPosition + 1 + subformulaToAdd.length());
		searchPosition--;
		
		//Find the beginning position of the portion of the formula that subFormulaToAdd needs to be spliced into
		int startPosition = splicer.getBeginSubformulaToSplicePosition(formula, searchPosition);
		
		//Search from the beginning of the portion of the formula that needs spliced into to the position that the &-c was located
		while (startPosition < searchPosition) {
			startPosition++;
			
			//Finds all the "next" operators
			if (formula.substring(startPosition,startPosition+1).matches(NEXT_OPERATOR)) {
				
				//Adds the splice in front of these operators
				formula = splicer.addSubformula(formula, subformulaToAdd + "^", startPosition);
				
				//Normalizes the search and start positions after the subformula is added
				searchPosition += subformulaToAdd.length();
				startPosition += subformulaToAdd.length()+1;
			}
			
			//Finds all the "until" operators
			else if (formula.substring(startPosition,startPosition+1).matches(UNTIL_OPERATOR)) {
				
				//Adds the splice in front of these operators
				formula = splicer.addSubformula(formula, "^" + subformulaToAdd, startPosition - 1);
				
				//Normalizes the search and start positions after the subformula is added
				searchPosition += subformulaToAdd.length();
				startPosition += subformulaToAdd.length()+1;
			}
		}
		return formula;
	}
	
	private String performAndNotXOperation(String formula, int searchPosition) {

		//Get the portion of the formula after the &-x that it applies to
		String subformulaToAdd = splicer.getSubformulaToAdd(formula, searchPosition + 1);
		
		//Remove the special operator and the subFormulaToAdd
		formula = splicer.removeSubformula(formula, searchPosition-1, searchPosition + 1 + subformulaToAdd.length());
		searchPosition--;
		
		//Find the beginning position of the portion of the formula that subFormulaToAdd needs to be spliced into
		int startPosition = splicer.getBeginSubformulaToSplicePosition(formula, searchPosition);
		
		//Search from the position that the &-x was located to the beginning of the portion of the formula that needs spliced into
		while (searchPosition > startPosition+1){
			searchPosition--;
			//Finds all the sets of close parentheses
			if (formula.substring(searchPosition-1,searchPosition).matches(END_PARENTHESIS)){
				searchPosition--;
				if (formula.substring(searchPosition-1,searchPosition).matches(END_PARENTHESIS)){
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
	
	private String performAndNotEOperation(String formula, int searchPosition) {

		//insert method to add subformulaToAdd to first state
		String subformulaToAdd = splicer.getSubformulaToAdd(formula, searchPosition + 1);
		
		//Remove the special operator and the subFormulaToAdd
		formula = splicer.removeSubformula(formula, searchPosition-1, searchPosition + 1 + subformulaToAdd.length()); 
		searchPosition--;
		
		//Find the beginning position of the portion of the formula that subFormulaToAdd needs to be spliced into
		int startPosition = splicer.getBeginSubformulaToSplicePosition(formula, searchPosition);
		
		//Moves the searchPosition to the end position of the formula that subFormulaToAdd needs to be spliced into
		searchPosition = splicer.getEndSubformulaToSplicePosition(formula, searchPosition);
		
		//Searches from the end of the portion of the formula that needs to be spliced into to the beginning of that formula
		while (searchPosition > startPosition+1){
			searchPosition--;
			
			//Finds all the sets of close parentheses
			if (formula.substring(searchPosition-1,searchPosition).matches(END_PARENTHESIS)){
				searchPosition--;
				if (formula.substring(searchPosition-1,searchPosition).matches(END_PARENTHESIS)){
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

