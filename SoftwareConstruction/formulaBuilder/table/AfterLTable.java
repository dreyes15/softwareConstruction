package formulaBuilder.table;
import formulaBuilder.propertyBuilder.*;
import propertyBuilder.patterns.Absence;
import propertyBuilder.patterns.Existence;
import propertyBuilder.patterns.Pattern;
import propertyBuilder.patterns.Precedence;
import propertyBuilder.patterns.Response;
import propertyBuilder.patterns.StrictPrecedence;

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
