package ltlGenerator.formulaBuilder.propSubstitutor;
import ltlGenerator.propertyBuilder.proposition.Composite;
import ltlGenerator.propertyBuilder.proposition.Proposition;

/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 * Purpose: To substitute the proposition placeholders with their respective composite
 * forms.  It will have one method called substituteCompositeProps().
 */
public class PropSubstitutor {
	
	final static String HOLD = "H";	//The template for a Proposition of type hold, used in the base formula.

	/* substituteCompositeProps() will receive a base formula, Scope, and Pattern from 
	 * SubstitutionTable as parameters.  It will search the string for the proposition
	 * placeholders (P, Q, L, and R) and call methods from the corresponding Substitutor
	 * class passing it the corresponding Proposition type.  Through this process, it will
	 * create a modified formula string that it will pass to a method in the 
	 * SpecialOperator class.  It will receive a final formula string in return from
	 * SpecialOperator, and it will return this final formula string to SubstitutionTable.
	 */
	public static String substituteCompositeProps(String baseFormula, Proposition proposition){    	
		
		String propName = proposition.getName();
		String propType = proposition.getType();
		String formulaCorE = "";
		String replacedWithCP = "";
		String formulaH = "";
		String replacedFormula = "";
		String holdPlaceholder = propName.toLowerCase() + HOLD;
		
		if(isComposite(proposition))
		{
			formulaCorE = getCPFormula(proposition);			
			replacedWithCP = baseFormula.replaceAll(propName, formulaCorE);			
			formulaH = getHoldCPFormula(proposition);			
			replacedFormula = replacedWithCP.replaceAll(holdPlaceholder, formulaH);
			
			return replacedFormula;
		}
		else if (propType == "Atomic")
		{
			replacedFormula = baseFormula.replaceAll(holdPlaceholder, propName);
			replacedFormula = replacedFormula.replaceAll(propName, "(" + propName + ")");
			
			return replacedFormula;
		}
		else //Replace the pH, qH, lH, rH with P, Q, L, R
		{
			//holdPlaceholder = propName.toLowerCase() + HOLD;
			replacedFormula = baseFormula.replaceAll(holdPlaceholder, propName);
			
			return replacedFormula;
		}
	}

	
	/* Gets the proposition type and checks if it is composite. Will return false
	 * if the proposition is either atomic or null, otherwise it returns true.
	 */
	static boolean isComposite(Proposition proposition) {
		if(proposition == null)
		{
			return false;
		}
		
		String type = proposition.getType(); 
		if (type.equals("Atomic"))
		{
			return false;
		} 
		return true;
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
				
		return getCPFormula(name, typeHold, number);
	}
	
	/* Takes in a proposition object then calls the method
	 * which will call the right class to generate the CP formula
	 */
	static String getCPFormula(Proposition proposition) {
		String type = proposition.getType();
		String name = proposition.getName();
		int number = ((Composite) proposition).getNumber();
		
		return getCPFormula(name, type, number);
	}

	/* Gets the appropriate CP formula for a given composite proposition. First it gets the
	 * type of the proposition, and it calls the CPType substitution class which will need
	 * the name and number of propositions for the composite proposition. Then, it returns
	 * the composite proposition formula.
	 */
	private static String getCPFormula(String name, String type, int number) {
		String cpFormula = null;
		
		switch (type)
		{
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
			cpFormula = "<CP Not Found for " + name + ">";
			break;
		}
		return cpFormula;
	}
}