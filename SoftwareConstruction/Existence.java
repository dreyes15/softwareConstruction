/* This class defines the pattern that there will be an orrucance of the primary proposition (P),
 * this class will do this by using the method Existance().
 */
public class Existence extends Pattern {
    
    /* Creates an object of type Existance to be futher used by the LTL generator.
     */
	public Existence(Proposition propP) {
		this.propositionP = propP;
	}
}