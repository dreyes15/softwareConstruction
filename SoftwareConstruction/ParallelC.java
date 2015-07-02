/* Represents a composite proposition of type condition, that holds at a state 's' if all of
 * the propositions are true at some state 's'.   
 */

public class ParallelC extends Composite {
	
	/* ParallelC(String name, int number) is a constructor method for a composite
	 * proposition of type ParallelC. The name being the name of the proposition
	 * and the number is the number of propositions that make up this composite
	 * proposition.  
	 */
	public ParallelC(String name, int number){
		super(name, number);
		typeOfProposition = "ParallelC";
	}
}