/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: Global Table
 * Due Date: July 24, 2015
 * Purpose:
 * This class is the Abstract class for the following Scope Type of classes:
 * AfterLuntilL, BeforeR, BetweenLandR, Global, and AfterL.
 */

public abstract class Scope
{
	private String scopeType;
	protected Proposition propositionL;
	protected Proposition propositionR;
	
	public Scope()
	{
		setScopeTypeName();
	}
		
	private void setScopeTypeName()
	{
		String scopeTypeClassName = this.getClass().getSimpleName();
		scopeType = scopeTypeClassName;
	}
	
	public String getScopeType()
	{ 
		return scopeType;
	}
	
	public Proposition getPropositionL()
	{
		return propositionL; 
	}
	
	public Proposition getPropositionR()
	{
		return propositionR;
	}
}