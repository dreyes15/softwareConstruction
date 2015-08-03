package ltlGenerator.propertyBuilder.proposition;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 * Purpose: Represents an atomic type of proposition, which is a proposition made up 
 * of a single proposition. An atomic proposition instance will have a proposition name,
 * and the only proposition it will contain is itself. Atomic is a subclass of
 * Proposition. 
 */

public class Atomic extends Proposition {
	
	/* Atomic(String name) is a constructor method for a proposition of type atomic.
	 * Since this class extends the Proposition class, the name is sent to the 
	 * super class to store the proposition variable name. 
	 */
	public Atomic(String name){
		super(name);
		typeOfProposition = "Atomic";
	}
}