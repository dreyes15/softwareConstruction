package ltlGenerator.formulaBuilder.propertyBuilder;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: Global Table
 * Due Date: July 24, 2015
 * Purpose:
 * This class is the main driver of the Input Definition subsystem.  It receives
 * a string array containing a Scope, a Pattern, and all necessary Proposition types
 * (including the number of each proposition for composite types), and it returns a
 * Property object that contains this information.  This class has a Constructor, and
 * two methods: SetScope() and SetPattern().
 */

import ltlGenerator.propertyBuilder.patterns.Pattern;
import ltlGenerator.propertyBuilder.scopes.Scope;

public class Property
{
	Scope scope;
	Pattern pattern;

	public Property(Scope inScope, Pattern inPattern)
	{
		this.scope = inScope;
		this.pattern = inPattern;
	}
	
	public Pattern getPattern()
	{
		return this.pattern;
	}
	
	public Scope getScope()
	{
		return this.scope;
	}
}