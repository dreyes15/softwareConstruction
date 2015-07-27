/* 
 * The purpose of this class is to add information to the each state, except the last, of the LTL
 * Formula before the &-l special operator.
 */
public class AndNotL {
	/*
     * The replaceAndNotL() method will receive the modifiedFormula and search it for any &-l operators.
     * It will determine the portion of the formula after the &-l operator that applies to it, remove
     * this portion from the formula, and add it to the each section(state) of the ModifiedFormula
     * except the last. Once all of the &-l operations have been performed, it will return the 
     * resulting andNotLModifiedFormula to the SpecialOperator class.
     */
	public String replaceAndNotL(String modifiedFormula) {

		FormulaSplicer splicer = new FormulaSplicer();
		String andNotLModifiedFormula = modifiedFormula;
		int searchPosition = andNotLModifiedFormula.length() - 1;
		
		while (searchPosition > 0) {
			if (andNotLModifiedFormula.charAt(searchPosition) == '-') {
				//Check to see if proposition before operator is AtLeastOneC or ParallelC
				if (andNotLModifiedFormula.charAt(searchPosition+1) == 'l') {
					//String subformulaToAdd = splicer.getSubformulaToAdd(andNotLModifiedFormula, searchPosition + 1);
					andNotLModifiedFormula = splicer.removeSubformula(andNotLModifiedFormula, searchPosition, searchPosition + 1);
					andNotLModifiedFormula = andNotLModifiedFormula.replaceAll("&", "^");
				}
				//Check to see if proposition before operator is ConsecutiveC or EventualC
				else if (andNotLModifiedFormula.charAt(searchPosition+1) == 'c'){
					String subformulaToAdd = splicer.getSubformulaToAdd(andNotLModifiedFormula, searchPosition + 1);
					andNotLModifiedFormula = splicer.removeSubformula(andNotLModifiedFormula, searchPosition-1, searchPosition + 1 + subformulaToAdd.length());
					searchPosition--;
					int startPosition = splicer.getBeginSubformulaToSplicePosition(andNotLModifiedFormula, searchPosition);
					while (startPosition < searchPosition) {
						startPosition++;
						if (andNotLModifiedFormula.substring(startPosition,startPosition+1).matches("X")) {
							andNotLModifiedFormula = splicer.addSubformula(andNotLModifiedFormula, subformulaToAdd + "^", startPosition);
							searchPosition += subformulaToAdd.length();
							startPosition += subformulaToAdd.length()+1;
						}
						else if (andNotLModifiedFormula.substring(startPosition,startPosition+1).matches("U")) {
								andNotLModifiedFormula = splicer.addSubformula(andNotLModifiedFormula, "^" + subformulaToAdd, startPosition - 1);
								searchPosition += subformulaToAdd.length();
								startPosition += subformulaToAdd.length()+1;
						}
					}
				}
				//Check to see if proposition before operator is AtLeastOneE or ParallelE
				else if (andNotLModifiedFormula.charAt(searchPosition+1) == 'x'){
					String subformulaToAdd = splicer.getSubformulaToAdd(andNotLModifiedFormula, searchPosition + 1);
					andNotLModifiedFormula = splicer.removeSubformula(andNotLModifiedFormula, searchPosition-1, searchPosition + 1 + subformulaToAdd.length());
					searchPosition--;
					int startPosition = splicer.getBeginSubformulaToSplicePosition(andNotLModifiedFormula, searchPosition);
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
					andNotLModifiedFormula = splicer.removeSubformula(andNotLModifiedFormula, searchPosition-1, searchPosition + 1 + subformulaToAdd.length()); 
					searchPosition--;
					int startPosition = splicer.getBeginSubformulaToSplicePosition(andNotLModifiedFormula, searchPosition);
					searchPosition = splicer.getEndSubformulaToSplicePosition(andNotLModifiedFormula, searchPosition);
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
			searchPosition--;
		}
		return andNotLModifiedFormula;
	}
}

