/*
 * The purpose of this class is to substitute the proposition placeholders with their
 * respective composite forms.  It will have one method called substituteCompositeProps().
 */
public class CPSubstitutor {

    /*
     * substituteCompositeProps() will receive a base formula, Scope, and Pattern from 
     * SubstitutionTable as parameters.  It will search the string for the proposition
     * placeholders (P, Q, L, and R) and call methods from the corresponding Substitutor
     * class passing it the corresponding Proposition type.  Through this process, it will
     * create a modified formula string that it will pass to a method in the 
     * SpecialOperator class.  It will receive a final formula string in return from
     * SpecialOperator, and it will return this final formula string to SubstitutionTable.
     */
    substituteCompositeProps(String baseFormula, Proposition propP, Proposition propQ, Proposition propL, Proposition propR){
    	//Generate the CPs of the placeholders
    	String CPofP = propP.generateCP();
    	String CPofQ = propQ.generateCP();
       	String CPofL = propL.generateCP();
    	String CPofR = propR.generateCP();
    	
    	//Replace the proposition placeholders with the appropriate CP type formula
    	String baseWithP = baseFormula.replaceAll("P", CPofP)
    	String baseWithPQ = baseWithP.replaceAll("Q", CPofQ);
    	String baseWithPQR = baseWithPQ.replaceAll("R", CPofR);
    	String baseWithPQRL = baseWithPQR.replaceAll("L", CPofL);
    	
    	//Call to the SubstitutionTable
    }
}