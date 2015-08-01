/* This class defines the everytime a property (p) holds, another property (q) must hold in a previous state.
 * this class will do this by using the method StrictPrecendence().
 */
public class StrictPrecedence extends Pattern
{
	public StrictPrecedence(Proposition propP, Proposition propQ)
	{
		this.propositionQ = propQ;
	}
}