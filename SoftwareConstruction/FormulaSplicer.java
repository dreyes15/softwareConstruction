import java.util.Stack;
/*
 * The purpose of this class is to perform the splicing operations required by the various special
 * operators (&r, &l, and &-l).
 */
public class FormulaSplicer {
    /*
     * getSubformulaToAdd() receives a modifiedFormula string and special operator position. It 
     * determines the portion of the formula that needs to be spliced into the formula and returns 
     * this information to the calling method.
     */
	public String getSubformulaToAdd(String modifiedFormula, int specOpPosition) {
		
		String formulaToDivide = modifiedFormula;
		int startSubformulaPosition = specOpPosition +1;
		
		int endSubformulaPosition = getEndSubformulaToAddPosition(formulaToDivide, startSubformulaPosition);
		String subformulaToAdd = formulaToDivide.substring(startSubformulaPosition, endSubformulaPosition);
		return subformulaToAdd;
	}
	/*
	 * getEndSubformulaToAddPosition() receives a formulaToDivide string and the starting position of
	 * the portion of the formula that needs to be spliced from the getSubformulaToAdd() method.  It
	 * determines the end position of this portion of the formula and returns it to the 
	 * getSubformulaToAdd() method.
	 */
	private int getEndSubformulaToAddPosition(String formulaToDivide, int startSubformulaPosition) {
		
		Stack<Character> parenthesisMatcher = new Stack<Character>();
		
		for (int endPosition = startSubformulaPosition; endPosition < formulaToDivide.length(); endPosition++) {
			char currentCharacter = formulaToDivide.charAt(endPosition);
			if (currentCharacter == '(') {
				parenthesisMatcher.push(currentCharacter);
			}	
			else if (currentCharacter == ')') {
				parenthesisMatcher.pop();
				if (parenthesisMatcher.isEmpty()) {
					return endPosition+1;
				}
			}
		}
		return formulaToDivide.length() - 1;
	}
	/*
	 * addSubformula() receives a modifiedFormula string, a subformulaToAdd string, and the position
	 * in the modifiedFormula string where the subformulaToAdd string needs to be added.  It splices
	 * the formulaToAdd into the modifiedFormula at this position and returns the results to the
	 * calling method.
	 */
	public String addSubformula(String modifiedFormula, String subformulaToAdd, int addPosition) {
		String splicedFormula = modifiedFormula.substring(0, addPosition) + subformulaToAdd + modifiedFormula.substring(addPosition, modifiedFormula.length());
		return splicedFormula;
	}
	/*
	 * removeSubformula() receives a modifiedFormula string, along with the starting and ending
	 * positions of the subformula that needs to be spliced.  It removes the subformula and returns
	 * the resulting splicedFormula to the calling method.
	 */
	public String removeSubformula(String modifiedFormula, int startPosition, int endPosition) {
		String splicedFormula = modifiedFormula.substring(0, startPosition) + modifiedFormula.substring(endPosition + 1, modifiedFormula.length());
		return splicedFormula;
	}
	/*
	 * getBeginSubformulaToSplicePosition() receives a modifiedFormula string and the end position of
	 * the subformula that the additional information needs to be spliced into.  It performs a reverse
	 * search through this subformula counting up for each end parenthesis and counting down for each
	 * opening parenthesis.  When this count zeroes out, the method returns the final position to the 
	 * calling method.
	 */
	public int getBeginSubformulaToSplicePosition(String modifiedFormula, int endPosition) {
		
		Stack<Character> parenthesisMatcher = new Stack<Character>();
		
		for (int startPosition = endPosition-1; startPosition > -1; startPosition--) {
			char currentCharacter = modifiedFormula.charAt(startPosition);
			if (currentCharacter == ')') {
				parenthesisMatcher.push(currentCharacter);
			}
			else if (currentCharacter == '(') {
				if (parenthesisMatcher.isEmpty())
					return startPosition + 1;
				else {
					parenthesisMatcher.pop();
					if (parenthesisMatcher.isEmpty())
						return startPosition;
				}
			}
		}
		return 0;
	}
	/*
	 * getEndSubformulaToSplicePosition() receives a modifiedFormula string and the position of the 
	 * special operator that is being performed on the modifiedFormula.  It performs a reverse
	 * search through the modifiedFormula until if comes to the beginning of the first set of 
	 * opening parenthesis.  It returns this position to the calling method.
	 */
	public int getEndSubformulaToSplicePosition(String modifiedFormula, int specOpPosition) {
		int endSplicePosition = specOpPosition-1;
		char currentCharacter = modifiedFormula.charAt(endSplicePosition);
		while (currentCharacter != '(') {
			endSplicePosition--;
			currentCharacter = modifiedFormula.charAt(endSplicePosition);
		}
		return endSplicePosition;
	}
}
