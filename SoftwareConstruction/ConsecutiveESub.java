/* Course: Software Construction / CS5374
 * Instructor: Omar Ochoa
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 */

public class ConsecutiveESub {

	public  String generateCP (String propName, int numberOfProps){
		
		String propReplacement = "";
		String beginninglSubFormula ="";
		String endingSubFormula = "";
		
		String name = propName;
		int number = numberOfProps;

			for(int i =1; i<=2 ; i++){
				beginningSubFormula = beginningSubFormula +"("+ notOperators(name, 1, number);
				if ( i ==1){
					beginningSubFormula = beginningSubFormula + ")^(";
				}
				else if( i ==2){
					beginningSubFormula = beginningSubFormula + ")U(";
				}
			}

		for ( int i =1; i <=number; i++){
			if(i!= number){
				endingSubFormula= endingSubFormula + firstTrueAndNotOperators( name, i, number);
				endingSubFormula = endingSubFormula +"^X(";
			}
			else {
				endingSubFormula = endingSubFormula + firstTrueAndNotOperators( name, number, number);
				for(int j=1; j<= (number+1) ; j++){
					endingSubFormula = endingSubFormula + ")";
				}
			}
		}
		propReplacement = beginningSubFormula + endingSubFormula;
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

	private static String notOperators(String name, int count, int number){
		
		String temp="";
		
		for(int i= count; i<=number; i++ ){
			if(i!= number){
				temp = temp+"!"+property+i+"^";
			}
			else if(i== number){
				temp = temp+"!"+property+i;
			}
		}
		temp.replace("^", "");
		return temp;
	}

}
