/*
 * The purpose of this class is to substitute the proposition placeholders with their
 * respective composite forms.  It will have one method called substituteCompositeProps().
 */
public class CPSubstitutor {

	/* substituteCompositeProps() will receive a base formula, Scope, and Pattern from 
	 * SubstitutionTable as parameters.  It will search the string for the proposition
	 * placeholders (P, Q, L, and R) and call methods from the corresponding Substitutor
	 * class passing it the corresponding Proposition type.  Through this process, it will
	 * create a modified formula string that it will pass to a method in the 
	 * SpecialOperator class.  It will receive a final formula string in return from
	 * SpecialOperator, and it will return this final formula string to SubstitutionTable.
	 */
	public void substituteCompositeProps(String baseFormula, Proposition propP, Proposition propQ, Proposition propL, Proposition propR){    	
		String baseWithP = baseFormula;
		String baseWithPQ = baseFormula;
		String baseWithPQL = baseFormula;
		String baseWithPQLR = baseFormula;
		
		if(isComposite(propP))
		{
			String cpFormulaP = getCPFormula(propP);
			baseWithP = baseFormula.replaceAll("P", cpFormulaP);
		}
		else if (isComposite(propQ))
		{
			String cpFormulaQ = getCPFormula(propQ);
			baseWithPQ = baseWithP.replaceAll("Q", cpFormulaQ);
		}
		else if (isComposite(propL))
		{
			String cpFormulaL = getCPFormula(propL);
			baseWithPQL = baseWithPQ.replaceAll("L", cpFormulaL);
		}
		else if (isComposite(propR))
		{
			String cpFormulaR = getCPFormula(propR);
			baseWithPQLR = baseWithPQL.replaceAll("R", cpFormulaR);
		}

		// Call next method to replace the special & symbols, passing baseWithPQLR 
	}
	
	/* Gets the proposition type and checks if it atomic
	 */
	boolean isComposite(Proposition proposition) {
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
	private String getCPFormula(Proposition inProposition) {
		String type = inProposition.getType();
		String name = inProposition.getName();
		int number = ((Composite) inProposition).getNumber();
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