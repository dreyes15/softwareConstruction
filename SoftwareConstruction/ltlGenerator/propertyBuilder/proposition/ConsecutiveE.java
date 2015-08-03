package ltlGenerator.propertyBuilder.proposition;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Reyes 
 * Project: LTL Generator
 * Due Date: August 3, 2015
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
