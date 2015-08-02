package ltlGenerator.formulaBuilder.propSubstitutor;
/* Course: Software Construction / CS5374
 * Instructor: Omar Ochoa
<<<<<<< HEAD
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
=======
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, Lucia Melgoza,
 * 		 and David Reyes 
>>>>>>> branch 'master' of https://github.com/dreyes15/softwareConstruction.git
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 */

public class AtLeastOneESub{
	
	/*In this method is type String method that will return an updated formula. We will be taking as parameters
	 * a String variable propName and an in variable numberOfProps. This method will change the proposition by
	 * add the proper symbols and syntax to the proposition. 
	 * In this particular method we will be using 4 different string variables that will be storing chuncks of the
	 * proposition formula, once we return it will add each chunck and then return it. 
	 * Example of how the output should look like: (-p1^....^pn)^((-p1^...^-pn)U(p1V..Vpn))
	 */
		public static String generateCP(String propName, int numberOfProps){
			
			String propReplacement = "";
			String initialSubFormula = "";//first chunck of formula
			String middleSubFormula = "";//send chunck of formula
			String lastSubFormula = "";//thind chunck of formula
			
			String name = propName;
			int number = numberOfProps;
			
			for(int i = 1; i <= number; i++){
				initialSubFormula += "((!(" + name + i + ")";
				while(i != number){
					i++;
					initialSubFormula += "^!("+name + i + ")";
				}
				initialSubFormula += ")^";
				i = 1;

				middleSubFormula = "((!(" + name + i + ")";
				while(i != number){
					i++;
					middleSubFormula += "^!("+name +i + ")";
				}
				middleSubFormula += ")U(";
				i = 1;

				lastSubFormula = name + i;
				while(i != number){
					i++;
					lastSubFormula += "V"+ name +i;
				}
				lastSubFormula += ")))";

			}
			propReplacement = initialSubFormula + middleSubFormula + lastSubFormula;
			return propReplacement;
			//System.out.println(x + p2 + p3);
		}
}