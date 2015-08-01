/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: Global Table
 * Due Date: July 24, 2015
 * Purpose:
 * This Pattern class is the superclass for the following classes: Existence, Absence, Precedence, 
 * Strict Precedence, and Response.
 */

public abstract class Pattern
{    
	private String patternType;
	protected Proposition propositionP;
	protected Proposition propositionQ;

	public Pattern()
	{
		setPatternTypeName();
	}
	
	private void setPatternTypeName()
	{
		String patternTypeClassName = this.getClass().getSimpleName();
		patternType = patternTypeClassName;
	}

	public String getPatternType()
	{
		return patternType;
	}
	
	public Proposition getPropositionP()
	{
		return this.propositionP;
	}
	
	public Proposition getPropositionQ()
	{
		return this.propositionQ;
	}
}