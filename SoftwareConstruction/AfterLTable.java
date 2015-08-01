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
