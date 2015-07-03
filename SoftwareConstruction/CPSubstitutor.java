/*
 * The purpose of this class is to substitute the proposition placeholders with their
 * respective composite forms.  It will have one method called substituteCompositeProps().
 */
public class CPSubstitutor {
	final static String HOLD = "h";	//The template for a Proposition of type hold, used in the base formula.

	/* substituteCompositeProps() will receive a base formula, Scope, and Pattern from 
	 * SubstitutionTable as parameters.  It will search the string for the proposition
	 * placeholders (P, Q, L, and R) and call methods from the corresponding Substitutor
	 * class passing it the corresponding Proposition type.  Through this process, it will
	 * create a modified formula string that it will pass to a method in the 
	 * SpecialOperator class.  It will receive a final formula string in return from
	 * SpecialOperator, and it will return this final formula string to SubstitutionTable.
	 */
	public String substituteCompositeProps(String baseFormula, Proposition propP, Proposition propQ, Proposition propL, Proposition propR){    	
		String baseWithP = baseFormula;
		String baseWithPQ = baseFormula;
		String baseWithPQL = baseFormula;
		String baseWithPQLR = baseFormula;
		
		if(isComposite(propP))
		{
			String cpFormulaPH = getHoldCPFormula(propP);
			baseWithP = baseFormula.replaceAll("P"+ HOLD, cpFormulaPH);
			
			String cpFormulaP = getCPFormula(propP);
			baseWithP = baseWithP.replaceAll("P", cpFormulaP);
		}
		
		if (isComposite(propQ))
		{
			String cpFormulaQH = getHoldCPFormula(propQ);
			baseWithPQ = baseFormula.replaceAll("Q"+ HOLD, cpFormulaQH);
			
			String cpFormulaQ = getCPFormula(propQ);
			baseWithPQ = baseWithP.replaceAll("Q", cpFormulaQ);
		}
		
		if (isComposite(propL))
		{
			String cpFormulaLH = getHoldCPFormula(propL);
			baseWithPQL = baseFormula.replaceAll("P"+ HOLD, cpFormulaLH);
			
			String cpFormulaL = getCPFormula(propL);
			baseWithPQL = baseWithPQ.replaceAll("L", cpFormulaL);
		}
		
		if (isComposite(propR))
		{
			String cpFormulaRH = getHoldCPFormula(propR);
			baseWithPQLR = baseFormula.replaceAll("P"+ HOLD, cpFormulaRH);
			
			String cpFormulaR = getCPFormula(propR);
			baseWithPQLR = baseWithPQL.replaceAll("R", cpFormulaR);
		}
		return baseWithPQLR;
	}
	
		
	/* Takes in a proposition object then calls the method
	 * which will call the right class to generate the CP formula
	 */
	static String getHoldCPFormula(Proposition proposition) {
		String type = proposition.getType();
		String name = proposition.getName();
		int number = ((Composite) proposition).getNumber();
		
		String typeWithoutCorE = type.substring(0, type.length()-1);
		String typeHold = typeWithoutCorE + HOLD;
				
		return getCPFormula(typeHold, name, number);
	}
	
	/* Takes in a proposition object then calls the method
	 * which will call the right class to generate the CP formula
	 */
	static String getCPFormula(Proposition proposition) {
		String type = proposition.getType();
		String name = proposition.getName();
		int number = ((Composite) proposition).getNumber();
		
		return getCPFormula(type, name, number);
	}
	
	/* Gets the proposition type and checks if it atomic
	 */
	static boolean isComposite(Proposition proposition) {
		String type = proposition.getType();
		if (!type.equals("Atomic")) {
			return true;
		}
		return false;
	}

	/* Gets the appropriate CP formula for a given composite proposition. First it gets the
	 * type of the proposition, and it calls the CPType substitution class which will need
	 * the name and number of propositions for the composite proposition. Then, it returns
	 * the composite proposition formula.
	 */
	private static String getCPFormula(String name, String type, int number) {
		String cpFormula = null;
		
		switch (type) {
		case "AtLeastOneC":
			cpFormula = AtLeastOneCSub.generateCP(name, number);
			break;
		case "AtLeastOneE":
			cpFormula = AtLeastOneESub.generateCP(name, number);
			break;
		case "AtLeastOneH":
			cpFormula = AtLeastOneHSub.generateCP(name, number);
			break;
		case "ParallelC":
			cpFormula = ParallelCSub.generateCP(name, number);
			break;
		case "ParallelE":
			cpFormula = ParallelESub.generateCP(name, number);
			break;
		case "ParallelH":
			cpFormula = ParallelHSub.generateCP(name, number);
			break;
		case "ConsecutiveC":
			cpFormula = ConsecutiveCSub.generateCP(name, number);
			break;
		case "ConsecutiveE":
			cpFormula = ConsecutiveESub.generateCP(name, number);
			break;
		case "ConsecutiveH":
			cpFormula = ConsecutiveHSub.generateCP(name, number);
			break;
		case "EventualC":
			cpFormula = EventualCSub.generateCP(name, number);
			break;
		case "EventualE":
			cpFormula = EventualESub.generateCP(name, number);
			break;
		case "EventualH":
			cpFormula = EventualHSub.generateCP(name, number);
			break;
		default:
			cpFormula = "<CPType Not Found for " + name + ">";
			break;
		}
		return cpFormula;
	}
}