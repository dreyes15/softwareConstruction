package ltlGenerator.propertyBuilder.proposition;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Reyes 
 * Project: LTL Generator
 * Due Date: August 3, 2015
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