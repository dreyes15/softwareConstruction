package ltlGenerator.formulaBuilder.table;
import ltlGenerator.propertyBuilder.patterns.Pattern;
import ltlGenerator.propertyBuilder.proposition.Proposition;
import ltlGenerator.propertyBuilder.scopes.AfterL;
import ltlGenerator.propertyBuilder.scopes.AfterLuntilR;
import ltlGenerator.propertyBuilder.scopes.BeforeR;
import ltlGenerator.propertyBuilder.scopes.BetweenLandR;
import ltlGenerator.propertyBuilder.scopes.Global;
import ltlGenerator.propertyBuilder.scopes.Scope;

/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity,
 * 		 Lucia Rodriguez, and David Reyes
 * Project: LTL Generator
 * Due Date: August 3, 2015
*/
public class SubstitutionTable {
	
	public static String getTable(Scope scope, Pattern pattern) {
		String baseFormula = "";
		
		if (scope instanceof Global) {
			baseFormula = SubstitutionTable.getTable((Global) scope, pattern);
		}
		else if (scope instanceof AfterL) {
			baseFormula = SubstitutionTable.getTable((AfterL) scope, pattern);
		}
		else if (scope instanceof BeforeR) {
			baseFormula = SubstitutionTable.getTable((BeforeR) scope, pattern);
		}
		else if (scope instanceof BetweenLandR) {
			baseFormula = SubstitutionTable.getTable((BetweenLandR) scope, pattern);
		}
		else if (scope instanceof AfterLuntilR) {
			baseFormula = SubstitutionTable.getTable((AfterLuntilR) scope, pattern);
		}
		return baseFormula;
	}

	/* Gets template formula for property of Global scope.
	 */
	public static String getTable(Global scope, Pattern pattern)
	{
		return GlobalTable.getFormula(pattern);
	}
	
	/* Gets template formula for property of AfterL scope.
	 */
	public static String getTable(AfterL scope, Pattern pattern)
	{
		return AfterLTable.getFormula(pattern);
	} 
	
	/* Gets template formula for property of BeforeR scope.
	 */
	public static String getTable(BeforeR scope, Pattern pattern)
	{
		Proposition propositionR = scope.getPropositionR();
		return BeforeRTable.getFormula(pattern, propositionR);
	}
	
	/* Gets template formula for property of BetweenLandR scope.
	 */
	public static String getTable(BetweenLandR scope, Pattern pattern)
	{
		Proposition propositionR = scope.getPropositionR();
		return BetweenLandRTable.getFormula(pattern, propositionR);
	}
	
	/* Gets template formula for property of AfterLuntilR scope.
	 */
	public static String getTable(AfterLuntilR scope, Pattern pattern)
	{
		Proposition propositionR = scope.getPropositionR();
		return AfterLUntilRTable.getFormula(pattern, propositionR);
	}
	
	protected static String getAllNotSubformula(char propName, int propNumber) {
		String subformula = "";
		for (int i=1; i<propNumber-1; i++) {
			subformula += "!" + propName + i + "^";
		}
		subformula += "!" + propName + propNumber;
		return subformula;
	}
}