package formulaBuilder.table;
import propertyBuilder.patterns.Absence;
import propertyBuilder.patterns.Existence;
import propertyBuilder.patterns.Pattern;
import propertyBuilder.patterns.Precedence;
import propertyBuilder.patterns.Response;
import propertyBuilder.patterns.StrictPrecedence;
import propertyBuilder.proposition.Proposition;

/*Contains string substitution data for each possible pattern given the Global
 * scope. It will return the formula template with the special & operators.
 */
public class GlobalTable extends SubstitutionTable {
	
	private static Proposition propP;
	private static int pNumber;
	
	public static String getFormula(Pattern pattern) {
		
		propP = pattern.getPropositionP();
		pNumber = propP.getNumber();
		
		String formula = "";
		if (pattern instanceof Absence)
		{
			formula = getFormula((Absence) pattern);
		}
		else if (pattern instanceof Existence)
		{
			formula = getFormula((Existence) pattern);
		}
		else if (pattern instanceof Response)
		{
			formula = getFormula((Response) pattern);
		}
		else if (pattern instanceof StrictPrecedence)
		{
			formula = getFormula((StrictPrecedence) pattern);
		}
		else if (pattern instanceof Precedence)
		{
			formula = getFormula((Precedence) pattern);
		}
		return formula;
	}

	public static String getFormula(Absence pattern) {
		
		String baseFormula = "[]!P";
		return baseFormula;
	}

	public static String getFormula(Existence pattern) {
		
		String baseFormula = "<>P";
		return baseFormula;
	}

	public static String getFormula(Response pattern) {
		
		String baseFormula = "[](P->(P&l<>Q)))";
		return baseFormula;
	}

	public static String getFormula(StrictPrecedence pattern) {
		
		String baseFormula = "";
		
		if (propP.isEventType()) {
			String baseFormula1 = "!((!(Q&r!(";
			String baseFormula2 = getAllNotSubformula('p', pNumber);
			String baseFormula3 = "Ph)))U(";
			String baseFormula4 = "Ph))";

			baseFormula = baseFormula1 + baseFormula2 + baseFormula3
					+ baseFormula2 + baseFormula4;
		}
		else {
			baseFormula = "!((!(Q&r!P))UP)";
		}
		return baseFormula;
	}

	public static String getFormula(Precedence pattern){
		
		Proposition propQ = pattern.getPropositionQ();
		String propQType = propQ.getType();
		
		String baseFormula = "";

		if(propP.isEventType()){
			if(propQType == "AtLeastOneC" || propQType == "ParallelC"){
				String baseFormula1 = "!((!(Q^!(";
				String baseFormula2 = getAllNotSubformula('p', pNumber);
				String baseFormula3 = "XPh)))U(";
				String baseFormula4 = "XPh^!Q))";
				baseFormula = baseFormula1 + baseFormula2 + baseFormula3 + baseFormula2 + baseFormula4;
			}
			else{
				int pNumber = propP.getNumber();
				String baseFormula1 = "!((!(Q&-l!(";
				String baseFormula2 = getAllNotSubformula('p', pNumber);
				String baseFormula3 = "XPh)))U(";
				String baseFormula4 = "XPh))";
				
				baseFormula = baseFormula1 + baseFormula2 + baseFormula3 + baseFormula2 + baseFormula4;
			}
		}
		else {
			if(propQType == "AtLeastOneC" || propQType == "ParallelC"){
				baseFormula = "!((!Q)U(P^!Q))";
			}
			else{
				baseFormula = "!((!(Q&-l!P))UP)";
			}
		}
		return baseFormula;
	}
}