/*
 * This class is a type of scope that will describe the extent of
 * program execution over which property holds.
 *
 * With the given information this class should be able to generate itself
 * as the "Between L and R" scope.
 *
 * Between L and R will denote the execution between intervals define by L and R.
 *
 */
public class BetweenLandRTable extends Scope{
    
    /*Here we will need to declare two variables of type Proposition that will be used for
     * the following methods. For the purpose of this class we will be naming these variables
     * L and R.
     */
    
    public static String getFormula(Absence pattern, Proposition R){
        String baseFormula ="";
        String rSubFormula = "";
        
        char scopeLetter = getLastLetter(R);
        rSubFormula = BeforeRTable.getFormula(pattern, R);
        
        if(scopeLetter == 'C' || scopeLetter == 'c'){
            baseFormula = "[]((L&!R)->(L&"+ rSubFormula+"))";
        }
        else if(scopeLetter == 'E' || scopeLetter =='e') {
            baseFormula = "[](L->(L&"+rSubFormula+"))";
        }
        return baseFormula;
    }
    
    public static String getFormula(Precedence pattern, Proposition R){
        String baseFormula ="";
        String rSubFormula = "";
        
        char scopeLetter = getLastLetter(R);
        rSubFormula = BeforeRTable.getFormula(pattern, R);
        
        if(scopeLetter == 'C' || scopeLetter == 'c'){
            baseFormula = "[]((L&!R)->(L&"+ rSubFormula+"))";
        }
        else if(scopeLetter == 'E'|| scopeLetter == 'e') {
            baseFormula = "[](L->(L&"+rSubFormula+"))";
        }
        return baseFormula;
    }
    
    public static String getFormula(Existence pattern, Proposition R){
        String baseFormula ="";
        String rSubFormula = "";
        
        char scopeLetter = getLastLetter(R);
        rSubFormula = BeforeRTable.getFormula(pattern, R);
        
        if(scopeLetter == 'C' || scopeLetter == 'c'){
            baseFormula = "[]((L&!R)->(L&"+ rSubFormula+"))";
        }
        else if(scopeLetter == 'E' || scopeLetter == 'e') {
            baseFormula = "[](L->(L&"+rSubFormula+"))";
        }
        return baseFormula;
    }
    
    public static String getFormula(StrictPrecedence pattern,Proposition R ){
        String baseFormula ="";
        String rSubFormula = "";
        
        char scopeLetter = getLastLetter(R);
        rSubFormula = BeforeRTable.getFormula(pattern, R);
        
        if(scopeLetter == 'C' || scopeLetter == 'c'){
            baseFormula = "[]((L&!R)->(L&"+ rSubFormula+"))";
        }
        else if(scopeLetter == 'E'|| scopeLetter == 'e') {
            baseFormula = "[](L->(L&"+rSubFormula+"))";
        }
        return baseFormula;
    }
    
    public static String getFormula(Response pattern, Proposition R){
        String baseFormula ="";
        String rSubFormula = "";
        
        char scopeLetter = getLastLetter(R);
        rSubFormula = BeforeRTable.getFormula(pattern, R);
        
        if(scopeLetter == 'C' || scopeLetter == 'c'){
            baseFormula = "[]((L&!R)->(L&"+ rSubFormula+"))";
        }
        else if(scopeLetter == 'E' || scopeLetter == 'e') {
            baseFormula = "[](L->(L&"+rSubFormula+"))";
        }
        return baseFormula;
    }
    
    public static char getLastLetter(Proposition R){
        Proposition prop = R;
        String propType = prop.getType();
        char lastLetter = propType.charAt(propType.length()-1);
        return lastLetter;
    }
}
