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
    public static String getFormula(Pattern pattern, Proposition R){
        String formula = "";
        
        if(pattern instanceof Absence){
            formula = getFormula((Absence) pattern, R);
        }
        else if(pattern instanceof Existence){
            formula = getFormula((Existence) pattern, R);
        }
        else if (pattern instanceof StrictPrecedence){
            formula = getFormula((StrictPrecedence) pattern, R);
        }
        else if (pattern instanceof Precedence){
            formula = getFormula((Precedence) pattern, R);
        }
        else if (pattern instanceof Response){
            formula = getFormula((Response) pattern, R);
        }
        return formula;
    }
    
    public static String getFormula(Existence pattern, Proposition R){
        
        String baseFormula = " ";
        String rSubFormula = " ";
        String gSubFormula = " ";
        
        char rLastLetter = LastLetter.getLastLetter(R);
        
        gSubFormula = GlobalTable.getFormula(pattern);
        rSubFormula = BeforeRTable.getFormula(pattern, R);
        
        if(LastLetter.isC(rLastLetter)){
            baseFormula = "[]((L&r!R)->(L&l((" + rSubFormula+ "^((!<>R)->"+gSubFormula+")))))";
        }
        else if(LastLetter.isE(rLastLetter)){
            baseFormula = "[]((L)->(L&l((" + rSubFormula+ "^((!<>R)->"+gSubFormula+")))))";
        }
        return baseFormula;
    }
    

    public static String getFormula(StrictPrecedence pattern, Proposition R){
        
        String baseFormula = "";
        String rSubFormula = "";
        String gSubFormula = "";
        
        char rLastLetter = LastLetter.getLastLetter(R);
        
        gSubFormula = GlobalTable.getFormula(pattern);
        rSubFormula = BeforeRTable.getFormula(pattern, R);
        
        if(LastLetter.isC(rLastLetter)){
            baseFormula = "[]((L&r!R)->(L&l((" + rSubFormula+ "^((!<>R)->"+gSubFormula+")))))";
        }
        else if(LastLetter.isE(rLastLetter)){
            baseFormula = "[]((L)->(L&l((" + rSubFormula+ "^((!<>R)->"+gSubFormula+")))))";
        }
        return baseFormula;
    }
    
    public static String getFormula(Precedence pattern, Proposition R){
        
        String baseFormula = "";
        String rSubFormula = "";
        String gSubFormula = "";
        
        char rLastLetter = LastLetter.getLastLetter(R);
        
        gSubFormula = GlobalTable.getFormula(pattern);
        rSubFormula = BeforeRTable.getFormula(pattern, R);
        
        if(LastLetter.isC(rLastLetter)){
            baseFormula = "[]((L&r!R)->(L&l((" + rSubFormula+ "^((!<>R)->"+gSubFormula+")))))";
        }
        else if(LastLetter.isE(rLastLetter)){
            baseFormula = "[]((L)->(L&l((" + rSubFormula+ "^((!<>R)->"+gSubFormula+")))))";
        }
        return baseFormula;
    }
    
    public static String getFormula(Absence pattern, Proposition R){
        
        String baseFormula = "";
        String rSubFormula = "";
        String gSubFormula = "";
        
        char rLastLetter = LastLetter.getLastLetter(R);
        
        gSubFormula = GlobalTable.getFormula(pattern);
        rSubFormula = BeforeRTable.getFormula(pattern, R);
        
        if(LastLetter.isC(rLastLetter)){
            baseFormula = "[]((L&r!R)->(L&l((" + rSubFormula+ "^((!<>R)->"+gSubFormula+")))))";
        }
        else if(LastLetter.isE(rLastLetter)){
            baseFormula = "[]((L)->(L&l((" + rSubFormula+ "^((!<>R)->"+gSubFormula+")))))";
        }
        return baseFormula;
    }
    
    public static String getFormula(Response pattern, Proposition R){
        
        String baseFormula = "";
        String rSubFormula = "";
        String gSubFormula = "";
        
        char rLastLetter = LastLetter.getLastLetter(R);
        
        gSubFormula = GlobalTable.getFormula(pattern);
        rSubFormula = BeforeRTable.getFormula(pattern, R);
        
        if(LastLetter.isC(rLastLetter)){
            baseFormula = "[]((L&r!R)->(L&l((" + rSubFormula+ "^((!<>R)->"+gSubFormula+")))))";
        }
        else if(LastLetter.isE(rLastLetter)){
            baseFormula = "[]((L)->(L&l((" + rSubFormula+ "^((!<>R)->"+gSubFormula+")))))";
        }
        return baseFormula;
    }
}