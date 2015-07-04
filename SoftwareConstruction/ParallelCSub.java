/* Course: Software Construction / CS5374
 * Instructor: Omar Ochoa
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, Lucia Melgoza,
 * 		 and David Reyes 
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 */

public class ParallelCSub{
	
	public static String generateCP(String propName, int numberOfProps) {

		String propReplacement = "";
		
		String name = propName;
		int number = numberOfProps;

		for (int i = 1; i <= number; i++) {
			while(i != number){
			propReplacement += name + i + " ^ ";
			i++;
			}
			if(i == number){
				propReplacement += name + i;
			}
		}
		return propReplacement;
	}
	
}
