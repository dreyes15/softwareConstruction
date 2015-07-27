/*
 * This class is a type of scope that will describe the extent of
 * program execution over which property holds.
 *
 * With the given information this class should be able to generate itself
 * as the "Before R" scope.
 *
 * Before R will denote the execution before the first time the condition R holds.
 */
public class BeforeR extends Scope{
    
    /*Here we will need to declare a variable of type Proposition that will be used for
     * the following methods. For the purpose of this class we will be naming this variable R.
     */
    
    //initializing variable R of type Proposition;
    
    public BeforeR(Pattern pat, String PropType){
        /*This is a constructor method of type BeforeR. This class will extend
         * the Scope class, therefore the variables will be sent to the super class
         * to store the information.
         */
        
        
        String BaseFormula = "";
        
        if(PropType.equals("C")|| PropType.equals("c")){
            if(pat.equals("Absence")){
                BaseFormula ="!((!R)U((P&!R)&<>R)) ";
            }
            else if(pat.equals("Existence")) {
                BaseFormula = "!((!(P&!R))UR)";
            }
            else if(pat.equals("QPrecedesPC")){
                BaseFormula = "(<>R)->((!(P&!R))U((Q&!P)VR))";
            }
            else if (pat.equals("QPrecedesPE")){
                BaseFormula = "(<>R->((!((!p1^...^pn)^!R^X(P&R)))U((Q&!(P))VR))" ;
            }
            else if (pat.equals("QStrictlyPRecedsPC")){
                BaseFormula="(<>R)->((!(P&!R))U((Q&!P)VR))";
            }
            else if(pat.equals("QStrictlyPrecedesPE")){
                BaseFormula="((R)->((!((!P1^...^!PN)^!R^X(P&!R)))U((Q&!(P))VR))";
            }
            else if (pat.equals("QResponds")){
                BaseFormula="!((!R)U((P&!R)&((!Q&!R))UR)))";
            }
        }
        else{  									//PropType = "E"
            if(pat.equals("Absence")){
                BaseFormula ="(<>R)->!((!((!r1^...^!r)^X(R)))U(P&!R))";
            }
            else if (pat.equals("Existence")){
                BaseFormula ="(<>R)_>((!((!r1^...^!rn)^X(R)))U(P&!R))";
            }
            else if(pat.equals("QPrecedesPC")){
                BaseFormula= "(<>R)->(((!(P&R))U((Q&P)V((!r1^...^!rn)^XR))))";
            }
            else if(pat.equals("QPreceedesPE")){
                BaseFormula="(<>R)->((!((!p1^...^!pn)^!r^X(P&!R)))U((Q&!P)V((!r1^...^!rn)^XR)))";
            }
            else if(pat.equals("QStrictlyPrecedesPC")){
                BaseFormula="(<>R)->(((!(P&R))U((Q&!P)V((!r1^...^!rn)^XR))))";
            }
            else if (pat.equals("QStrictlyPrecedesPE")){
                BaseFormula="(<>R)->((!((!p1^...^!pn)^!R^X(P&!R)))U((Q&!P)V((!r1^...^!rn)^XR)))";
            }
            else if(pat.equals("QResponds")){
                BaseFormula="!((!((!r1^!r2^...^!rn)^X(R)))U((P&!R)&((!(Q&R))UR)))";
            }
        }
        
        
        
        
    }
    
    
}
