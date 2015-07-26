/* This class defines an occurence the primary porpostion (p) must be followed by the secondary propositon (q)
 * this class will do this by using the method Responce().
 */
public class Response extends Pattern
{    
	Proposition propositionQ;
	
    /* Creates an object of type Response to be further used by the LTL generator.
     */
	public Response(Proposition propP, Proposition propQ) {
		this.propositionP = propP;
		this.propositionQ = propQ;
	}
	
	public Proposition getPropositionQ() {
		return this.propositionQ;
	}
}