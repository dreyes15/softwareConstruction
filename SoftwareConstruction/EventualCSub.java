/* Course: Software Construction / CS5374
 * Instructor: Omar Ochoa
<<<<<<< HEAD
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
=======
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, Lucia Melgoza,
 * 		 and David Reyes 
>>>>>>> branch 'master' of https://github.com/dreyes15/softwareConstruction.git
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 */

public class EventualCSub{

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
    private static String baseProposition(String name, int number){
        return "( " + property+number+ " ^X .)";
    }

    private static String midProposition(String name, int number){
        return "(!"+property+number+"U("+property+number+"^X.)";
    }

    private static String endPropostion(String name, int number){
        return "(!" +property+number+" U "+property+number+")";
    }
}