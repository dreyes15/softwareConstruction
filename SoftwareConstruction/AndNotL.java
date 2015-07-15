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
	public String replaceAndNotL(String modifiedFormula, Proposition Q) {

		String PropQ = Q.getType();
		FormulaSplicer splicer = new FormulaSplicer();
		String andNotLModifiedFormula = modifiedFormula;
		int searchPosition = andNotLModifiedFormula.length() - 1;
		
		if (PropQ.matches("AtLeastOneC") || PropQ.matches("ParallelC")){
			while (searchPosition > 0) {
				if (andNotLModifiedFormula.charAt(searchPosition) == 'l') {
					searchPosition--;
					if (andNotLModifiedFormula.charAt(searchPosition) == '-') {
						andNotLModifiedFormula = splicer.removeSubformula(andNotLModifiedFormula, searchPosition, searchPosition + 1);
					}
				}
				searchPosition--;
			}
			return andNotLModifiedFormula;
		}
		else if (PropQ.matches("AtLeastOneE") || PropQ.matches("ParallelE")){
			while (searchPosition > 0) {
				if (andNotLModifiedFormula.charAt(searchPosition) == 'l') {
					searchPosition--;
					if (andNotLModifiedFormula.charAt(searchPosition) == '-') {
						String subFormulaToAdd = splicer.getSubformulaToAdd(andNotLModifiedFormula, searchPosition + 1);
						andNotLModifiedFormula = splicer.removeSubformula(andNotLModifiedFormula, searchPosition-1, searchPosition + 1 + subFormulaToAdd.length());
						searchPosition--;
						while (andNotLModifiedFormula.substring(searchPosition-1, searchPosition).matches(
								"\\)")) {
							searchPosition--;
						}
						andNotLModifiedFormula = splicer.addSubformula(andNotLModifiedFormula, "&" + subFormulaToAdd,searchPosition + 1);
					}
				}
				searchPosition--;
			}
			return andNotLModifiedFormula;
		}
		else if (PropQ.matches("ConsecutiveC") || PropQ.matches("EventualC")){
			while (searchPosition > 0) {
				if (andNotLModifiedFormula.charAt(searchPosition) == 'l') {
					searchPosition--;
					if (andNotLModifiedFormula.charAt(searchPosition) == '-') {
						String subFormulaToAdd = splicer.getSubformulaToAdd(andNotLModifiedFormula, searchPosition + 1);
						andNotLModifiedFormula = splicer.removeSubformula(andNotLModifiedFormula, searchPosition-1, searchPosition + 1 + subFormulaToAdd.length());
						searchPosition--;
						int startPosition = splicer.getBeginSubformulaToSplicePosition(andNotLModifiedFormula, searchPosition);
						while (startPosition < searchPosition) {
							startPosition++;
							if (andNotLModifiedFormula.substring(startPosition,startPosition+1).matches("X")) {
								andNotLModifiedFormula = splicer.addSubformula(andNotLModifiedFormula, subFormulaToAdd + "&", startPosition);
								searchPosition += subFormulaToAdd.length();
								startPosition += subFormulaToAdd.length()+1;
							}
							else if (andNotLModifiedFormula.substring(startPosition,startPosition+1).matches("U")) {
								andNotLModifiedFormula = splicer.addSubformula(andNotLModifiedFormula, "&" + subFormulaToAdd, startPosition - 1);
								searchPosition += subFormulaToAdd.length();
								startPosition += subFormulaToAdd.length()+1;
							}
						}
					}
				}
				searchPosition--;
			}
			return andNotLModifiedFormula;
		}
		else if (PropQ.matches("ConsecutiveE") || PropQ.matches("EventualE")){
			while (searchPosition > 0) {
				if (andNotLModifiedFormula.charAt(searchPosition) == 'l') {
					searchPosition--;
					if (andNotLModifiedFormula.charAt(searchPosition) == '-') {
						String subFormulaToAdd = splicer.getSubformulaToAdd(andNotLModifiedFormula, searchPosition + 1);
						andNotLModifiedFormula = splicer.removeSubformula(andNotLModifiedFormula, searchPosition-1, searchPosition
								+ 1 + subFormulaToAdd.length()); 
						searchPosition--;
						int startPosition = splicer.getBeginSubformulaToSplicePosition(andNotLModifiedFormula, searchPosition);
						int endPosition = splicer.getEndSubformulaToSplicePosition(andNotLModifiedFormula, searchPosition);
						while (startPosition < endPosition) {
							startPosition++;
							if (andNotLModifiedFormula.substring(startPosition,startPosition+1).matches(
									"\\)") && !andNotLModifiedFormula.substring(startPosition-1,startPosition).matches(
											"\\)")) {
								andNotLModifiedFormula = splicer.addSubformula(andNotLModifiedFormula, "&" + subFormulaToAdd,
										startPosition);
								endPosition += subFormulaToAdd.length();
								startPosition += subFormulaToAdd.length()+1;
							}
							else if (andNotLModifiedFormula.substring(startPosition,startPosition+1).matches(
									"X")) {
								andNotLModifiedFormula = splicer.addSubformula(andNotLModifiedFormula, subFormulaToAdd + "&",
										startPosition);
								endPosition += subFormulaToAdd.length();
								startPosition += subFormulaToAdd.length()+1;
							}
						}
					}
				}
				searchPosition--;
			}
		}
		return andNotLModifiedFormula;	
	}
}
