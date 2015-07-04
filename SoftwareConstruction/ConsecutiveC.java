/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 * Purpose: Represents a composite proposition of type condition, that holds at a 
 * state 's', if each proposition holds in a specified order with one proposition 
 * holding per state, at a successive rate. State 's' is the state in which the last 
 * consecutive proposition holds.
 */

public class ConsecutiveC extends Composite {
	
	/* ConsecutiveC(String name, int number) is a constructor method for a composite
	 * proposition of type ConsecutiveC. The name being the name of the proposition
	 * and the number is the number of propositions that make up this composite
	 * proposition.  
	 */
	public ConsecutiveC(String name, int number){
		super(name, number);
		typeOfProposition = "ConsecutiveC";
	}
}
