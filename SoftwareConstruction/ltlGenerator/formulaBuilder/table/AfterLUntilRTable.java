package ltlGenerator.formulaBuilder.table;
import ltlGenerator.propertyBuilder.patterns.Absence;
import ltlGenerator.propertyBuilder.patterns.Existence;
import ltlGenerator.propertyBuilder.patterns.Pattern;
import ltlGenerator.propertyBuilder.patterns.Precedence;
import ltlGenerator.propertyBuilder.patterns.Response;
import ltlGenerator.propertyBuilder.patterns.StrictPrecedence;
import ltlGenerator.propertyBuilder.proposition.Proposition;

/*Contains string substitution data for each possible pattern given the
 * After L until propR scope.It will return the formula template with the 
 * special & operators. 
 */
public class AfterLUntilRTable extends SubstitutionTable{

	private static String globalSubformula;
	private static String beforeRSubformula;
	private static Proposition propR;

	/*
	 * Method AfterLUntilRSubstitution() receives appropriate properties such as
	 * the string array containing a Scope, a Pattern, and all necessary
	 * Proposition types and will do the string substitution given the after L
	 * until propR scope and will return the template to the formula creator.
	 */
	public static String getFormula(Pattern pattern, Proposition propositionR) {

		propR = propositionR;
		getSubformulas(pattern);
		
		String formula = "";
		if (pattern instanceof Absence) {
			formula = getFormula((Absence) pattern);
		}
		else if (pattern instanceof Existence) {
			formula = getFormula((Existence) pattern);
		}
		else if (pattern instanceof StrictPrecedence) {
			formula = getFormula((StrictPrecedence) pattern);
		}
		else if (pattern instanceof Precedence) {
			formula = getFormula((Precedence) pattern);
		}
		else if (pattern instanceof Response) {
			formula = getFormula((Response) pattern);
		}
		return formula;
	}

	private static void getSubformulas(Pattern pattern) {
		globalSubformula = GlobalTable.getFormula(pattern);
		beforeRSubformula = BeforeRTable.getFormula(pattern, propR);
	}

	public static String getFormula(Existence pattern) {
        String baseFormula= "";
        
		if (propR.isEventType()) {
			baseFormula = "[]((L)->(L&l(((" + beforeRSubformula + ")^((!<>R)->(" + globalSubformula + "))))))";
		}
		else {
			baseFormula = "[]((L&r!R)->(L&l(((" + beforeRSubformula + ")^((!<>R)->(" + globalSubformula + "))))))";
		}
		return baseFormula;
	}

	public static String getFormula(StrictPrecedence pattern) {
        String baseFormula= "";
        
		if (propR.isEventType()) {
			 baseFormula = "[]((L)->(L&l(((" + beforeRSubformula + ")^((!<>R)->(" + globalSubformula + "))))))";
		} 
		else {
			 baseFormula = "[]((L&r!R)->(L&l(((" + beforeRSubformula + ")^((!<>R)->(" + globalSubformula + "))))))";
		}
		return baseFormula;
	}

	public static String getFormula(Precedence pattern) {
        String baseFormula= "";
        
		if (propR.isEventType()) {
			baseFormula = "[]((L)->(L&l(((" + beforeRSubformula + ")^((!<>R)->(" + globalSubformula + "))))))";
		}
		else {
			baseFormula = "[]((L&r!R)->(L&l(((" + beforeRSubformula + ")^((!<>R)->(" + globalSubformula + "))))))";
		}
		return baseFormula;
	}

	public static String getFormula(Absence pattern) {
        String baseFormula= "";
        
		if (propR.isEventType()) {
			baseFormula = "[]((L)->(L&l(((" + beforeRSubformula + ")^((!<>R)->(" + globalSubformula + "))))))";
		}
		else {
			baseFormula = "[]((L&r!R)->(L&l(((" + beforeRSubformula + ")^((!<>R)->(" + globalSubformula + "))))))";
		}
		return baseFormula;
	}

	public static String getFormula(Response pattern) {
        String baseFormula= "";

		if (propR.isEventType()) {
			baseFormula = "[]((L)->(L&l(((" + beforeRSubformula + ")^((!<>R)->(" + globalSubformula + "))))))";
		}
		else {
			baseFormula = "[]((L&r!R)->(L&l(((" + beforeRSubformula + ")^((!<>R)->(" + globalSubformula + "))))))";
		}
		return baseFormula;
	}
}