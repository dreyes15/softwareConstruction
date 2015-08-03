package ltlGenerator.formulaBuilder.propSubstitutor;
/* Course: Software Construction / CS5374
 * Instructor: Omar Ochoa
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Reyes 
 * Project: LTL Generator
 * Due Date: August 3, 2015
 */

public class ParallelHSub{
	
	/*This generateCP(String propName, int numberOfProps) method does the substitution for ParallelH.
	 * This is accomplished by using a for loop that iterates through the length of the number of the
	 * propositions, then there is a while loop that iterates until i does not equal the number of 
	 * propositions (ie. while not the last element) the string will return the name of the 
	 * proposition the number of that proposition and a "^". Then there is an if statement that checks
	 * when i equals the last element the string will be the name of the proposition and the number of
	 * that proposition. The method will therefore return the ParallelH substitution.
	 */
	
	public static String generateCP(String propName, int numberOfProps) {

		String propReplacement = "(";
		
		String name = propName;
		int number = numberOfProps;

		for (int i = 1; i <= number; i++) {
			while(i != number){
			propReplacement += name + i + "^";
			i++;
			}
			if(i == number){
				propReplacement += name + i;
			}
		}
		propReplacement = propReplacement + ")";
		return propReplacement;
	}
	
}
