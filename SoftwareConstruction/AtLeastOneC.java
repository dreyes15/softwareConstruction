/* Represents a composite proposition of type condition, that holds at a state 's' if at least
 * one proposition is true at state 's'.
 * Given a composite proposition, it can generate itself as a AtLeastOneC formula with
 * the composite proposition variable names in the formula. AtLeastOneC is a subclass
 * of the Composite superclass. 
 */

public class AtLeastOneC {

	/* AtLeastOneC(String name) is a constructor method for a composite proposition
	 * of type AtLeastOneC. Since this class extends the Proposition class, the 
	 * name is sent to the super class to store the proposition variable name. 
	 */
	
	
	/* generateFormula() returns the generated formula for this composite proposition,
	 * The propositions that form this composite proposition are listed in the
	 * Composite superclass. This method returns a String. 
	 */
}