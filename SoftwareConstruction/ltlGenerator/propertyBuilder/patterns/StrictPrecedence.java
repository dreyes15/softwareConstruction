package ltlGenerator.propertyBuilder.patterns;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Reyes 
 * Project: LTL Generator
 * Sprint: Global Table
 * Due Date: July 24, 2015
 * Purpose:
 * This class defines the every time a property (p) holds, another property (q) must hold in a previous state.
 * this class will do this by using the method StrictPrecendence().
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