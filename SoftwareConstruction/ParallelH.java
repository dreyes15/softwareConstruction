/* Represents a composite proposition of type hold, that holds at a state 's' if all of
 * the propositions are true at some state 's'.   
 */

public class ParallelH extends Composite {
	
	/* ParallelH(String name, int number) is a constructor method for a composite
	 * proposition of type ParallelH. The name being the name of the proposition
	 * and the number is the number of propositions that make up this composite
	 * proposition.  
	 */
	public ParallelH(String name, int number){
		super(name, number);
		typeOfProposition = "ParallelH";
	}
	public static String ParallelHSubstitution(String name, int number) {

		String sub = " ";

		for (int i = 1; i <= number; i++) {
			while(i != number){
			sub += name + i + " ^ ";
			i++;
			}
			if(i == number){
				sub += name + i;
			}
		}
		return sub;
	}
 
}