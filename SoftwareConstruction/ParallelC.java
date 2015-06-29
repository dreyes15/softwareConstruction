/* Represents a composite proposition of type condition, that holds at a state 's' if all of
 * the propositions are true at some state 's'.   
 * 
 * Given a composite proposition, it can generate itself as a ParallelC formula with
 * the composite proposition variable names in the formula. ParallelC is a subclass
 * of the Composite superclass. 
 */

public class ParallelC {
	/* ParallelC(String name) is a constructor method for a composite proposition
	 * of type ParallelC. Since this class extends the Proposition class, the 
	 * name is sent to the super class to store the proposition variable name. 
	 */
	
	
	/* generateFormula() returns the generated formula for this composite proposition,
	 * The propositions that form this composite proposition are listed in the
	 * Composite superclass. This method returns a String. 
	 */
}
