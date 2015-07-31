/*This class is the main driver of the Input Definition subsystem.  It receives
 * a string array containing a Scope, a Pattern, and all necessary Proposition types
 * (including the number of each proposition for composite types), and it returns a
 * Property object that contains this information.  This class has a Constructor, and
 * two methods: SetScope() and SetPattern().
 */

public class Property {
	Scope scope;
	Pattern pattern;
	
	/*The Property() constructor builds a new Property object using the Scope and Pattern
	 * objects that are passed to it.
	 */
	public Property(Scope inScope, Pattern inPattern) {
		this.scope = inScope;
		this.pattern = inPattern;
	}
	
	public Pattern getPattern() {
		return this.pattern;
	}
	
	public Scope getScope() {
		return this.scope;
	}
}