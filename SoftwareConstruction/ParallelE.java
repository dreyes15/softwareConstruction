/* Represents a composite proposition of type event, that holds if all the
 * propositions are false at some state and then all of the propositions become true
 * at some future state. 
 */

public class ParallelE extends Composite {

	/* ParallelE(String name, int number) is a constructor method for a composite
	 * proposition of type ParallelE. The name being the name of the proposition
	 * and the number is the number of propositions that make up this composite
	 * proposition.  
	 */
	public ParallelE(String name, int number){
		super(name, number);
		typeOfProposition = "ParallelE";
	}
	
	public static String ParallelESub(String name, int number) {
		String part1 = name;
		String part2 = null;
		String part3 = null;
		for (int i = 1; i <= number; i++) {
			part1 = "( ¬ " + name + i;
			while (i != number) {
				i++;
				part1 += " ^ ¬ " + name + i;
			}
			part1 += ") ^ ";
			i = 1;

			part2 = "(( ¬ " + name + i;
			while (i != number) {
				i++;
				part2 += " ^ ¬ " + name + i;
			}
			part2 += ") U ";
			i = 1;

			part3 = "(" + name + i;
			while (i != number) {
				i++;
				part3 += " ^ " + name + i;
			}
			part3 += "))";

		}

		return (part1 + part2 + part3);

	}


}
