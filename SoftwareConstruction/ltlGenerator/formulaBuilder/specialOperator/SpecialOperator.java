package ltlGenerator.formulaBuilder.specialOperator;


/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity,
 * 		 Lucia Rodriguez, and David Reyes
 * Project: LTL Generator
 * Sprint: LTL Generator
 * Due Date: July 3, 2015
 * Purpouse: The purpose this class is to perform the special operations to compensate for the areas
 * in which direct substitution does not come out properly.  It will have one method called
 * performSpecialOperations().
 */
public class SpecialOperator {

	/*
     * performSpecialOperations() will receive a modifiedFormula from the FormulaCreator class as a
     * parameter.  It will call a method from each of the Special Operator classes (AndL, AndR, 
     * and AndNotL) to perform their respective operations on the modifiedFormula.  It will build a 
     * formualaWithSpecOpsPerformed from this process and return it to FormulaCreator.
     */
	public static String performSpecialOperations(String modifiedFormula) {
		
		AndL andL = new AndL();
		AndR andR = new AndR();
		AndNotL andNotL = new AndNotL();
		
		String formulaWithSpecOpsPerformed = modifiedFormula;
		
		formulaWithSpecOpsPerformed = andL.replaceAndL(formulaWithSpecOpsPerformed);
		formulaWithSpecOpsPerformed = andR.replaceAndR(formulaWithSpecOpsPerformed);
		formulaWithSpecOpsPerformed = andNotL.replaceAndNotL(formulaWithSpecOpsPerformed);
		
		return formulaWithSpecOpsPerformed;
	}
}