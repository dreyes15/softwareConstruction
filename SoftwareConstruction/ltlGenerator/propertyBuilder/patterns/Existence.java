package ltlGenerator.propertyBuilder.patterns;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: Global Table
 * Due Date: July 24, 2015
 * Purpose:
 * This class defines the "Existence" pattern where the Proposition p must "exist" 
 * at least once. 
 */

import ltlGenerator.propertyBuilder.proposition.Proposition;

public class Existence extends Pattern
{
	public Existence(Proposition propP, Proposition propQ)
	{
		this.propositionP = propP;
	}
}