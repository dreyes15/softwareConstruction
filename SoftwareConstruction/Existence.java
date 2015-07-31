/* This class defines the pattern that there will be an occurrence of the primary proposition (P),
 * this class will do this by using the method Existence().
 */
public class Existence extends Pattern {
    
    /* Creates an object of type Existence to be further used by the LTL generator.
     */
	public Existence(Proposition propP) {
		this.propositionP = propP;
	}
}