package ltlGenerator.propertyBuilder.scopes;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Reyes 
 * Project: LTL Generator
 * Due Date: August 3, 2015
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