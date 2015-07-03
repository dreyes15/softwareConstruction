/* Represents a composite proposition of type condition, that holds at a state 's',
 * if each proposition holds in a specified order with one proposition holding in a 
 * distinct and possibly nonconsecutive state. State 's' is the state in which the 
 * last consecutive proposition holds.    
 */

public class EventualC extends Composite {
	
	/* EventualC(String name, int number) is a constructor method for a composite
	 * proposition of type EventualC. The name being the name of the proposition
	 * and the number is the number of propositions that make up this composite
	 * proposition.  
	 */
	public EventualC(String name, int number){
		super(name, number);
		typeOfProposition = "EventualC";
	}
    
    public static String EventualE(String property, int number){
        //baseProposition (pn-1 ^X(!pn U pn))
        String finalProposition = "";
        
        if(number == 1){
            finalProposition = endPropostion(property,number);
            return finalProposition;
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
    
}
