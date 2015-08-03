package ltlGenerator;

public class Main {

	public static void main(String[] args) {
		LTLGenerator ltlGen = new LTLGenerator();
		String finalFormula = ltlGen.getFinalFormula();
		System.out.println(finalFormula);
	}
}
