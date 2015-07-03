/* Represents a composite proposition of type condition, that holds at a state 's',
 * if each proposition holds in a specified order with one proposition holding per state,
 * at a successive rate. State 's' is the state in which the last consecutive proposition holds.
 */
/* Represents a composite proposition of type condition, that holds at a state 's',
 * if each proposition holds in a specified order with one proposition holding per state,
 * at a successive rate. State 's' is the state in which the last consecutive proposition holds.
 */

public class ConsecutiveCSub {
	//(p1 ^X( p2 ^X( .. ^X(pn) ) ) )
	public String generateCP (String name, int number){
		String formula = name;
		int closingcount =1;  //tracks the number of closing parenthesis
		
		for( int i =1; i<= number; i++){
			formula = "(" + name +i;
			while(i!= number){
				i++;
				formula += "^X("+ name +i;
				closingcount ++;
			}
		}
		for(int j =1; j<=closingcount ; j++){	//for loop to add the number of closing parenthesis
			formula = formula +")";
		}
		return formula;
	}
}