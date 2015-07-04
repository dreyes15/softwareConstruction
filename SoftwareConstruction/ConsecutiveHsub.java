/* Course: Software Construction / CS5374
 * Instructor: Omar Ochoa
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 */

public class ConsecutiveHSub {

	//(p1∧¬p2∧···∧¬pn∧X(p2∧¬p3 ∧···∧¬pn ∧ X(··· ∧ X(pn−1 ∧ ¬pn ∧ Xpn))···))

	public String generateCP (String propName, int numberOfProps){
		
		String propReplacement = "(";
		int closingcount =0; //tracks the number of closing parenthesis

		String name = propName;
		int number = numberOfProps;
		
		for ( int i =1; i <=number; i++){
			if(i!= number){
				propReplacement = propReplacement + firstTrueAndNotOperators( name, i, number);
				propReplacement = propReplacement +"^X(";
			}
			else {
				propReplacement = propReplacement + firstTrueAndNotOperators( name, number, number);
				for(int j=1; j<= number ; j++){
					propReplacement = propReplacement + ")";
				}
			}
		}

		return propReplacement;
	}

	private String firstTrueAndNotOperators(String name, int count, int number){
		
		String temp = "";

		for (int i=count; i<=number; i++){

			if(i==count){
				temp = property+i;
			}
			else if(i !=count){
				temp = temp +"^!"+property+i;
			}
		}
		return temp;
	}

}
