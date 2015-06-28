/* Represents a composite proposition of type event, that holds if all the
 * propositions are false at some state and then all of the propositions become true
 * at some future state. 
 * 
 * Given a composite proposition, it can generate itself as a ParallelE formula with
 * the composite proposition variable names in the formula. ParallelE is a subclass
 * of the Composite superclass. 
 */

public class ParallelE {

	/* ParallelE(String name) is a constructor method for a composite proposition
	 * of type ParallelE. Since this class extends the Proposition class, the 
	 * name is sent to the super class to store the proposition variable name. 
	 */
	
	
	/* generateFormula() returns the generated formula for this composite proposition,
	 * The propositions that form this composite proposition are listed in the
	 * Composite superclass. This method returns a String. 
	 */
}
