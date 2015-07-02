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
}
