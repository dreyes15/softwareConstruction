package ltlGenerator.formulaBuilder.propSubstitutor;
/* Course: Software Construction / CS5374
 * Instructor: Omar Ochoa
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Reyes
 * Project: LTL Generator
 * Due Date: July 3, 2015
 */

public class ParallelESub{
	
	/*This generateCP(String propName, int numberOfProps) does the substitution for ParallelE.
	 * This is accomplished with a for loop that iterates through the number of propositions 
	 * and three different while loops that will handle different parts of the ParallelE
	 * substitution. What is returned are the three parts concatinated together.
	 */
	
	public static String generateCP(String propName, int numberOfProps) {
				
		String propReplacement = "";
		String initialSubFormula = "";
		String middleSubFormula = "";
		String lastSubFormula = "";
		
		String name = propName;
		int number = numberOfProps;
		
		for (int i = 1; i <= number; i++) {
			initialSubFormula = "((!(" + name + i + ")";
			while (i != number) {
				i++;
				initialSubFormula += "^!(" + name + i + ")";
			}
			initialSubFormula += ")^";
			i = 1;

			middleSubFormula = "((!(" + name + i + ")";
			while (i != number) {
				i++;
				middleSubFormula += "^!(" + name + i + ")";
			}
			middleSubFormula += ")U(";
			i = 1;

			lastSubFormula = name + i;
			while (i != number) {
				i++;
				lastSubFormula += "^" + name + i;
			}
			lastSubFormula += ")))";

		}
		propReplacement = initialSubFormula+middleSubFormula+lastSubFormula;

		return (propReplacement);

	}
}