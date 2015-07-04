
public class ParallelHSub{
	
	public static String generateCP(String propName, int numberOfProps) {

		String propReplacement = "";
		
		String name = propName;
		int number = numberOfProps;

		for (int i = 1; i <= number; i++) {
			while(i != number){
			propReplacement += name + i + "^";
			i++;
			}
			if(i == number){
				propReplacement += name + i;
			}
		}
		return propReplacement;
	}	
}