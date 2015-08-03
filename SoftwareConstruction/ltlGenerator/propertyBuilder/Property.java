package ltlGenerator.propertyBuilder;
/* Course: Software Construction / CS5374 Test
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Reyes 
 * Project: LTL Generator
 * Due Date: August 3, 2015
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