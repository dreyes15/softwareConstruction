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
    
    public static String getBetweenLandRFormula(Precedence pattern, Proposition R){
        Precedence pat = pattern;
        String patternName = pattern.getPatternType();
        String baseFormula = "";
        Proposition propR = R;
        char RendLetter = getLastLetter(propR);
        String rSubFormula = BeforeRTable.getFormula(pat,propR);
        
        if(RendLetter == 'C' || RendLetter == 'c')
        {
            baseFormula = "[]((&!R)->(L&"+ rSubFormula +"))";
        }
        else if (RendLetter == 'E' || RendLetter == 'c')
        {
            baseFormula = "[](L->(L&" + rSubFormula + "))";
        }
        return baseFormula;
    }
    
    
    public static char getLastLetter(Proposition P){
        Proposition prop = P;
        String propType = prop.getType();
        char lastLetter = propType.charAt(propType.length()-1);
        return lastLetter;
    }
    
    public static void main (String args []){
        Proposition propP = new Atomic("P");
        Proposition propQ = new ParallelC("Q", 5);
        Precedence pattern = new Precedence(propP, propQ);
        System.out.println(getBetweenLandRFormula(pattern, propP));
    }
}
