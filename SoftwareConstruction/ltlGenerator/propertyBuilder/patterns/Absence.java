package ltlGenerator.propertyBuilder.patterns;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Reyes
 * Project: LTL Generator
 * Sprint: Global Table
 * Due Date: July 24, 2015
 * Purpose:
 * This class defines the "Absence" pattern which is the occurrence
 * where the primary proposition (p) should not occur.
 */

import ltlGenerator.propertyBuilder.proposition.Proposition;

public class Absence extends Pattern
{    
	public Absence(Proposition propP, Proposition propQ)
	{
		this.propositionP = propP;
	}
}