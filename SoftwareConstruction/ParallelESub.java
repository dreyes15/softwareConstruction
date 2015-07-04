
public class ParallelESub{
	
	public static String generateCP(String propName, int numberOfProps) {
				
		String propReplacement = "";
		String initialSubFormula = "";
		String middleSubFormula = "";
		String lastSubformula = "";
		
		String name = propName;
		int number = numberOfProps;
		
		for (int i = 1; i <= number; i++) {
			initialSubFormula = "( ¬ " + name + i;
			while (i != number) {
				i++;
				initialSubFormula += " ^ ¬ " + name + i;
			}
			initialSubFormula += ") ^ ";
			i = 1;

			middleSubFormula = "(( ¬ " + name + i;
			while (i != number) {
				i++;
				middleSubFormula += " ^ ¬ " + name + i;
			}
			middleSubFormula += ") U ";
			i = 1;

			lastSubFormula = "(" + name + i;
			while (i != number) {
				i++;
				lastSubFormula += " ^ " + name + i;
			}
			lastSubFormula += "))";

		}
		propReplacement = initialSubFormula+middleSubFormula+lastSubFormula;

		return (propReplacement);

	}
}