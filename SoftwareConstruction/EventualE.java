/* Represents a composite proposition of type event, that holds if all the propositions
 * are false at some state, then all of the propositions hold in a specified order with
 * one proposition holding in a distinct and possibly nonconsecutive state. State 's' is
 * the state in which the last consecutive proposition holds.
 */

public class EventualE {
    
    /* EventualE(String name, int number) is a constructor method for a composite
     * proposition of type EventualE. The name being the name of the proposition
     * and the number is the number of propositions that make up this composite
     * proposition.
     */
    
    
    public static String EventualE(String property, int number){
        //baseProposition (pn-1 ^X(!pn U pn))
        String finalProposition = "";
        
        if(number == 1){
            return endPropostion(property,number);
        }
        
        int i= 1;
        while(i <= number){
            
            if(i == 1) {
                finalProposition = baseProposition(property,i);
            }
            
            else if (i< number){
                finalProposition = finalProposition.replace(".", midProposition(property, i));
            }
            else{
                finalProposition = finalProposition.replace(".", endPropostion(property, i));
            }
            i++;
        }
        return finalProposition;
    }
    
    //Creates the general (pn ^X(.)) where the . will be replaced
    private static String baseProposition(String property, int number){
        return "( " + property+number+ " ^X .)";
    }
    
    private static String midProposition(String property, int number){
        return "(!"+property+number+"U("+property+number+"^X.)";
    }
    
    private static String endPropostion(String property, int number){
        return "(!" +property+number+" U "+property+number+")";
    }
    
    
    public static void main(String [] args){
        
        System.out.println(EventualE("l",3));
        
    }
    
}