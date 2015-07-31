/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: Global Table
 * Due Date: July 24, 2015
 * Purpose:
 * This class defines the pattern that, if in the portion of the system, an occurrence of the secondary
 * proposition (q) is a necessary pre-condition of an occurrence of p.this class will do this by using the method
 * Precendence().
 */

public class Precedence extends Pattern
{  
	public Precedence(Proposition propP, Proposition propQ)
	{
		this.propositionP = propP;
		this.propositionQ = propQ;
	}
}