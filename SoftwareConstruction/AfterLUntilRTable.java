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
    
    public static String getFormula(Existence pattern, Propositon R){
        
        baseFormula = " ";
        rSubFormula = " ";
        gSubFormula = " ";
        
        char scopeLetter = getLastLetter(R);
        
        gSubFormula = GlobalTable.getFormula(pattern);
        rSubFormula = AfterRTable.getFormula(pattern);
        
        if(scopeLetter =="C" || scopeLetter =="c"){
            baseFormula = "[]((L &r !R) -> (L &l ((" + rSubFormula+ "^ ((!<>R) ->"+gSubFormula+")))))";
        }
        else if(scopeLetter =="E" || scopeLetter =="e"){
            baseFormula = "[]((L) -> (L &l ((" + rSubFormula+ "^((!<>R) -> "+gSubFormula+")))))";
        }
    }
    

    public static String getFormula(StrictPrecedence pattern, Propositon R){
        
        baseFormula = " ";
        rSubFormula = " ";
        gSubFormula = " ";
        
        char scopeLetter = getLastLetter(R);
        
        gSubFormula = GlobalTable.getFormula(pattern);
        rSubFormula = AfterRTable.getFormula(pattern);
        
        if(scopeLetter =="C" || scopeLetter =="c"){
            baseFormula = "[]((L &r !R) -> (L &l ((" + rSubFormula+ "^ ((!<>R) ->"+gSubFormula+")))))";
        }
        else if(scopeLetter =="E" || scopeLetter =="e"){
            baseFormula = "[]((L) -> (L &l ((" + rSubFormula+ "^((!<>R) -> "+gSubFormula+")))))";
        }
    }
    
    public static String getFormula(Precedence pattern, Propositon R){
        
        baseFormula = " ";
        rSubFormula = " ";
        gSubFormula = " ";
        
        char scopeLetter = getLastLetter(R);
        
        gSubFormula = GlobalTable.getFormula(pattern);
        rSubFormula = AfterRTable.getFormula(pattern);
        
        if(scopeLetter =="C" || scopeLetter =="c"){
            baseFormula = "[]((L &r !R) -> (L &l ((" + rSubFormula+ "^ ((!<>R) ->"+gSubFormula+")))))";
        }
        else if(scopeLetter =="E" || scopeLetter =="e"){
            baseFormula = "[]((L) -> (L &l ((" + rSubFormula+ "^((!<>R) -> "+gSubFormula+")))))";
        }
    }
    
    public static String getFormula(Absence pattern, Propositon R){
        
        baseFormula = " ";
        rSubFormula = " ";
        gSubFormula = " ";
        
        char scopeLetter = getLastLetter(R);
        
        gSubFormula = GlobalTable.getFormula(pattern);
        rSubFormula = AfterRTable.getFormula(pattern);
        
        if(scopeLetter =="C" || scopeLetter =="c"){
            baseFormula = "[]((L &r !R) -> (L &l ((" + rSubFormula+ "^ ((!<>R) ->"+gSubFormula+")))))";
        }
        else if(scopeLetter =="E" || scopeLetter =="e"){
            baseFormula = "[]((L) -> (L &l ((" + rSubFormula+ "^((!<>R) -> "+gSubFormula+")))))";
        }
    }
    
    public static String getFormula(Response pattern, Propositon R){
        
        baseFormula = " ";
        rSubFormula = " ";
        gSubFormula = " ";
        
        char scopeLetter = getLastLetter(R);
        
        gSubFormula = GlobalTable.getFormula(pattern);
        rSubFormula = AfterRTable.getFormula(pattern);
        
        if(scopeLetter =="C" || scopeLetter =="c"){
            baseFormula = "[]((L &r !R) -> (L &l ((" + rSubFormula+ "^ ((!<>R) ->"+gSubFormula+")))))";
        }
        else if(scopeLetter =="E" || scopeLetter =="e"){
            baseFormula = "[]((L) -> (L &l ((" + rSubFormula+ "^((!<>R) -> "+gSubFormula+")))))";
        }
    }
    
    private char getLastLetter(Proposition prop){
        Proposition proposition = prop;
        String propType= proposition.getType();
        char lastLetter = propType.charAt(propType.lenght-1);
        
        return lastLetter;
    }

}
