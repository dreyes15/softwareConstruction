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
    
    public BeforeR(Pattern pat, Proposition R){
        /*This is a constructor method of type BeforeR. This class will extend
         * the Scope class, therefore the variables will be sent to the super class
         * to store the information.
         */
        
        //set variable R be equal to the parameter;
        Proposition r = R;
        String propType = r.getType();
        char rEndLetter= getLastLetter(r);
        
        String BaseFormula = "";
        String SubFormula1 = "";
        String SubFormula2 ="";
        String SubFormula3 = "";
        String SubFormula4 ="";
        String SubFormula5="";
        int pNumber = p.getNumber();
        int rNumber = r.getNumber();
        
        if(rEndLetter==('C')){    //if(propR.getType == "AtLeastOneC || ParallelC || etc.)
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
                
                SubFormula1 = "((<>R->((!((";
                for(int i =1; i< pNumber-1; i++){
                    SubFormula2+="!p"+i+"^";
                }
                SubFormula2+= "!p"+pNumber;
                SubFormula3 =")^!R^X(Ph&R)))U((Q&!(Ph))VR))";
                BaseFormula = SubFormula1+SubFormula2+SubFormula3;
            }
            else if (pat.equals("QStrictlyPrecedsPC")){
                BaseFormula="(<>R)->((!(P&!R))U((Q&!P)VR))";
            }
            else if(pat.equals("QStrictlyPrecedesPE"))
            {
                SubFormula1= "((R)->((!((";
                for(int i =1; i<pNumber-1; i++){
                    SubFormula2+="!p"+i+"^";
                }
                SubFormula2+= "!p"+pNumber;
                SubFormula3= "^!R^X(Ph&!R)))U((Q&!(Ph))VR))";
                BaseFormula=SubFormula1+SubFormula2+SubFormula3 ;
            }
            else if (pat.equals("QResponds")){
                BaseFormula="!((!R)U((P&!R)&((!Q&!R))UR)))";
            }
        }
        
        else{  									//PropType = "E"
            if(pat.equals("Absence")){
                SubFormula1 ="(<>R)->!((!((";
                for(int i =1; i<rNumber-1; i++){
                    SubFormula2+="!r"+i+"^";
                }
                SubFormula2+= "!r"+rNumber;
                SubFormula3 = ")^X(Rh)))U(P&!Rh))";
                BaseFormula = SubFormula1+SubFormula2+SubFormula3;
            }
            
            else if (pat.equals("Existence")){
                SubFormula1 = "(<>R)_>((!((";
                for(int i =1; i<rNumber-1; i++){
                    SubFormula2+="!r"+i+"^";
                }
                SubFormula2+= "!r"+rNumber;
                SubFormula3 = ")^X(Rh)))U(P&!Rh))";
                BaseFormula =SubFormula1+SubFormula2+SubFormula3;
            }
            
            else if(pat.equals("QPrecedesPC")){
                SubFormula1 = "(<>R)->(((!(P&!Rh))U((Q&P)V((";
                for(int i=1; i<rNumber-1; i++){
                    SubFormula2+="!r"+i+"^";
                }
                SubFormula2+= "!r"+rNumber;
                SubFormula3 = ")^XRh))))";
                BaseFormula= SubFormula1+SubFormula2+SubFormula3;
            }
            
            else if(pat.equals("QPreceedesPE")){
                SubFormula1 = "(<>R)->((!((";
                for(int i =1; i< pNumber-1; i++){
                    SubFormula2+= "!p"+i+"^";
                }
                SubFormula2+= "!p"+pNumber;
                SubFormula3 = "^!Rh^X(Ph&!Rh)))U((Q&!Ph)V((";
                for(int i=1; i<rNumber-1; i++){
                    SubFormula4+= "!r"+1+"^";
                }
                SubFormula4+= "!r"+rNumber;
                SubFormula5 = ")^XRh)))";
                
                BaseFormula= SubFormula1+SubFormula2+SubFormula3+SubFormula4+SubFormula5;
            }
            
            else if(pat.equals("QStrictlyPrecedesPC")){
                SubFormula1="(<>R)->(((!(P&!Rh))U((Q&!P)V((";
                for(int i =0; i< rNumber-1; i++){
                    SubFormula2 += "!r"+i+"^";
                }
                SubFormula2+= "!r"+rNumber;
                SubFormula3= ")^XRh))))";
                BaseFormula=SubFormula1+SubFormula2+SubFormula3;
            }
            
            else if (pat.equals("QStrictlyPrecedesPE")){
                SubFormula1="(<>R)->((!((";
                for(int i=1;i<pNumber; i++){
                    SubFormula2 += "!p"+i+"^";
                }
                SubFormula2 += "!p"+pNumber;
                SubFormula3 = ")^!Rh^X(Ph&!Rh)))U((Q&!Ph)V((";
                for(int i =1; i<rNumber; i++){
                    SubFormula3 += "!r"+i+ "^";
                }
                SubFormula3 +="!r"+rNumber;
                SubFormula4= "^XRh)))";
                
                BaseFormula=SubFormula1+SubFormula2+ SubFormula3 + SubFormula4;
            }
            
            else if(pat.equals("QResponds")){
                SubFormula1 = "!((!((";
                for(int i=0; i<rNumber; i++){
                    SubFormula2 += "!r"+i+"^";
                }
                SubFormula2 += "!r"+rNumber;
                SubFormula3 = ")^X(Rh)))U((P&!Rh)&((!(Q&Rh))URh)))";
                BaseFormula=SubFormula1+SubFormula2+SubFormula3;
                
            }
        }
        
        
        
        
    }
    
    public char getLastLetter(Proposition P){
        Proposition prop = P;
        String propType = prop.getType();
        char lastLetter = prop.charAt(prop.length-1);
        
        return lastLetter;
    }
    
    
    
    
}
