/*
Contains string substitution data for each possible patterns given any scope. 
Subclasses of the SubstitutionTable class include:
GlobalTable, BeforeRTable, AfterLUntilRTable, BetweenRTable, AfterLTable

*/
public class SubstitutionTable {
	
	/* Gets template formula with Scope scope */
	public static String getTable(Scope scope, Pattern pattern)
	{
		String formula = "";
		if(scope instanceof Global)
		{
			formula = SubstitutionTable.getTable((Global) scope, pattern);
		}
		else if (scope instanceof AfterL)
		{
			formula = SubstitutionTable.getTable((AfterL)scope, pattern);
		}
		else if (scope instanceof BeforeR)
		{
			formula = SubstitutionTable.getTable((BeforeR)scope, pattern);
		}
		else if (scope instanceof AfterLuntilR)	
		{
			formula = SubstitutionTable.getTable((AfterLuntilR)scope, pattern);
		}
		else if (scope instanceof BetweenLandR)
		{
			formula = SubstitutionTable.getTable((BetweenLandR)scope, pattern);
		}
		return formula;
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
		Proposition propositionL = scope.getPropositionL();
		return AfterLTable.getFormula(propositionL, pattern);
	} 
	
	/* Gets template formula for property of BeforeR scope.
	 */
	public static String getTable(BeforeR scope, Pattern pattern)
	{
		Proposition propositionR = scope.getPropositionR();
		return BeforeRTable.getFormula(propositionR, pattern);
	}
	
	/* Gets template formula for property of BetweenLandR scope.
	 */
	public static String getTable(BetweenLandR scope, Pattern pattern)
	{
		Proposition propositionL = scope.getPropositionL();
		Proposition propositionR = scope.getPropositionR();
		return BetweenLandRTable.getFormula(propositionL, propositionR, pattern);
	}
	
	/* Gets template formula for property of AfterLuntilR scope.
	 */
	public static String getTable(AfterLuntilR scope, Pattern pattern)
	{
		Proposition propositionL = scope.getPropositionL();
		Proposition propositionR = scope.getPropositionR();
		return AfterLUntilRTable.getFormula(propositionL, propositionR, pattern);
	}
}