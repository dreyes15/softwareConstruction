package ltlGenerator;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity,
 * 		 Lucia Rodriguez, and David Reyes
 * Project: LTL Generator
 * Sprint: LTL Generator
 * Due Date: July 3, 2015
 * Purpouse: Main Method
 */

public class Main {

	public static void main(String[] args) {
		LTLGenerator ltlGen = new LTLGenerator();
		String finalFormula = ltlGen.getFinalFormula();
		System.out.println(finalFormula);
	}
}
