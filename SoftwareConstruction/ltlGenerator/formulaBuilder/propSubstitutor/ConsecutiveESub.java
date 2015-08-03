package ltlGenerator.formulaBuilder.propSubstitutor;
/* Course: Software Construction / CS5374
 * Instructor: Omar Ochoa
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Reyes
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 */

public class ConsecutiveESub {

	/*
	*The method generate CP will create the follwoing formula by 
	* adding the proposition name and the number to a subformula:
	*(!p1^…^!pn)^((!p1^…^!pn)U(p1^!p2^…^!pn^X(p2^!p3^…^!pn^X(…^X(pn-1^!pn^Xpn))…)))
	*/
	public static String generateCP (String propName, int numberOfProps){
		
		String propReplacement = "";
		String beginningSubFormula ="(";
		String endingSubFormula = "";
		
		String name = propName;
		int number = numberOfProps;
			// for loop that will create the beginnning part of the subformula
			for(int i =1; i<=2 ; i++){
				beginningSubFormula = beginningSubFormula +"("+ notOperators(name, 1, number);
				if ( i ==1){
					beginningSubFormula = beginningSubFormula + ")^(";
				}
				else if( i ==2){
					beginningSubFormula = beginningSubFormula + ")U((";
				}
			}
		// for loop that will create the ending part of the subformula
		for ( int i =1; i <=number; i++){
			if(i!= number){
				endingSubFormula= endingSubFormula + firstTrueAndNotOperators( name, i, number);
				endingSubFormula = endingSubFormula +")^X((";
			}
			else {
				endingSubFormula = endingSubFormula + firstTrueAndNotOperators( name, number, number);
				for(int j=1; j<= (number+1) ; j++){
					endingSubFormula = endingSubFormula + ")";
				}
			}
		}
		propReplacement = beginningSubFormula + endingSubFormula + "))";
		return propReplacement;
	}

	//method that creates the first proposition true, and the rest have AND NOT Operators
	private static String firstTrueAndNotOperators(String name, int count, int number){
		
		String temp = "";

		for (int i=count; i<=number; i++){

			if(i==count){
				temp = name+i;
			}
			else if(i !=count){
				temp = temp +"^!("+name+i+")";
			}
		}
		return temp;
	}
	// Method that makes all the Prepostion have NOT operators
	private static String notOperators(String name, int count, int number){
		
		String temp="";
		
		for(int i= count; i<=number; i++ ){
			if(i!= number){
				temp = temp+"!("+name+i+")^";
			}
			else if(i== number){
				temp = temp+"!("+name+i+")";
			}
		}
		temp.replace("^", "");
		return temp;
	}

}
