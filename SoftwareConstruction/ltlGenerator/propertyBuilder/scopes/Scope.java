package ltlGenerator.propertyBuilder.scopes;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Reyes 
 * Project: LTL Generator
 * Sprint: Global Table
 * Due Date: July 24, 2015
 * Purpose:
 * This class is the Abstract class for the following Scope Type of classes:
 * AfterLuntilL, BeforeR, BetweenLandR, Global, and AfterL.
 */

import ltlGenerator.propertyBuilder.proposition.Proposition;

public abstract class Scope
{
	private String scopeType = "";
	protected Proposition propositionL = null;
	protected Proposition propositionR = null;
	
	public Scope()
	{
		setScopeTypeName();
	}
		
	private void setScopeTypeName()
	{
		String scopeTypeClassName = this.getClass().getSimpleName();
		this.scopeType = scopeTypeClassName;
	}
	
	public String getScopeType()
	{ 
		return this.scopeType;
	}
	
	public Proposition getPropositionL()
	{
		return this.propositionL; 
	}
	
	public Proposition getPropositionR()
	{
		return this.propositionR;
	}
}