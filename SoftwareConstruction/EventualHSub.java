/* Course: Software Construction / CS5374
 * Instructor: Omar Ochoa
<<<<<<< HEAD
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Reyes 
=======
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, Lucia Melgoza,
 * 		 and David Reyes 
>>>>>>> branch 'master' of https://github.com/dreyes15/softwareConstruction.git
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 */

public class EventualHSub {

	/* EventualHSub */
	public static String generateCP(String propName, int numberOfProps) {
		
		String propReplacement = "";
		
		String name = propName;
		int number = numberOfProps;
		
		if (number < 1){
			return "";
		}

		else if (number == 1){
           return "(!"+name+number+"U"+name+number+")";
        }

		//String p = proposition;
		int endParenthesisCount = 0;				//End Parenthesis. Counts only middle parenthesis.

		String str2toN = genAndNot(name, 2, number);	//Generates 2-N (^!p2^...^pn)
		String str1 = name + "1^" + str2toN + "^";		//Part1 (p1^!p2^...^!pn ^
		String str2 ="(("+ str2toN +")U(";		//Part2 ((!p2^...^!pn)U(p2...

		/* Generate the middle section in such a way that:
		 * n: (p2 ^ !p3 ^...^!pn^(...^(pn-1 ^ !pn^(!pn U pn)
		 * (eg)
		 * 2: (p2 ^(!p2 U p2)
		 * 3: (p2^!p3 ^(!p3 U p3)
		 * 4: (p2^!p3^!p4 ^(p3 ^ !p4 ^(!pn U pn)
		 */
		String str3  = "";
		for(int i=2; i<number; i++) { 
			String firstTrue = name + i + "^";
			String nextAllFalse = firstTrue + genAndNot(name, i+1, number);
			str3 = str3 + nextAllFalse + "^(";
			endParenthesisCount++;
		}

		String beginningSubFormula = str1 + str2 + str3;
		String endingSubFormula = "(!" + name + number + "U" + name + number + ")))))";
		String endParenthesis = genEndParenthesis(endParenthesisCount);

		propReplacement = "(" + beginningSubFormula + endingSubFormula + endParenthesis;
		return propReplacement;
	}

	/* Generates a string that have the multiple propositions with 
	 * "not" and an "and" in between.
	 */
	private static String genAndNot(String name, int start, int end) {
		String formula = "";
		for(int i=start; i<= end; i++) {
			if(i == start ) {
				formula = "!" + name + i;
			} else {
				formula = formula + "^!" + name + i; 
			}
		}
		return formula;
	}

	/* Generates the closing parenthesis at the end of the formula
	 * with the given number. Returns a string of closing parenthesis.
	 */
	private static String genEndParenthesis(int number) {
		String pStr = "";
		for(int i=0; i<number; i++) {
			pStr = pStr + ")";
		}
		return pStr;
	}
}
