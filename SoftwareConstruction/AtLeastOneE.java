/* Represents a composite proposition of type event, that holds if all the propositions
 * are false at some state. Then, at least one of these propositions becomes true at
 * some future state. 
 * 
 * Given a composite proposition, it can generate itself as a AtLeastOneE formula with
 * the composite proposition variable names in the formula. AtLeastOneE is a subclass
 * of Composite superclass. 
 */

public class AtLeastOneE {
	/* AtLeastOneE(String name) is a constructor method for a composite proposition
	 * of type AtLeastOneE. Since this class extends the Proposition class, the 
	 * name is sent to the super class to store the proposition variable name. 
	 */
	
	
	/* generateFormula() returns the generated formula for this composite proposition,
	 * The propositions that form this composite proposition are listed in the
	 * Composite superclass. This method returns a String. 
	 */
}
