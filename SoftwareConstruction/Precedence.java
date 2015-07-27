/* This class defines the pattern that, if in the portion of the system, an occurence of the secondary
 * propsiton (q) is a necessary pre-condition of an ocurence of p.this class will do this by using the method
 * Precendence().
 */
public class Precedence extends Pattern
{    
	Proposition propositionP;
	Proposition propositionQ;
	
    /* Creates an object of type Precedence to be futher used by the LTL generator.
     */
	public Precedence(Proposition propP, Proposition propQ)
	{
		this.propositionP = propP;
		this.propositionQ = propQ;
	}
	
	public Proposition getPropositionQ()
	{
		return this.propositionQ;
	}
}