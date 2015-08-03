package ltlGenerator.propertyBuilder.patterns;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Reyes
 * Project: LTL Generator
 * Sprint: Global Table
 * Due Date: July 24, 2015
 * Purpose:
 * This Pattern class is the superclass for the following classes: Existence, Absence, Precedence, 
 * Strict Precedence, and Response.
 */

import ltlGenerator.propertyBuilder.proposition.Proposition;

public abstract class Pattern
{    
	private String patternType = "";
	protected Proposition propositionP = null;
	protected Proposition propositionQ = null;

	public Pattern()
	{
		setPatternTypeName();
	}
	
	private void setPatternTypeName()
	{
		String patternTypeClassName = this.getClass().getSimpleName();
		this.patternType = patternTypeClassName;
	}

	public String getPatternType()
	{
		return this.patternType;
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