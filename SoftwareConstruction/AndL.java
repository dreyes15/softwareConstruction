/* 
 * The purpose of this class is to add information to the last state of the LTL Formula before the
 * &l special operator.
 */
public class AndL {
    /*
     * The replaceAndL() method will receive the modifiedFormula and search it for any &l operators.
     * It will determine the portion of the formula after the &l operator that applies to it, remove
     * this portion from the formula, and add it to the last section(state) of the ModifiedFormula.
     * Once all of the &l operations have been performed, it will return the resulting 
     * andLModifiedFormula to the SpecialOperator class.
     */
	public String replaceAndL(String modifiedFormula) {
		
		FormulaSplicer splicer = new FormulaSplicer();
		String andLModifiedFormula = modifiedFormula;
		int searchPosition = andLModifiedFormula.length() - 1;
		
		while (searchPosition > 0) {
			if (andLModifiedFormula.charAt(searchPosition) == 'l') {
				searchPosition--;
				if (andLModifiedFormula.charAt(searchPosition) == '&') {
					String subFormulaToAdd = splicer.getSubformulaToAdd(andLModifiedFormula, searchPosition + 1);
					andLModifiedFormula = splicer.removeSubformula(andLModifiedFormula, searchPosition, searchPosition + 1 + subFormulaToAdd.length());
					searchPosition--;
					while (andLModifiedFormula.substring(searchPosition, searchPosition + 1).matches(
							"\\)")) {
						searchPosition--;
					}
					andLModifiedFormula = splicer.addSubformula(andLModifiedFormula, "&" + subFormulaToAdd,searchPosition + 1);
				}
			}
			searchPosition--;
		}
		return andLModifiedFormula;
	}
}
