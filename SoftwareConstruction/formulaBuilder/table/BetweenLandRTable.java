package formulaBuilder.table;
import propertyBuilder.patterns.Absence;
import propertyBuilder.patterns.Existence;
import propertyBuilder.patterns.Pattern;
import propertyBuilder.patterns.Precedence;
import propertyBuilder.patterns.Response;
import propertyBuilder.patterns.StrictPrecedence;
import propertyBuilder.proposition.Proposition;

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
public class BetweenLandRTable extends SubstitutionTable {
    
	private static String beforeRSubformula;
	private static Proposition propR;
	
    /*Here we will need to declare two variables of type Proposition that will be used for
     * the following methods. For the purpose of this class we will be naming these variables
     * L and R.
     */
    
    public static String getFormula(Pattern pattern, Proposition propositionR){
        
    	propR = propositionR;
    	beforeRSubformula = BeforeRTable.getFormula(pattern, propR);
    	
    	String formula ="";
        if(pattern instanceof Absence)
        {
            formula = getFormula((Absence)pattern);
        }
        else if(pattern instanceof Precedence)
        {
            formula = getFormula((Precedence)pattern);
        }
        else if(pattern instanceof Existence)
        {
            formula = getFormula((Existence)pattern);
        }
        else if (pattern instanceof StrictPrecedence){
            formula = getFormula((StrictPrecedence)pattern);
        }
        else if(pattern instanceof Response){
            formula = getFormula((Response)pattern);
        }
        return formula;
    }
    
    public static String getFormula(Absence pattern){
 
    	String baseFormula ="";
 
        if(propR.isEventType()) {
            baseFormula = "[](L->(L&l"+beforeRSubformula+"))";
        }
        else {
        	baseFormula = "[]((L&l!R)->(L&l"+ beforeRSubformula+"))";
        }
        return baseFormula;
    }
    
    public static String getFormula(Precedence pattern){
    	
        String baseFormula ="";

        if(propR.isEventType()) {
            baseFormula = "[](L->(L&l"+beforeRSubformula+"))";
        }
        else {
        	baseFormula = "[]((L&l!R)->(L&l"+ beforeRSubformula+"))";
        }
        return baseFormula;
    }
    
    public static String getFormula(Existence pattern){
        
    	String baseFormula ="";

        if(propR.isEventType()) {
            baseFormula = "[](L->(L&l"+beforeRSubformula+"))";
        }
        else {
        	baseFormula = "[]((L&l!R)->(L&l"+ beforeRSubformula+"))";
        }
        return baseFormula;
    }
    
    public static String getFormula(StrictPrecedence pattern){
        
    	String baseFormula ="";

        if(propR.isEventType()) {
            baseFormula = "[](L->(L&l"+beforeRSubformula+"))";
        }
        else {
        	baseFormula = "[]((L&l!R)->(L&l"+ beforeRSubformula+"))";
        }
        return baseFormula;
    }
    
    public static String getFormula(Response pattern){
        
    	String baseFormula ="";
 
        if(propR.isEventType()) {
            baseFormula = "[](L->(L&l"+beforeRSubformula+"))";
        }
        else {
        	baseFormula = "[]((L&l!R)->(L&l"+ beforeRSubformula+"))";
        }
        return baseFormula;
    }
}