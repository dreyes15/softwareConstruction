/*Contains string substitution data for each possible pattern given the
 * After L until propR scope.It will return the formula template with the 
 * special & operators.
 * 
 */
public class AfterLUntilRTable {
	
	private static String globalSubformula;
	private static String beforeRSubformula;
	
	/* Method AfterLUntilRSubstitution() receives appropriate properties such as the string array containing a Scope, 
	 * a Pattern, and all necessary Proposition types and will do the string substituion given the after L until propR
	 * scope and will return the template to the formula creator.
	 */
    public static String getFormula(Pattern pattern, Proposition propR) {    
    	
    	String formula = "";
        getSubformulas(pattern, propR);
        
        if(pattern instanceof Absence){
            formula = getFormula((Absence) pattern, propR);
        }
        else if(pattern instanceof Existence){
            formula = getFormula((Existence) pattern, propR);
        }
        else if (pattern instanceof StrictPrecedence){
            formula = getFormula((StrictPrecedence) pattern, propR);
        }
        else if (pattern instanceof Precedence){
            formula = getFormula((Precedence) pattern, propR);
        }
        else if (pattern instanceof Response){
            formula = getFormula((Response) pattern, propR);
        }
        return formula;
    }
    
    private static void getSubformulas(Pattern pattern, Proposition propR) {
    	globalSubformula = GlobalTable.getFormula(pattern);
    	beforeRSubformula = BeforeRTable.getFormula(pattern, propR);
    }
    
    public static String getFormula(Existence pattern, Proposition propR){
        
        String baseFormula = " ";
        char rLastLetter = LastLetter.getLastLetter(propR);
        
        if(LastLetter.isC(rLastLetter)){
            baseFormula = "[]((L&r!R)->(L&l((" + beforeRSubformula+ "^((!<>R)->"+globalSubformula+")))))";
        }
        else if(LastLetter.isE(rLastLetter)){
            baseFormula = "[]((L)->(L&l((" + beforeRSubformula+ "^((!<>R)->"+globalSubformula+")))))";
        }
        return baseFormula;
    }
    

    public static String getFormula(StrictPrecedence pattern, Proposition propR){
        
        String baseFormula = "";
        char rLastLetter = LastLetter.getLastLetter(propR);
        
        if(LastLetter.isC(rLastLetter)){
            baseFormula = "[]((L&r!R)->(L&l((" + beforeRSubformula+ "^((!<>R)->"+globalSubformula+")))))";
        }
        else if(LastLetter.isE(rLastLetter)){
            baseFormula = "[]((L)->(L&l((" + beforeRSubformula+ "^((!<>R)->"+globalSubformula+")))))";
        }
        return baseFormula;
    }
    
    public static String getFormula(Precedence pattern, Proposition propR){
        
        String baseFormula = "";
        char rLastLetter = LastLetter.getLastLetter(propR);
        
        if(LastLetter.isC(rLastLetter)){
            baseFormula = "[]((L&r!R)->(L&l((" + beforeRSubformula+ "^((!<>R)->"+globalSubformula+")))))";
        }
        else if(LastLetter.isE(rLastLetter)){
            baseFormula = "[]((L)->(L&l((" + beforeRSubformula+ "^((!<>R)->"+globalSubformula+")))))";
        }
        return baseFormula;
    }
    
    public static String getFormula(Absence pattern, Proposition propR){
        
        String baseFormula = "";
        char rLastLetter = LastLetter.getLastLetter(propR);
        
        if(LastLetter.isC(rLastLetter)){
            baseFormula = "[]((L&r!R)->(L&l((" + beforeRSubformula+ "^((!<>R)->"+globalSubformula+")))))";
        }
        else if(LastLetter.isE(rLastLetter)){
            baseFormula = "[]((L)->(L&l((" + beforeRSubformula+ "^((!<>R)->"+globalSubformula+")))))";
        }
        return baseFormula;
    }
    
    public static String getFormula(Response pattern, Proposition propR){
        
        String baseFormula = "";
        char rLastLetter = LastLetter.getLastLetter(propR);
        
        globalSubformula = GlobalTable.getFormula(pattern);
        beforeRSubformula = BeforeRTable.getFormula(pattern, propR);
        
        if(LastLetter.isC(rLastLetter)){
            baseFormula = "[]((L&r!R)->(L&l((" + beforeRSubformula+ "^((!<>R)->"+globalSubformula+")))))";
        }
        else if(LastLetter.isE(rLastLetter)){
            baseFormula = "[]((L)->(L&l((" + beforeRSubformula+ "^((!<>R)->"+globalSubformula+")))))";
        }
        return baseFormula;
    }
}