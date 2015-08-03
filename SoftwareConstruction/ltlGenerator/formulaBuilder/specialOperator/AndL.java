package ltlGenerator.formulaBuilder.specialOperator;

import ltlGenerator.formulaBuilder.specialOperator.FormulaSplicer;

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

	private static final String END_PARENTHESIS = "\\)";

public String replaceAndL(String modifiedFormula) {
		
		FormulaSplicer splicer = new FormulaSplicer();
		String andLModifiedFormula = modifiedFormula;
		int searchPosition = andLModifiedFormula.length() - 1;
		
		//Starts searching from the end of the formula to the beginning of the formula
		while (searchPosition > 0) {
			//Searches for the &l operator
			if (andLModifiedFormula.charAt(searchPosition) == 'l') {
				searchPosition--;
				if (andLModifiedFormula.charAt(searchPosition) == '&') {
					//Gets the portion of the formula after the &l operator
					String subFormulaToAdd = splicer.getSubformulaToAdd(andLModifiedFormula, searchPosition + 1);
					//Removes the &r operator and the subformula it is splicing into the portion before the &r
					andLModifiedFormula = splicer.removeSubformula(andLModifiedFormula, searchPosition, searchPosition + 1 + subFormulaToAdd.length());
					searchPosition--;
					//Finds the beginning of the last set of close parentheses before the position of the &l operator
					while (andLModifiedFormula.substring(searchPosition, searchPosition + 1).matches(END_PARENTHESIS)) {
						searchPosition--;
					}
					//Adds the splice information to the location found in the previous step
					andLModifiedFormula = splicer.addSubformula(andLModifiedFormula, "^" + subFormulaToAdd,searchPosition + 1);
				}
			}
			//Continues searching for &l operators until it reaches the beginning of the formula string
			searchPosition--;
		}
		//returns the formula with splices inserted in accordance with all &l operators contained in original formula
		return andLModifiedFormula;
	}
}
