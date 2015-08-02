package ltlGenerator.propertyBuilder.proposition;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 * Purpose: Represents a composite proposition of type condition, that holds at a state
 * 's' if all ofthe propositions are true at some state 's'.   
 */

public class ParallelC extends Composite {

	/*
	 * ParallelC(String name, int number) is a constructor method for a
	 * composite proposition of type ParallelC. The name being the name of the
	 * proposition and the number is the number of propositions that make up
	 * this composite proposition.
	 */
	public ParallelC(String name, int number){
		super(name, number);
		typeOfProposition = "ParallelC";
		
	}
}