/* Represents a composite proposition of type event, that holds if all the propositions
 * are false at some state. Then, at least one of these propositions becomes true at
 * some future state. 
 */
import java.util.*;
public class AtLeastOneE extends Composite {

	/* AtLeastOneE(String name, int number) is a constructor method for a composite
	 * proposition of type AtLeastOneE. The name being the name of the proposition
	 * and the number is the number of propositions that make up this composite
	 * proposition.  
	 */
	public AtLeastOneE(String name, int number){
		super(name, number);
		typeOfProposition = "AtLeastOneE";
	}
}
