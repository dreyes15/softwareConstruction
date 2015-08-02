/*Contains string substitution data for each possible pattern given the
 * Before R scope.It will return the formula template with the
 * special & operators.
 *
 */
public class BeforeRTable {
    
    private static Proposition propR;
    private static Proposition propP;
    private static int pNumber;
    private static int rNumber;
    
    public static String getFormula(Pattern pattern, Proposition propositionR){
        
        propR = propositionR;
        rNumber = propR.getNumber();
        
        propP = pattern.getPropositionP();
        pNumber = propP.getNumber();
        
        String formula = "";
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
    
    public static String getFormula(Precedence pattern){
        
        String baseFormula ="";
        
        if(propR.isEventType())
        {
            if (propP.isEventType())
            {
                String subformula1 = "(<>R)->((!((";
                String subformula2 = getAllNotSubformula('p', pNumber);
                String subformula3 = "^!Rh^X(Ph&r!Rh)))U((Q&-l!Ph)V((";
                String subformula4 = getAllNotSubformula('r', rNumber);
                String subformula5 = ")^XRh)))";
                baseFormula= subformula1 + subformula2 + subformula3 + subformula4 + subformula5;
            }
            else {
                String subformula1 = "(<>R)->(((!(P&r!Rh))U((Q&-l!P)V((";
                String subformula2 = getAllNotSubformula('r', rNumber);
                String subformula3 = ")^XRh))))";
                baseFormula = subformula1 + subformula2 + subformula3;
            }
        }
        else {
            if (propP.isEventType())
            {
                String subformula1 = "((<>R->((!((";
                String subformula2 = getAllNotSubformula('p', pNumber);
                String subformula3 =")^!R^X(Ph&rR)))U((Q&-l!(Ph))VR))";
                baseFormula = subformula1 + subformula2 + subformula3;
            }
            else {
                baseFormula ="(<>R)->((!(P&r!R))U((Q&-l!P)VR))";
            }
        }
        return baseFormula;
    }
    
    public static String getFormula(Absence pattern){
        
        String baseFormula = "";
        
        if(propR.isEventType())
        {
            String subformula1 ="(<>R)->!((!((";
            String subformula2 = getAllNotSubformula('r', rNumber);
            String subformula3 = ")^X(Rh)))U(P&r!Rh))";
            baseFormula = subformula1 + subformula2 + subformula3;
        }
        else {
            baseFormula = "!((!R)U((P&!R)&l<>R))";
        }
        return baseFormula;
    }
    
    public static String getFormula(Existence pattern){
        
        String baseFormula = "";
        
        if (propR.isEventType())
        {
            String subformula1 = "(<>R)->((!((";
            String subformula2 = getAllNotSubformula('r', rNumber);
            String subformula3 = ")^X(Rh)))U(P&r!Rh))";
            baseFormula =subformula1 + subformula2 + subformula3;
        }
        else {
            baseFormula = "!((!(P&r!R))UR)";
        }
        return baseFormula;
    }
    
    public static String getFormula(StrictPrecedence pattern){
        
        String baseFormula = "";
        
        if(propR.isEventType()){
            if(propP.isEventType())
            {
                String subformula1="(<>R)->((!((";
                String subformula2 = getAllNotSubformula('p', pNumber);
                String subformula3 = ")^!Rh^X(Ph&r!Rh)))U((Q&r!Ph)V((";
                String subformula4 = getAllNotSubformula('r', rNumber);
                String subformula5= "^XRh)))";
                baseFormula = subformula1 + subformula2 + subformula3 + subformula4 + subformula5;
            }
            else {
                String subformula1="(<>R)->(((!(P&r!Rh))U((Q&r!P)V((";
                String subformula2 = getAllNotSubformula('r', rNumber);
                String subformula3= ")^XRh))))";
                baseFormula = subformula1 + subformula2 + subformula3;
            }
        }
        else {
            if (propP.isEventType())
            {
                String subformula1= "(<>R)->((!((";
                String subformula2 = getAllNotSubformula('p', pNumber);
                String subformula3= ")^!R^X(Ph&r!R)))U((Q&r!(Ph))VR))";
                baseFormula = subformula1 + subformula2 + subformula3;
            }
            else {
                baseFormula = "(<>R)->((!(P&r!R))U((Q&r!P)VR))";
            }
        }
        return baseFormula;
    }
    
    public static String getFormula(Response pattern){
        
        String baseFormula = "";
        
        if(propR.isEventType())
        {
            String subformula1 = "!((!((";
            String subformula2 = getAllNotSubformula('r', rNumber);
            String subformula3 = ")^X(Rh)))U((P&r!Rh)&l((!(Q&r!Rh))URh)))";
            baseFormula = subformula1 + subformula2 + subformula3;
        }
        else {
            baseFormula = "!((!R)U((P&r!R)&l((!(Q&r!R))UR)))";
        }
        return baseFormula;
    }
    
    private static String getAllNotSubformula(char propName, int propNumber) {
        String subformula = "";
        for (int i=1; i<propNumber-1; i++) {
            subformula += "!" + propName + i + "^";
        }
        subformula += "!" + propName + propNumber;
        return subformula;
    }
}