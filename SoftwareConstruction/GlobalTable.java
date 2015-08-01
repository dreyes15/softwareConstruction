/*Contains string substitution data for each possible pattern given the Global
 * scope. It will return the formula template with the special & operators.
 */
public class GlobalTable {

	// //Foremost we care about the pattern Then
	// //About whether P is of type C or E
	// //Q is of type AtLeastOneC or ParallelC *
	// //Q is not of type AtLeastOneC or ParallelC
	//
	public char getLastLetter(Proposition P) {
		Proposition prop = P;
		String propType = prop.getType();

		char lastLetter = propType.charAt(propType.length - 1);

		return lastLetter;
	}

	public String getFormula(Absence pattern) {
		String baseFormula = "[]!P";
		return baseFormula;
	}

	public String getFormula(Existence pattern) {
		String baseFormula = "<>P";
		return baseFormula;
	}

	public String getFormula(Response pattern) {
		String baseFormula = "[](P->(P&l<>Q)))";
		return baseFormula;
	}

	public String getFormula(StrictPrecedence pattern) {
		Proposition prop = pattern.getPropositionP();
		char endLetter = getLastLetter(p);
		String baseFormula = " ";
		String baseFormula1 = " ";
		String baseFormula2 = " ";
		String baseFormula3 = " ";
		String baseFormula4 = " ";

		if (endLetter == 'C') {
			baseFormula = "!((!(Q&r!P))UP)";
		}

		else if (endLetter == 'E') {
			int pNumber = p.getNumber();
			baseFormula1 = "!((!(Q&r!(";
			for (int i = 1; i <= pNumber - 1; i++) {
				baseFormula2 += "!p" + i + "^";
			}
			baseFormula3 = "Ph)))U(";
			baseFormula4 = "Ph))";

			return baseFormula = baseFormula1 + baseFormula2 + baseFormula3
					+ baseFormula2 + baseFormula4;
		}
	}

	public String getFormula(Precedence pattern){
		Proposition propP = pattern.getPropositionP();
		Proposition propQ = pattern.getPropositionQ();
		
		String qpropType = propQ.getType();
		char endLetter = getLastLetter(p);
		
		String baseFormula = " ";
		String baseFormula1 = " ";
		String baseFormula2 = " ";
		String baseFormula3 = " ";
		String baseFormula4 = " ";

		

		if(endLetter == 'C'){
			if(qPropType == "AtLeastOneC" || qPropType == "ParallelC"){
				return baseFormula = "!((!Q)U(P^!Q))";
			}
			else{
				return baseFormula = "!((!(Q&-l!P))UP)";
			}
		}
		else if(endLetter == 'E'){
			if(qPropType == "AtLeastOneC" || qPropType == "ParallelC"){
				baseFormula1 = "!((!(Q^!(";
				int pNumber = p.getNumber();
				for(int i = 1; i <= pNumber - 1; i++){
					baseFormula2 += "!p" + i + "^";
				}
				baseFormula3 = "XPh)))U(";
				baseFormula4 = "XPh^!Q))";
				return baseFormula = baseFormula1 + baseFormula2 + baseFormula3 + baseFormula2 + baseFormula4;
			}
			else{
				int pNumber = p.getNumber();
				baseFormula1 = "!((!(Q&-l!(";
				for(int i = 1; i <= pNumber - 1; i++){
					baseFormula2 += "!p" + i + "^";
				}
				baseFormula3 = "XPh)))U(";
				baseFormula4 = "XPh))";
				
				return baseFormula = baseFormula1 + baseFormula2 + baseFormula3 + baseFormula2 + baseFormula4;
			}
		}
	}
}
