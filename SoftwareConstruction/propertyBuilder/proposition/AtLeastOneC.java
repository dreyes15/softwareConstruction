package propertyBuilder.proposition;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 *Purpose: Represents a composite proposition of type condition, that holds at a state
 *'s' if at least one proposition is true at state 's'.
 * AtLeastOneC is a subclass of the Composite superclass. 
 */


public class AtLeastOneC extends Composite {

	/* AtLeastOneC(String name, int number) is a constructor method for a composite
	 * proposition of type AtLeastOneC. The name being the name of the proposition
	 * and the number is the number of propositions that make up this composite
	 * proposition.  
	 */
	public  AtLeastOneC(String name, int number){
		super(name, number);
		typeOfProposition = "AtLeastOneC";
	}
}