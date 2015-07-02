/* Represents a composite proposition of type event, that holds if all the propositions
 * are false at some state, then all of the propositions hold in a specified order with 
 * one proposition holding in a distinct and possibly nonconsecutive state. State 's' is 
 * the state in which the last consecutive proposition holds.     
 */

public class EventualE extends Composite {
	
	/* EventualE(String name, int number) is a constructor method for a composite
	 * proposition of type EventualE. The name being the name of the proposition
	 * and the number is the number of propositions that make up this composite
	 * proposition.  
	 */
	public EventualE(String name, int number){
		super(name, number);
		typeOfProposition = "EventualE";
	}
}
