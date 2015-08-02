package ltlGenerator.formulaBuilder.propSubstitutor;
/* Course: Software Construction / CS5374
 * Instructor: Omar Ochoa
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, Lucia Melgoza,
 * 		 and David Reyes 
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 */
public class EventualCSub{
    /*
    * Generates the Composite Proposition for EventualC Loops through replacing "." with the
    * appropriate part needed to generatethe formula.
    */
    public static String generateCP(String propName, int numberOfProps){
        
    	String propReplacement = "";
    	
    	String name = propName;
    	int number = numberOfProps;

        if(number == 1){
            propReplacement = endPropostion(name,number);
            return propReplacement;
        }
        int i= 1;
        
        while(i <= number){
            if(i == 1) {
                propReplacement = baseProposition(name,i);
            }

            else if (i< number){
                propReplacement = propReplacement.replace(".", midProposition(name, i));
            }
            else{
                propReplacement = propReplacement.replace(".", endPropostion(name, i));
            }
            i++;
        }
        return propReplacement;
    }
    // returns the base propostion of (pn-1^X.) where "." will be replaced by appriate section of proposition
    private static String baseProposition(String name, int number){
        return "(" + name+number+ "^X.)";
    }
    // returns the mid propostion of (!pn U pn^X".") where again "." will be replaced by appropriate propotion number
    private static String midProposition(String name, int number){
        return "(!("+name+number+")U("+name+number+"^X.))";
    }
    //returns the innermost terminant of the propositon (!pn U pn)
    private static String endPropostion(String name, int number){
        return "(!(" +name+number+")U("+name+number+"))";
    }
}
