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
	/*
     * The replaceAndNotL() method will receive a formula string and search it for any &-l operators.
     * It will determine the portion of the formula after the &-l operator that applies to it, remove
     * this portion from the formula, and add it to the each section(state) of the formula string to
     * which the special operator applies except the last. Once all of the &-l operations have been 
     * performed, it will return the resulting andNotLModifiedFormula.
     */
	public String replaceAndNotL(String modifiedFormula) {

		FormulaSplicer splicer = new FormulaSplicer();
		String andNotLModifiedFormula = modifiedFormula;
		int searchPosition = andNotLModifiedFormula.length() - 1;
		
		while (searchPosition > 0) {
			if (andNotLModifiedFormula.charAt(searchPosition) == '-') {
				
				//Check to see if proposition before operator is AtLeastOneC or ParallelC
				if (andNotLModifiedFormula.charAt(searchPosition+1) == 'l') {
					
					//Remove the "-l"
					andNotLModifiedFormula = splicer.removeSubformula(andNotLModifiedFormula, searchPosition, searchPosition + 1);
					
					//Change the "&" to an "^"
					andNotLModifiedFormula = andNotLModifiedFormula.replaceAll("&", "^");
				}
				
				//Check to see if proposition before operator is ConsecutiveC or EventualC
				else if (andNotLModifiedFormula.charAt(searchPosition+1) == 'c'){
					
					//Get the portion of the formula after the &-c that it applies to
					String subformulaToAdd = splicer.getSubformulaToAdd(andNotLModifiedFormula, searchPosition + 1);
					
					//Remove the special operator and the subFormulaToAdd
					andNotLModifiedFormula = splicer.removeSubformula(andNotLModifiedFormula, searchPosition-1, searchPosition + 1 + subformulaToAdd.length());
					searchPosition--;
					
					//Find the beginning position of the portion of the formula that subFormulaToAdd needs to be spliced into
					int startPosition = splicer.getBeginSubformulaToSplicePosition(andNotLModifiedFormula, searchPosition);
					
					//Search from the beginning of the portion of the formula that needs spliced into to the position that the &-c was located
					while (startPosition < searchPosition) {
						startPosition++;
						
						//Finds all the "next" operators
						if (andNotLModifiedFormula.substring(startPosition,startPosition+1).matches("X")) {
							
							//Adds the splice in front of these operators
							andNotLModifiedFormula = splicer.addSubformula(andNotLModifiedFormula, subformulaToAdd + "^", startPosition);
							
							//Normalizes the search and start positions after the subformula is added
							searchPosition += subformulaToAdd.length();
							startPosition += subformulaToAdd.length()+1;
						}
						
						//Finds all the "until" operators
						else if (andNotLModifiedFormula.substring(startPosition,startPosition+1).matches("U")) {
							
							//Adds the splice in front of these operators
							andNotLModifiedFormula = splicer.addSubformula(andNotLModifiedFormula, "^" + subformulaToAdd, startPosition - 1);
							
							//Normalizes the search and start positions after the subformula is added
							searchPosition += subformulaToAdd.length();
							startPosition += subformulaToAdd.length()+1;
						}
					}
				}
				//Check to see if proposition before operator is AtLeastOneE or ParallelE
				else if (andNotLModifiedFormula.charAt(searchPosition+1) == 'x'){
					
					//Get the portion of the formula after the &-x that it applies to
					String subformulaToAdd = splicer.getSubformulaToAdd(andNotLModifiedFormula, searchPosition + 1);
					
					//Remove the special operator and the subFormulaToAdd
					andNotLModifiedFormula = splicer.removeSubformula(andNotLModifiedFormula, searchPosition-1, searchPosition + 1 + subformulaToAdd.length());
					searchPosition--;
					
					//Find the beginning position of the portion of the formula that subFormulaToAdd needs to be spliced into
					int startPosition = splicer.getBeginSubformulaToSplicePosition(andNotLModifiedFormula, searchPosition);
					
					//Search from the position that the &-x was located to the beginning of the portion of the formula that needs spliced into
					while (searchPosition > startPosition+1){
						searchPosition--;
						//Finds all the sets of close parentheses
						if (andNotLModifiedFormula.substring(searchPosition-1,searchPosition).matches("\\)")){
							searchPosition--;
							if (andNotLModifiedFormula.substring(searchPosition-1,searchPosition).matches("\\)")){
								while (andNotLModifiedFormula.substring(searchPosition-1,searchPosition).matches("\\)")){
									searchPosition--;
								}
								//Adds the splice after the first of these close parentheses
								andNotLModifiedFormula = splicer.addSubformula(andNotLModifiedFormula, "^" + subformulaToAdd, searchPosition+1);
							}
						}
					}
				}
				
				//Check to see if proposition before operator is ConsecutiveE or EventualE
				else if (andNotLModifiedFormula.charAt(searchPosition+1) == 'e'){
					
					//insert method to add subformulaToAdd to first state
					String subformulaToAdd = splicer.getSubformulaToAdd(andNotLModifiedFormula, searchPosition + 1);
					
					//Remove the special operator and the subFormulaToAdd
					andNotLModifiedFormula = splicer.removeSubformula(andNotLModifiedFormula, searchPosition-1, searchPosition + 1 + subformulaToAdd.length()); 
					searchPosition--;
					
					//Find the beginning position of the portion of the formula that subFormulaToAdd needs to be spliced into
					int startPosition = splicer.getBeginSubformulaToSplicePosition(andNotLModifiedFormula, searchPosition);
					
					//Moves the searchPosition to the end position of the formula that subFormulaToAdd needs to be spliced into
					searchPosition = splicer.getEndSubformulaToSplicePosition(andNotLModifiedFormula, searchPosition);
					
					//Searches from the end of the portion of the formula that needs to be spliced into to the beginning of that formula
					while (searchPosition > startPosition+1){
						searchPosition--;
						
						//Finds all the sets of close parentheses
						if (andNotLModifiedFormula.substring(searchPosition-1,searchPosition).matches("\\)")){
							searchPosition--;
							if (andNotLModifiedFormula.substring(searchPosition-1,searchPosition).matches("\\)")){
								while (andNotLModifiedFormula.substring(searchPosition-1,searchPosition).matches("\\)")){
									searchPosition--;
								}
								
								//Adds the splice after the first of these close parentheses
								andNotLModifiedFormula = splicer.addSubformula(andNotLModifiedFormula, "^" + subformulaToAdd, searchPosition+1);
							}
						}
					}
				}
			}
			
			//Decrements searchPosition to keep searching through the string
			searchPosition--;
		}
		return andNotLModifiedFormula;
	}
}

