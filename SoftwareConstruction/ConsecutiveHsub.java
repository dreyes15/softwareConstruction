
public class ConsecutiveHSub {

	//(p1∧¬p2∧···∧¬pn∧X(p2∧¬p3 ∧···∧¬pn ∧ X(··· ∧ X(pn−1 ∧ ¬pn ∧ Xpn))···))
	
	public static String generateCP (String name, int number){
		String formula = name;
		int closingcount =0; //tracks the number of closing parenthesis
		
		
		for( int i =1; i<= number; i++){	 //creates the first section of the formula
			formula = "(" + name +i;		//p1^!p2^..^!pn
			while(i!= number){
				i++;
				formula += "^!"+ name +i;
			}
		}
		for(int j =1; j<= number; j++){					//creates the second section of the formula
			formula = formula + "^X(" + name+ (j=j+1); 		// ^X( p2
			while (j!=number){
				j++;	
				formula += "^!"+name +j;				// ^!p3 ... ^!pn
			}
		}
		
		/*for (int k =0; k<= (number-1); k++){				//creates the third section of the formula
			formula = formula + "^X(" + name + 	(number - number);			//^X( pn-n
			while (k != (number-1)){
				k++;
				formula = formula + "^X(" + name + (number - k);		//^X(Pn-1
			}
		}*/
		
		for (int l = 0; l < formula.length(); l++){
			if( formula == "("){
				closingcount ++;
			}
		}
		
		for (int m =0; m < closingcount ; m ++){
			formula = formula +")";
		}
		
		
		return formula;
	}
	
	public static void main (String [] args){
		
		System.out.println(generateCP("p",4));
	}
}
