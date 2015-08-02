/*
Contains string substitution data for each possible patterns given any scope. 
Subclasses of the SubstitutionTable class include:
GlobalTable, BeforeRTable, AfterLUntilRTable, BetweenRTable, AfterLTable

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
}