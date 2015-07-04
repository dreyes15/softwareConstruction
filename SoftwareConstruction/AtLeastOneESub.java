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
import java.util.*;
public class AtLeastOneESub{
	
	//(-p1^....^pn)^((-p1^...^-pn)U(p1V..Vpn))
		public String generateCP(String propName, int numberOfProps){
			
			String propReplacement = "";
			String intialSubFormula = "";//first chunck of formula
			String middleSubFormula = "";//send chunck of formula
			String lastSubFormula = "";//thind chunck of formula
			
			String name = propName;
			int number = numberOfProps;
			
			for(int i = 1; i <= number; i++){
				initialSubFormula += "(¬" + name + i;
				while(i != number){
					i++;
					intialSubFormula += " ^¬ "+name +i;
				}
				intialSubFormula += ")^";
				i = 1;

				middleSubFormula = "((¬" + name + i;
				while(i != number){
					i++;
					middleSubFormula += " ^¬ "+name +i;
				}
				middleSubFormula += ")U";
				i = 1;

				lastSubFormula = "(" + name + i;
				while(i != number){
					i++;
					lastSubFormula += " V "+ name +i;
				}
				lastSubFormula += "))";

			}
			propReplacement = initialSubFormula + middleSubFormula + lastSubFormula;
			return propReplacemet;
			//System.out.println(x + p2 + p3);
		}
}