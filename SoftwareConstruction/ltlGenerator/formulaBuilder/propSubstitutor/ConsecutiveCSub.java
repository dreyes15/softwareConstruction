package ltlGenerator.formulaBuilder.propSubstitutor;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity,
 * 		 Lucia Rodriguez, and David Reyes
 * Project: LTL Generator
 * Due Date: August 3, 2015
 */

public class ConsecutiveCSub {
	/*
	*The method generate CP will create the follwoing formula by 
	* adding the proposition name and the number to a subformula:
	*(p1 ^X( p2 ^X( .. ^X(pn) ) ) )
	*/
	public static String generateCP (String propName, int numberOfProps){
		
		String propReplacement = "";
		int closingcount =1;  //tracks the number of closing parenthesis
		
		String name = propName;
		int number = numberOfProps;
		
		// for loop that combines the number and name of the proposition as well as the "And" operatior, and "X(""
		for( int i =1; i<= number; i++){	
			propReplacement = "(" + name +i;
			while(i!= number){
				i++;
				propReplacement += "^X("+ name +i;
				closingcount ++;
			}
		}
		for(int j =1; j<=closingcount ; j++){	//for loop to add the number of closing parenthesis
			propReplacement = propReplacement +")";
		}
		return propReplacement;
	}
}
