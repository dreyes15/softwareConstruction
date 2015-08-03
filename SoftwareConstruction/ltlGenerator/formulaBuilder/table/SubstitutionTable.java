package ltlGenerator.formulaBuilder.table;
import ltlGenerator.propertyBuilder.patterns.Pattern;
import ltlGenerator.propertyBuilder.proposition.Proposition;
import ltlGenerator.propertyBuilder.scopes.AfterL;
import ltlGenerator.propertyBuilder.scopes.AfterLuntilR;
import ltlGenerator.propertyBuilder.scopes.BeforeR;
import ltlGenerator.propertyBuilder.scopes.BetweenLandR;
import ltlGenerator.propertyBuilder.scopes.Global;

/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity,
 * 		 Lucia Rodriguez, and David Reyes
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 * Purpouse: Contains string substitution data for each possible patterns given any scope.
 * Subclasses of the SubstitutionTable class include:
 * GlobalTable, BeforeRTable, AfterLUntilRTable, BetweenRTable, AfterLTable
*/
public class SubstitutionTable {

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