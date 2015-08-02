package propertyBuilder.patterns;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: Global Table
 * Due Date: July 24, 2015
 * Purpose:
 * This class defines an occurrence the primary proposition (p) must be followed by the secondary proposition (q)
 * this class will do this by using the method Response().
 */

import propertyBuilder.proposition.Proposition;

public class Response extends Pattern
{    
	public Response(Proposition propP, Proposition propQ)
	{
		this.propositionP = propP;
		this.propositionQ = propQ;
	}
}