/*This class is the Abstract class for AfterLuntilL, BeforeR, BetweenLandR,
 * Global, and AfterL.
 * 
 * This class will determine the extent of program execution depending 
 * on which property pattern is being used. 
 */
public abstract class Scope
{
	private String scopeType;
	
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
}