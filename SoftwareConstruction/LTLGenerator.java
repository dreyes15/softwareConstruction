/*This class is the main driver of the LTL Formula generation process.  It receives
 * a text file containing a Scope, a Pattern, and all necessary Proposition types
 * (including the number of each proposition for composite types), and it returns an
 * LTL Formula that matches the given Property data.  It is made up of a Constructor 
 * and the following four routines: formatData(), convertDataToProperty(), 
 * convertPropertyToFormula(), and saveFormulaToFile().
 */	

public class LTLGenerator {
	
	/*The LTLGenerator() constructor will take a text file as its parameter. It will have
	 * a string called FinalFormula that is assigned the result of passing the text file
	 * as a parameter of the formatData() method.
	 */
	public LTLGenerator(String formula){
		String FinalFormula;
		FinalFormula = formatData(formula);
		
	}
	
	/*formatData() takes the text file as an input. It parses this text file by line
	 * into a string array.  It passes this array to the ConvertDataToProperty() method.
	 * This routine is responsible for notifying the user if the text file does
	 * not exist.
	 */
	public void formarData(){
		String FinalFormulaArray[] = formula.split("");
		convertDataProperty(FinalFormulaArray);
	}   
	
	
	/*convertDataToProperty() takes the array from FormatData() as input. It passes this
	 * array to the Property class and receives a Property object in return. It then passes
	 * the Property object to the ConvertPropertyToFormula() method.  This routine is
	 * responsible for notifying the user if a Property object could not be created.
	 */
	public void convertDataToProperty(String FinalFormulaArray[]){
		
	}
	
	/*convertPropertyToFormula() takes the Property object from ConvertDataToProperty()
	 * as input.  It passes this object to the FormulaCreator class and receives a full
	 * LTL Formula in return.  It then passes the LTL Formula to the SaveFormulaToFile()
	 * method.  This routine is responsible for notifying the user if an LTL Formula
	 * could not be created.
	 */
	public void convertPropertyFormula(){
		
	}
	
	
	/*saveFormulaToFile() takes the LTL Formula from ConvertPropertyToFormula() as
	 * input.  It writes the LTL Formula to the output file. This routine is responsible
	 * for notifying the user if the formula cannot be written to the output file.
	 */

	public void saveFormulaToFile(){
		
	}
}
