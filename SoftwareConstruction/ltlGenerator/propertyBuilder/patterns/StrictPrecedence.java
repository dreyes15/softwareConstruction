package ltlGenerator.propertyBuilder.patterns;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Reyes 
 * Project: LTL Generator
 * Due Date: August 3, 2015
 */

import ltlGenerator.propertyBuilder.proposition.Proposition;

public class StrictPrecedence extends Pattern
{
	public StrictPrecedence(Proposition propP, Proposition propQ)
	{
		this.propositionP = propP;
		this.propositionQ = propQ;
	}
}