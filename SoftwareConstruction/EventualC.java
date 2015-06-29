/* Represents a composite proposition of type condition, that holds at a state 's',
 * if each proposition holds in a specified order with one proposition holding in a 
 * distinct and possibly nonconsecutive state. State 's' is the state in which the 
 * last consecutive proposition holds.    
 * 
 * Given a composite proposition, it can generate itself as a EventualC formula with
 * the composite proposition variable names in the formula. EventualC is a subclass
 * of the Composite superclass. 
 */

public class EventualC {
	/* EventualC(String name) is a constructor method for a composite proposition
	 * of type EventualC. Since this class extends the Proposition class, the 
	 * name is sent to the super class to store the proposition variable name. 
	 */
	
	
	/* generateFormula() returns the generated formula for this composite proposition,
	 * The propositions that form this composite proposition are listed in the
	 * Composite superclass. This method returns a String. 
	 */
}
