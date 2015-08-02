package ltlGenerator.formulaBuilder.table;
import ltlGenerator.propertyBuilder.patterns.Absence;
import ltlGenerator.propertyBuilder.patterns.Existence;
import ltlGenerator.propertyBuilder.patterns.Pattern;
import ltlGenerator.propertyBuilder.patterns.Precedence;
import ltlGenerator.propertyBuilder.patterns.Response;
import ltlGenerator.propertyBuilder.patterns.StrictPrecedence;

/*Contains the string substitution for each possible pattern given the
 * After L scope.It will return the formula template with the 
 * special & operators.
 * 
 */
public class AfterLTable extends SubstitutionTable{
	
	private static String globalSubformula;
	
	public static String getFormula(Pattern pattern) {
		
		globalSubformula = GlobalTable.getFormula(pattern);
		
		String formula = "";
		
		if (pattern instanceof Absence) {
			formula = getFormula((Absence) pattern);
		}
		else if (pattern instanceof Existence) {
			formula = getFormula((Existence) pattern);
		}
		else if (pattern instanceof Response) {
			formula = getFormula((Response) pattern);
		}
		else if (pattern instanceof Precedence) {
			formula = getFormula((Precedence) pattern);
		}
		else if (pattern instanceof StrictPrecedence) {
			formula = getFormula((StrictPrecedence) pattern);
		}
		return formula;
	}
	
	public static String getFormula(Absence pattern){
		
		String baseFormula = "!((!L)U(L&l!" + globalSubformula + "))";
		
		return baseFormula;
	}
	
	public static String getFormula(Existence pat){
		
		String baseFormula = "!((!L)U(L&l!" + globalSubformula + "))";
		
		return baseFormula;
	}
	
	public static String getFormula(Precedence pat){
		
		String baseFormula = "!((!L)U(L&l!" + globalSubformula + "))";
		
		return baseFormula;
	}
	
	public static String getFormula(StrictPrecedence pat){
		
		String baseFormula = "!((!L)U(L&l!" + globalSubformula + "))";
		
		return baseFormula;
	}
	
	public static String getFormula(Response pat){
		
		String baseFormula = "!((!L)U(L&l!" + globalSubformula + "))";
		
		return baseFormula;
	}
}
