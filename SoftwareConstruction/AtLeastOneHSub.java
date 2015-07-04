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
	
	/*In this method is type String method that will return an updated formula. We will be taking as parameters
	 * a String variable propName and an in variable numberOfProps. This method will change the proposition by
	 * add the proper symbols and syntax to the proposition. 
	 * Example of how the output should look like: piV...Vpn 
	 */
	
			public static String generateCP(String propName, int numberOfProps){
				
				String propReplacement = "";
				
				String name = propName;
				int number = numberOfProps;
				
				for(int i = 1; i <= number; i++ ){
					propReplacement = name + i;
					while(i != number){
						i++;
						propReplacement += " V "+name +i;
					}
				}
				
				return propReplacement;
			}
}