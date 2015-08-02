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
    public static String getFormula(Pattern pattern, Proposition R){
        String formula = "";
        if(pattern instanceof Absence)
        {
            formula = getFormula((Absence)pattern, R);
        }
        else if(pattern instanceof Precedence)
        {
            formula = getFormula((Precedence)pattern, R);
        }
        else if(pattern instanceof Existence)
        {
            formula = getFormula((Existence)pattern, R);
        }
        else if (pattern instanceof StrictPrecedence){
            formula = getFormula((StrictPrecedence)pattern, R);
        }
        else if(pattern instanceof Response){
            formula = getFormula((Response)pattern, R);
        }
        return formula;
    }
    
    public static String getFormula(Precedence pattern, Proposition R){
        Precedence pat = pattern;
        Proposition propP = pat.getPropositionP();
        char PendLetter = getLastLetter(propP);
        //System.out.println(PendLetter);
        Proposition propR = R;
        char RendLetter = getLastLetter(propR);
        //System.out.println(RendLetter);
        String BaseFormula = "test";
        String SubFormula1="";
        String SubFormula2 ="";
        String SubFormula3 = "";
        String SubFormula4 ="";
        String SubFormula5="";
        int pNumber = propP.getNumber();
        int rNumber = propR.getNumber();
        
        if(RendLetter == 'C'|| RendLetter == 'c')
        {
            if(PendLetter == 'C' || PendLetter == 'c')
            {
                BaseFormula ="(<>R)->((!(P&!R))U((Q&!P)VR))";
                return BaseFormula;
            }
            else if (PendLetter == 'E' || PendLetter == 'e')
            {
                SubFormula1 = "((<>R->((!((";
                for(int i =1; i< pNumber-1; i++)
                {
                    SubFormula2+="!p"+i+"^";
                }
                SubFormula2+= "!p"+pNumber;
                SubFormula3 =")^!R^X(Ph&R)))U((Q&!(Ph))VR))";
                BaseFormula = SubFormula1+SubFormula2+SubFormula3;
                return BaseFormula;
            }
        }
        
        else if(RendLetter == 'E' || RendLetter == 'e')
        {
            if(PendLetter == 'C' || PendLetter == 'c')
            {
                SubFormula1 = "(<>R)->(((!(P&!Rh))U((Q&!P)V((";
                for(int i=1; i<rNumber-1; i++)
                {
                    SubFormula2+="!r"+i+"^";
                }
                SubFormula2+= "!r"+rNumber;
                SubFormula3 = ")^XRh))))";
                BaseFormula= SubFormula1+SubFormula2+SubFormula3;
                return BaseFormula;
            }
            else if (PendLetter =='E' || PendLetter == 'e')
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
                return BaseFormula;
            }
        }
        return BaseFormula;
    }
    
    public static String getFormula(Absence pattern, Proposition R){
        Absence pat = pattern;
        Proposition propP = pat.getPropositionP();
        char PendLetter = getLastLetter(propP);
        System.out.println(PendLetter);
        Proposition propR = R;
        char RendLetter = getLastLetter(propR);
        System.out.println(RendLetter);
        String BaseFormula = "test";
        String SubFormula1="";
        String SubFormula2 ="";
        String SubFormula3 = "";
        int rNumber = propR.getNumber();
        
        if(RendLetter == 'C' || RendLetter == 'c')
        {
            BaseFormula = "!((!R)U((P&!R)&<>R))";
            return BaseFormula;
        }
        else if(RendLetter == 'E'|| RendLetter == 'e')
        {
            SubFormula1 ="(<>R)->!((!((";
            for(int i =1; i<rNumber-1; i++)
            {
                SubFormula2+="!r"+i+"^";
            }
            SubFormula2+= "!r"+rNumber;
            SubFormula3 = ")^X(Rh)))U(P&!Rh))";
            BaseFormula = SubFormula1+SubFormula2+SubFormula3;
            return BaseFormula;
        }
        return BaseFormula;
    }
    
    public static String getFormula(Existence pattern, Proposition R){
        Existence pat = pattern;
        Proposition propP = pat.getPropositionP();
        char PendLetter = getLastLetter(propP);
        System.out.println(PendLetter);
        Proposition propR = R;
        char RendLetter = getLastLetter(propR);
        System.out.println(RendLetter);
        String BaseFormula = "test";
        String SubFormula1="";
        String SubFormula2 ="";
        String SubFormula3 = "";
        int rNumber = propR.getNumber();
        
        if(RendLetter == 'C'||RendLetter =='c')
        {
            BaseFormula = "!((!(P&!R))UR)";
            return BaseFormula;
        }
        
        else if (RendLetter == 'E'||RendLetter == 'e')
        {
            SubFormula1 = "(<>R)->((!((";
            for(int i =1; i<rNumber-1; i++)
            {
                SubFormula2+="!r"+i+"^";
            }
            SubFormula2+= "!r"+rNumber;
            SubFormula3 = ")^X(Rh)))U(P&!Rh))";
            BaseFormula =SubFormula1+SubFormula2+SubFormula3;
            return BaseFormula;
        }
        
        return BaseFormula;
    }
    
    
    public static String getFormula(StrictPrecedence pattern, Proposition R){
        StrictPrecedence pat = pattern;
        Proposition propP = pat.getPropositionP();
        char PendLetter = getLastLetter(propP);
        System.out.println(PendLetter);
        Proposition propR = R;
        char RendLetter = getLastLetter(propR);
        System.out.println(RendLetter);
        String BaseFormula = "test";
        String SubFormula1="";
        String SubFormula2 ="";
        String SubFormula3 = "";
        String SubFormula4 ="";
        int pNumber = propP.getNumber();
        int rNumber = propR.getNumber();
        
        if(RendLetter == 'C' || RendLetter == 'c'){
            if(PendLetter == 'C' || PendLetter == 'c')
            {
                BaseFormula = "(<>R)->((!(P&!R))U((Q&P)VR))";
                return BaseFormula;
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
                return BaseFormula;
            }
        }
        
        else if(RendLetter == 'E' ||RendLetter == 'e'){
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
                return BaseFormula;
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
                return BaseFormula;
            }
        }
        return BaseFormula;
    }
    
    public static String getFormula(Response pattern, Proposition R){
        Response pat = pattern;
        Proposition propP = pat.getPropositionP();
        char PendLetter = getLastLetter(propP);
        System.out.println(PendLetter);
        Proposition propR = R;
        char RendLetter = getLastLetter(propR);
        System.out.println(RendLetter);
        String BaseFormula = "test";
        String SubFormula1="";
        String SubFormula2 ="";
        String SubFormula3 = "";
        int rNumber = propR.getNumber();
        
        if (RendLetter == 'C'||RendLetter == 'c'){
            BaseFormula = "!((!R)U((P&!R)&((!(Q&!R))UR)))";
            return BaseFormula;
        }
        else if(RendLetter == 'E' || RendLetter == 'e'){
            SubFormula1 = "!((!((";
            for(int i=0; i<rNumber; i++)
            {
                SubFormula2 += "!r"+i+"^";
            }
            SubFormula2 += "!r"+rNumber;
            SubFormula3 = ")^X(Rh)))U((P&!Rh)&((!(Q&!Rh))URh)))";
            BaseFormula=SubFormula1+SubFormula2+SubFormula3;
            return BaseFormula;
        }
        return BaseFormula;
    }
    
    public static char getLastLetter(Proposition P){
        Proposition prop = P;
        String propType = prop.getType();
        char lastLetter = propType.charAt(propType.length()-1);
        return lastLetter;
    }
}
