/* Represents a composite proposition of type event, that holds if all the propositions
 * are false at some state. Then, all of the propositions become true at some future 
 * state. Such that, each proposition holds in a specified order with one proposition 
 * holding per state, at a successive rate. State 's' is the state in which the last 
 * consecutive proposition holds.    
 * 
 * Given a composite proposition, it can generate itself as a ConsecutiveE formula with
 * the composite proposition variable names in the formula. ConsecutiveE is a subclass
 * of the Composite superclass. 
 */

public class ConsecutiveE {
	/* ConsecutiveE(String name) is a constructor method for a composite proposition
	 * of type ConsecutiveE. Since this class extends the Proposition class, the 
	 * name is sent to the super class to store the proposition variable name. 
	 */
	
	
	/* generateFormula() returns the generated formula for this composite proposition,
	 * The propositions that form this composite proposition are listed in the
	 * Composite superclass. This method returns a String. 
	 */
}
