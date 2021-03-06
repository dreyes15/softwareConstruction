package ltlGenerator.formulaBuilder.specialOperator;


/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity,
 * 		 Lucia Rodriguez, and David Reyes
 * Project: LTL Generator
 * Due Date: August 3, 2015
 */
public class SpecialOperator {

	/*
     * performSpecialOperations() will receive a formula string as a parameter.  It will call a method from 
     * each of the Special Operator classes (AndL, AndR, and AndNotL) to perform their respective operations 
     * on the formula string.  It will build a formualaWithSpecOpsPerformed from this process and return it.
     */
	public static String performSpecialOperations(String formula) {
		
		AndL andL = new AndL();
		AndR andR = new AndR();
		AndNotL andNotL = new AndNotL();
		
		String formulaWithSpecOpsPerformed = formula;
		
		formulaWithSpecOpsPerformed = andL.replaceAndL(formulaWithSpecOpsPerformed);
		formulaWithSpecOpsPerformed = andR.replaceAndR(formulaWithSpecOpsPerformed);
		formulaWithSpecOpsPerformed = andNotL.replaceAndNotL(formulaWithSpecOpsPerformed);
		
		return formulaWithSpecOpsPerformed;
	}
}