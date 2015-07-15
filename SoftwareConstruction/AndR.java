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
		
		while (searchPosition > 0) {
			if (andRModifiedFormula.charAt(searchPosition) == 'r') {
				searchPosition--;
				if (andRModifiedFormula.charAt(searchPosition) == '&') {
					String subFormulaToAdd = splicer.getSubformulaToAdd(andRModifiedFormula, searchPosition + 1);
					andRModifiedFormula = splicer.removeSubformula(andRModifiedFormula, searchPosition, searchPosition + 1 + subFormulaToAdd.length());
					searchPosition--;
					int startPosition = splicer.getBeginSubformulaToSplicePosition(andRModifiedFormula, searchPosition);
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
