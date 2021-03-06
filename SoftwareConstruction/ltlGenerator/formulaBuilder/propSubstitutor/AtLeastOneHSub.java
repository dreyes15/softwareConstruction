package ltlGenerator.formulaBuilder.propSubstitutor;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity,
 * 		 Lucia Rodriguez, and David Reyes
 * Project: LTL Generator
 * Due Date: August 3, 2015
 */

public class AtLeastOneHSub{
	
	/*In this method is type String method that will return an updated formula. We will be taking as parameters
	 * a String variable propName and an in variable numberOfProps. This method will change the proposition by
	 * add the proper symbols and syntax to the proposition. 
	 * Example of how the output should look like: piV...Vpn 
	 */
	
	public static String generateCP(String propName, int numberOfProps){
		
		String propReplacement = "(";
		
		String name = propName;
		int number = numberOfProps;
		
		for(int i = 1; i <= number; i++ ){
			propReplacement += name + i;
			while(i != number){
				i++;
				propReplacement += "V"+name +i;
			}
		}
		propReplacement = propReplacement + ")";
		
		return propReplacement;
	}

}