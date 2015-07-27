/*Contains string substitution data for each possible pattern given the
 * After L until R scope.It will return the formula template with the 
 * special & operators.
 * 
 */
public class AfterLUntilRTable {
	
	/* Method AfterLUntilRSubstitution() receives appropriate properties such as the string array containing a Scope, 
	 * a Pattern, and all necessary Proposition types and will do the string substituion given the after L until R
	 * scope and will return the template to the formula creator.
	 */
    
    public static String afterLUntilRCSubstitution(Pattern pat){
        
        baseFormula = " ";
        rSubFormula = " ";
        gSubFormula = " ";
        
        gSubFormula = GlobalTable.getGbaseFormula(Pattern pat);
        rSubFormula = AfterRTable.getRBaseFormula(Pattern pat);
        
        baseFormula = "[]((L &r !R) -> (L &l ((" + rSubFormula+ "^ ((!<>R) ->"+gSubFormula+")))))";
    
    }
    
    public static String afterLUntilRESubstitution(Pattern pat){
        
        baseFormula = " ";
        rSubFormula = " ";
        gSubFormula = " ";
        
        gSubFormula = GlobalTable.getGbaseFormula(Pattern pat);
        rSubFormula = AfterRTable.getRBaseFormula(Pattern pat);
        
        baseFormula = "[]((L) -> (L &l ((" + rSubFormula+ "^((!<>R) -> "+gSubFormula+")))))"
        
    }

}
