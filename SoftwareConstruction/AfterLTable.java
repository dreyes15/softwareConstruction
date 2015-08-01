/*Contains the string substitution for each possible pattern given the
 * After L scope.It will return the formula template with the 
 * special & operators.
 * 
 */
public class AfterLTable {
	/* Method AfterLSubstitution() receives appropriate properties such as the string array containing a Scope, 
	 * a Pattern, and all necessary Proposition types and will do the string substituion given the after L 
	 * scope and will return the template to the formula creator.
	 */
	
	public static void getFormula(Pattern pattern) {
		if (pattern instanceof Absence) {
			getFormula((Absence) pattern);
		}
		else if (pattern instanceof Existence) {
			getFormula((Existence) pattern);
		}
		else if (pattern instanceof Response) {
			getFormula((Response) pattern);
		}
		else if (pattern instanceof Precedence) {
			getFormula((Precedence) pattern);
		}
		else if (pattern instanceof StrictPrecedence) {
			getFormula((StrictPrecedence) pattern);
		}
	}
	
	public static String getFormula(Absence pat){
		
		String baseFormula = " ";
		String gSubFormula = " ";
		
		gSubFormula = GlobalTable.getFormula(pat);
		
		baseFormula = " !((!L)U(L&l!" + gSubFormula + "))";
		
		return baseFormula;
	}
	
	public static String getFormula(Existence pat){
		
		String baseFormula = " ";
		String gSubFormula = " ";
		
		gSubFormula = GlobalTable.getFormula(pat);
		
		baseFormula = " !((!L)U(L&l!" + gSubFormula + "))";
		
		return baseFormula;
	}
	
	public static String getFormula(Precedence pat){
		
		String baseFormula = " ";
		String gSubFormula = " ";
		
		gSubFormula = GlobalTable.getFormula(pat);
		
		baseFormula = " !((!L)U(L&l!" + gSubFormula + "))";
		
		return baseFormula;
	}
	
	public static String getFormula(StrictPrecedence pat){
		
		String baseFormula = " ";
		String gSubFormula = " ";
		
		gSubFormula = GlobalTable.getFormula(pat);
		
		baseFormula = " !((!L)U(L&l!" + gSubFormula + "))";
		
		return baseFormula;
	}
	
	public static String getFormula(Response pat){
		
		String baseFormula = " ";
		String gSubFormula = " ";
		
		gSubFormula = GlobalTable.getFormula(pat);
		
		baseFormula = " !((!L)U(L&l!" + gSubFormula + "))";
		
		return baseFormula;
	}
}
