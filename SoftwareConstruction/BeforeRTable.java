/*Contains string substitution data for each possible pattern given the
 * Before R scope.It will return the formula template with the
 * special & operators.
 *
 */
public class BeforeRTable {
    
    /* Method BeforeRSubstitution() receives appropriate properties such as the string array containing a Scope,
     * a Pattern, and all necessary Proposition types and will do the string substituion given the before R
     * scope and will return the template to the formula creator.
     */
    
    //initializing variable R of type Proposition;
    public String getFormula(Precedence pattern, Proposition R)
    {
        Precedence pat = pattern;
        Proposition propP = pat.getPropositionP();
        char PendLetter = getLastLetter(propP);
        Proposition propR = R;
        char RendLetter = getLastLetter(propR);
        String BaseFormula = "";
        String SubFormula1="";
        String SubFormula2 ="";
        String SubFormula3 = "";
        String SubFormula4 ="";
        String SubFormula5="";
        int pNumber = propP.getNumber();
        int rNumber = propR.getNumber();
        
        if(RendLetter == 'C' || RendLetter == 'c')
        {
            if(propR.getType() == "Absence")
            {
                BaseFormula = "!((!R)U((P&!R)&<>R))";
            }
            
            else if (propR.getType() == "Existence")
            {
                BaseFormula = "!((!(P&!R))UR)";
            }
            else if(propR.getType() == "QPrecedes")
            {
                if(PendLetter == 'C' || PendLetter == 'c')
                {
                    BaseFormula ="(<>R)->((!(P&!R))U((Q&!P)VR))";
                }
                else
                {
                    SubFormula1 = "((<>R->((!((";
                    for(int i =1; i< pNumber-1; i++)
                    {
                        SubFormula2+="!p"+i+"^";
                    }
                    SubFormula2+= "!p"+pNumber;
                    SubFormula3 =")^!R^X(Ph&R)))U((Q&!(Ph))VR))";
                    BaseFormula = SubFormula1+SubFormula2+SubFormula3;
                }
            }
            else if(propR.getType() == "QStricltyPrecedes")
            {
                if(PendLetter == 'C' || PendLetter == 'c')
                {
                    BaseFormula = "(<>R)->((!(P&!R))U((Q&P)VR))";
                }
                else
                {
                    SubFormula1= "(<>R)->((!((";
                    for(int i =1; i<pNumber-1; i++)
                    {
                        SubFormula2+="!p"+i+"^";
                    }
                    SubFormula2+= "!p"+pNumber;
                    SubFormula3= ")^!R^X(Ph&!R)))U((Q&!(Ph))VR))";
                    BaseFormula=SubFormula1+SubFormula2+SubFormula3 ;
                }
            }
            else if (propR.getType() =="QResponds")
            {
                BaseFormula = "!((!R)U((P&!R)&((!(Q&!R))UR)))";
            }
        }
        else if(RendLetter == 'E' || RendLetter == 'e')
        {
            if(propR.getType() == "Absence")
            {
                SubFormula1 ="(<>R)->!((!((";
                for(int i =1; i<rNumber-1; i++)
                {
                    SubFormula2+="!r"+i+"^";
                }
                SubFormula2+= "!r"+rNumber;
                SubFormula3 = ")^X(Rh)))U(P&!Rh))";
                BaseFormula = SubFormula1+SubFormula2+SubFormula3;
            }
            else if(propR.getType() == "Existence")
            {
                SubFormula1 = "(<>R)->((!((";
                for(int i =1; i<rNumber-1; i++)
                {
                    SubFormula2+="!r"+i+"^";
                }
                SubFormula2+= "!r"+rNumber;
                SubFormula3 = ")^X(Rh)))U(P&!Rh))";
                BaseFormula =SubFormula1+SubFormula2+SubFormula3;
            }
            else if(propR.getType() == "QPrecedes"){
                if(PendLetter == 'C' || PendLetter == 'c'){
                    SubFormula1 = "(<>R)->(((!(P&!Rh))U((Q&!P)V((";
                    for(int i=1; i<rNumber-1; i++)
                    {
                        SubFormula2+="!r"+i+"^";
                    }
                    SubFormula2+= "!r"+rNumber;
                    SubFormula3 = ")^XRh))))";
                    BaseFormula= SubFormula1+SubFormula2+SubFormula3;
                }
                else if(PendLetter =='E'|| PendLetter =='e')
                {
                    SubFormula1 = "(<>R)->((!((";
                    for(int i =1; i< pNumber-1; i++)
                    {
                        SubFormula2+= "!p"+i+"^";
                    }
                    SubFormula2+= "!p"+pNumber;
                    SubFormula3 = "^!Rh^X(Ph&!Rh)))U((Q&!Ph)V((";
                    for(int i=1; i<rNumber-1; i++)
                    {
                        SubFormula4+= "!r"+1+"^";
                    }
                    SubFormula4+= "!r"+rNumber;
                    SubFormula5 = ")^XRh)))";
                    BaseFormula= SubFormula1+SubFormula2+SubFormula3+SubFormula4+SubFormula5;
                }
            }
            else if(propR.getType() =="QStrictlyPrecedes")
            {
                if(PendLetter == 'C' || PendLetter =='c')
                {
                    SubFormula1="(<>R)->(((!(P&!Rh))U((Q&!P)V((";
                    for(int i =0; i< rNumber-1; i++)
                    {
                        SubFormula2 += "!r"+i+"^";
                    }
                    SubFormula2+= "!r"+rNumber;
                    SubFormula3= ")^XRh))))";
                    BaseFormula=SubFormula1+SubFormula2+SubFormula3;
                }
                else if(PendLetter == 'E' || PendLetter == 'e')
                {
                    SubFormula1="(<>R)->((!((";
                    for(int i=1;i<pNumber; i++)
                    {
                        SubFormula2 += "!p"+i+"^";
                    }
                    SubFormula2 += "!p"+pNumber;
                    SubFormula3 = ")^!Rh^X(Ph&!Rh)))U((Q&!Ph)V((";
                    for(int i =1; i<rNumber; i++)
                    {
                        SubFormula3 += "!r"+i+ "^";
                    }
                    SubFormula3 +="!r"+rNumber;
                    SubFormula4= "^XRh)))";
                    BaseFormula=SubFormula1+SubFormula2+ SubFormula3 + SubFormula4;
                }
                else if(propR.getType() == "Responds")
                {
                    SubFormula1 = "!((!((";
                    for(int i=0; i<rNumber; i++)
                    {
                        SubFormula2 += "!r"+i+"^";
                    }
                    SubFormula2 += "!r"+rNumber;
                    SubFormula3 = ")^X(Rh)))U((P&!Rh)&((!(Q&!Rh))URh)))";
                    BaseFormula=SubFormula1+SubFormula2+SubFormula3;
                }
            }
        }
    }
    
    public char getLastLetter(Proposition P){
        Proposition prop = P;
        String propType = prop.getType();
        char lastLetter = propType.charAt(propType.length()-1);
        return lastLetter;
    }
    
}
