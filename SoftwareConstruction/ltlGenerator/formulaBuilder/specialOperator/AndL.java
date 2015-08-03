package ltlGenerator.formulaBuilder.specialOperator;

import ltlGenerator.formulaBuilder.specialOperator.FormulaSplicer;

/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity,
 * 		 Lucia Rodriguez, and David Reyes
 * Project: LTL Generator
 * Sprint: LTL Generator
 * Due Date: July 3, 2015
 *The purpose of this class is to add information to the last state of the portion of the LTL Formula to 
 *which the &l special operator applies.
 */
public class AndL {
	/*
	 * The replaceAndL() method will receive a formula string and search it for any &l operators.
	 * It will determine the portion of the formula after the &l operator that applies to it, remove
	 * this portion from the formula, and add it to the last section(state) of the portion of the original 
	 * formula to which it applies. Once all of the &l operations have been performed, it will return the 
	 * resulting andLModifiedFormula.
	 */

	private static final String END_PARENTHESIS = "\\)";

public String replaceAndL(String formula) {
		
		FormulaSplicer splicer = new FormulaSplicer();
		String andLModifiedFormula = formula;
		int searchPosition = andLModifiedFormula.length() - 1;
		
		//Starts searching from the end of the formula to the beginning of the formula
		while (searchPosition > 0) {
			
			//Searches for the &l operator
			if (andLModifiedFormula.charAt(searchPosition) == '&' && andLModifiedFormula.charAt(searchPosition+1) == 'l') {
					
					//Gets the portion of the formula after the &l operator
					String subFormulaToAdd = splicer.getSubformulaToAdd(andLModifiedFormula, searchPosition+1);
					
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
			//Continues searching for &l operators until it reaches the beginning of the formula string
			searchPosition--;
		}
		return andLModifiedFormula;
	}
}
