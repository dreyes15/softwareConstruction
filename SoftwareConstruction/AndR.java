/* 
 * The purpose of this class is to add information to the each state of the LTL Formula before the
 * &r special operator.
 */
public class AndR {
	/*
     * The replaceAndR() method will receive the modifiedFormula and search it for any &r operators.
     * It will determine the portion of the formula after the &r operator that applies to it, remove
     * this portion from the formula, and add it to the each section(state) of the ModifiedFormula.
     * Once all of the &r operations have been performed, it will return the resulting 
     * andRModifiedFormula to the SpecialOperator class.
     */
	public String replaceAndR(String modifiedFormula) {

		FormulaSplicer splicer = new FormulaSplicer();
		String andRModifiedFormula = modifiedFormula;
		int searchPosition = andRModifiedFormula.length() - 1;
		
		//Starts from the end of the formula to the beginning of the formula
		while (searchPosition > 0) {
			//Searches for the &r operator
			if (andRModifiedFormula.charAt(searchPosition) == 'r') {
				searchPosition--; 
				if (andRModifiedFormula.charAt(searchPosition) == '&') {
					//Gets the portion of the formula after the &r operator
					String subFormulaToAdd = splicer.getSubformulaToAdd(andRModifiedFormula, searchPosition + 1);
					//Removes the &r operator and the subformula it is splicing into the portion before the &r
					andRModifiedFormula = splicer.removeSubformula(andRModifiedFormula, searchPosition, searchPosition + 1 + subFormulaToAdd.length());
					searchPosition--;
					//Gets the beginning position of the portion of the formula that needs to be spliced into
					int startPosition = splicer.getBeginSubformulaToSplicePosition(andRModifiedFormula, searchPosition);
					//Searches the portion of formula that needs to be spliced into for the 
					while (startPosition < searchPosition) {
						startPosition++;
						if (andRModifiedFormula.substring(startPosition,startPosition+1).matches(
								"\\)") && !andRModifiedFormula.substring(startPosition-1,startPosition).matches(
										"\\)")) {
							andRModifiedFormula = splicer.addSubformula(andRModifiedFormula, "&" + subFormulaToAdd,
									startPosition);
							searchPosition += subFormulaToAdd.length();							
							startPosition += subFormulaToAdd.length()+1;
						}
						else if (andRModifiedFormula.substring(startPosition,startPosition+1).matches(
								"X")) {
							andRModifiedFormula = splicer.addSubformula(andRModifiedFormula, subFormulaToAdd + "&",
									startPosition);
							searchPosition += subFormulaToAdd.length();	
							startPosition += subFormulaToAdd.length()+1;
						}
					}
				}
			}
			searchPosition--;
		}
		return andRModifiedFormula;
	}
}
