
public class ParallelCSub{
	
	public static String ParallelCSubstitution(String name, int number) {

		String sub = " ";

		for (int i = 1; i <= number; i++) {
			while(i != number){
			sub += name + i + " ^ ";
			i++;
			}
			if(i == number){
				sub += name + i;
			}
		}
		return sub;
	}
	
}