package ltlGenerator.propertyBuilder.proposition;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Reyes 
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 * Purpose: Represents a composite proposition of type event, that holds if all the 
 * propositions are false at some state. Then, all of the propositions become true at 
 * some future state. Such that, each proposition holds in a specified order with one 
 * proposition holding per state, at a successive rate. State 's' is the state in which 
 * the last consecutive proposition holds.    
 */

public class ConsecutiveE extends Composite {
	
	/* ConsecutiveE(String name, int number) is a constructor method for a composite
	 * proposition of type ConsecutiveE. The name being the name of the proposition
	 * and the number is the number of propositions that make up this composite
	 * proposition.  
	 */
	public ConsecutiveE(String name, int number){
		super(name, number);
		typeOfProposition = "ConsecutiveE";
	}
}
