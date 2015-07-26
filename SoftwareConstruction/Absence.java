/* This class defines an occurrence the primary proposition (p) does not occur
 * this class will do this by using the method Absence().
 */
public class Absence extends Pattern {
    
    /* Creates an object of type Absence to be further used by the LTL generator.
     */
	public Absence(Proposition propP) {
		this.propositionP = propP;
	}
}