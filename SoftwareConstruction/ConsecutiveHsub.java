
public class ConsecutiveHSub {

	//(p1∧¬p2∧···∧¬pn∧X(p2∧¬p3 ∧···∧¬pn ∧ X(··· ∧ X(pn−1 ∧ ¬pn ∧ Xpn))···))

	public static String generateCP (String name, int number){
		String formula = "(";
		int closingcount =0; //tracks the number of closing parenthesis

		for ( int i =1; i <=number; i++){
			if(i!= number){
			formula = formula + firstTrueAndNotProperties( name, i, number);
			formula = formula +"^X(";
			}
			else {
				formula = formula + firstTrueAndNotProperties( name, number, number);
				for(int j=1; j<= number ; j++){
					formula = formula + ")";
				}
			}
		}

		return formula;
	}

	private static String firstTrueAndNotProperties(String property, int count, int number){
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

	public static void main (String [] args){
		System.out.println(generateCP ("P", 4));
	}
}
