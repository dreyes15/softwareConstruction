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
		
		while (searchPosition > 0) {
			if (andNotLModifiedFormula.charAt(searchPosition) == 'l') {
				searchPosition--;
				if (andNotLModifiedFormula.charAt(searchPosition) == '-') {
					String subformulaToAdd = splicer.getSubformulaToAdd(andNotLModifiedFormula, searchPosition + 1);
					if (PropQ.matches("AtLeastOneC") || PropQ.matches("ParallelC")){
						andNotLModifiedFormula = splicer.removeSubformula(andNotLModifiedFormula, searchPosition, searchPosition + 1);
					}
					else if (PropQ.matches("AtLeastOneE") || PropQ.matches("ParallelE")){
						//insert method to add subformulaToAdd to first two states
						andNotLModifiedFormula = splicer.removeSubformula(andNotLModifiedFormula, searchPosition-1, searchPosition + 1 + subformulaToAdd.length());
						searchPosition = searchPosition - 2;
						andNotLModifiedFormula = splicer.addSubformula(andNotLModifiedFormula, "&" + subformulaToAdd, searchPosition);
					}
					else if (PropQ.matches("ConsecutiveC") || PropQ.matches("EventualC")){
						andNotLModifiedFormula = splicer.removeSubformula(andNotLModifiedFormula, searchPosition-1, searchPosition + 1 + subformulaToAdd.length());
						searchPosition--;
						int startPosition = splicer.getBeginSubformulaToSplicePosition(andNotLModifiedFormula, searchPosition);
						while (startPosition < searchPosition) {
							startPosition++;
							if (andNotLModifiedFormula.substring(startPosition,startPosition+1).matches("X")) {
								andNotLModifiedFormula = splicer.addSubformula(andNotLModifiedFormula, subformulaToAdd + "&", startPosition);
								searchPosition += subformulaToAdd.length();
								startPosition += subformulaToAdd.length()+1;
							}
							else if (andNotLModifiedFormula.substring(startPosition,startPosition+1).matches("U")) {
								andNotLModifiedFormula = splicer.addSubformula(andNotLModifiedFormula, "&" + subformulaToAdd, startPosition - 1);
								searchPosition += subformulaToAdd.length();
								startPosition += subformulaToAdd.length()+1;
							}
						}
					}
					else if (PropQ.matches("ConsecutiveE") || PropQ.matches("EventualE")){
						//insert method to add subformulaToAdd to first state
						andNotLModifiedFormula = splicer.removeSubformula(andNotLModifiedFormula, searchPosition-1, searchPosition + 1 + subformulaToAdd.length()); 
						searchPosition--;
						int startPosition = splicer.getBeginSubformulaToSplicePosition(andNotLModifiedFormula, searchPosition);
						while (startPosition < searchPosition) {
							startPosition++;
							if (andNotLModifiedFormula.substring(startPosition,startPosition+1).matches("X")) {
								andNotLModifiedFormula = splicer.addSubformula(andNotLModifiedFormula, subformulaToAdd + "&", startPosition);
								searchPosition += subformulaToAdd.length();
								startPosition += subformulaToAdd.length()+1;
							}
							else if (andNotLModifiedFormula.substring(startPosition,startPosition+1).matches("U")) {
								andNotLModifiedFormula = splicer.addSubformula(andNotLModifiedFormula, "&" + subformulaToAdd, startPosition - 1);
								searchPosition += subformulaToAdd.length();
								startPosition += subformulaToAdd.length()+1;
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
