/*Contains string substitution data for each possible pattern given the Global
 * scope. It will return the formula template with the special & operators.
 */
public class GlobalTable
{	
	/* Method AfterLUntilRSubstitution() receives appropriate properties such as the string array containing a Scope, 
	 * a Pattern, and all necessary Proposition types and will do the string substituion given the after global
	 * scope and will return the template to the formula creator.
	 */
	public static String getFormula(Pattern pattern)
	{
		String formula = null;
		
		/** 
		 * This code can be replaced if we just add a "getName()" method to 
		 * the pattern class....
		 * */
		String patternType = null;
		patternType = pattern.getClass().toString();
		
		switch(patternType)
		{
		case "Absence": 
			//Do something
			break;
		case "Existence":
			//
			break;
		case "StrictPrecedence":
			//
			break;
		case "Precedence":
			//
			break;
			
		}
		
		return formula;
	}

	//Foremost we care about the pattern Then
	//About whether P is of type C or E
	//Q is of type AtLeastOneC or ParallelC *
	//Q is not of type AtLeastOneC or ParallelC
}
