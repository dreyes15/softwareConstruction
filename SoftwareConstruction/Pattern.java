/**This class is the Abstract class for Existance, Absence, Precedence, Strict Precedence, and Responce.
 * This class only contains methods that are common properties of these classes, this class reveices
 * the Pattern input from the Property class, which will then delegate the pattern to it's repsected
 * class.
 **/
public abstract class Pattern
{    
	private String patternType;
	protected Proposition propositionP;

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
}