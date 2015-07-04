/* Course: Software Construction / CS5374
 * Instructor: Omar Ochoa
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 */

public class ConsecutiveHSub {
	/*
	*The method generate CP will create the follwoing formula by 
	* adding the proposition name and the number to a subformula:
	*(p1∧¬p2∧···∧¬pn∧X(p2∧¬p3 ∧···∧¬pn ∧ X(··· ∧ X(pn−1 ∧ ¬pn ∧ Xpn))···))
	*/
	public static String generateCP (String propName, int numberOfProps){
		
		String propReplacement = "(";
		int closingcount =0; //tracks the number of closing parenthesis

		String name = propName;
		int number = numberOfProps;
		//loop that will create the equation by adding the "And" operation as well as the "X("
		for ( int i =1; i <=number; i++){
			if(i!= number){
				propReplacement = propReplacement + firstTrueAndNotOperators( name, i, number);
				propReplacement = propReplacement +"^X(";
			}
			else {
				propReplacement = propReplacement + firstTrueAndNotOperators( name, number, number);
				// for loop that will add the closing parenthesis
				for(int j=1; j<= number ; j++){
					propReplacement = propReplacement + ")";
				}
			}
		}

		return propReplacement;
	}
	//Method that makes all propositions Not, except for the first one
	private static String firstTrueAndNotOperators(String name, int count, int number){
		
		String temp = "";
		// loop will add the And Not symbols to the preposition name and preposition number
		for (int i=count; i<=number; i++){
			//if it is the first prepsition we do not add the Not
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
