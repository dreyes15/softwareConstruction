/* Course: Software Construction / CS5374
 * /* Course: Software Construction / CS5374
 * Instructor: Omar Ochoa
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 */

public class ConsecutiveCSub {
	//(p1 ^X( p2 ^X( .. ^X(pn) ) ) )
	public String generateCP (String propName, int numberOfProps){
		
		String propReplacement = "";
		int closingcount =1;  //tracks the number of closing parenthesis
		
		String name = propName;
		int number = numberOfProps;
		
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