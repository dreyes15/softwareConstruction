
/*This class is the main driver of the LTL Formula generation process.  It receives
 * a text file containing a Scope, a Pattern, and all necessary Proposition types
 * (including the number of each proposition for composite types), and it returns an
 * LTL Formula that matches the given Property data.  It is made up of a Constructor 
 * and the following four routines: formatData(), convertDataToProperty(), 
 * convertPropertyToFormula(), and saveFormulaToFile().
 */	
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LTLGenerator {
	private static String finalFormula = "";

	public static void main(String [] args){
		LTLGenerator ltlGen = new LTLGenerator();
		System.out.println(finalFormula);
	}
	
	/*The LTLGenerator() constructor will take a text file as its parameter. It will have
	 * a string called FinalFormula that is assigned the result of passing the text file
	 * as a parameter of the formatData() method.
	 */
	public LTLGenerator(){ 
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"));
			formatData(bufferedReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/*formatData() takes the text file as an input. It parses this text file by line
	 * into a string array.  It passes this array to the ConvertDataToProperty() method.
	 * This routine is responsible for notifying the user if the text file does
	 * not exist.
	 */
	public static void formatData(BufferedReader bufferedReader){
		String line;
		List<String> formula = new ArrayList<String>();
		try {
			while((line = bufferedReader.readLine()) != null){
				StringTokenizer tokenizer = new StringTokenizer (line, " ");
				while(tokenizer.hasMoreElements()){
					tokenizer.nextElement();
					String pattern = tokenizer.nextElement().toString();
					pattern.trim();
					formula.add(pattern);
					if(tokenizer.hasMoreElements()){
						String number = tokenizer.nextElement().toString();
						formula.add(number);
					}
				}
			}
			convertDataToProperty(formula);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("The file does not exist");
		}
	}   

	/*convertDataToProperty() takes the array from FormatData() as input. It passes this
	 * array to the Property class and receives a Property object in return. It then passes
	 * the Property object to the ConvertPropertyToFormula() method.  This routine is
	 * responsible for notifying the user if a Property object could not be created.
	 */
	public static void convertDataToProperty(List<String> formula){
		
		String typeP = "P";
		Proposition propositionP = createProposition(typeP, formula.get(2), formula.get(3));
		String typeQ = "Q";
		Proposition propositionQ = createProposition(typeQ, formula.get(4), formula.get(5));
		String typeL = "L";
		Proposition propositionL = createProposition(typeL, formula.get(6), formula.get(7));
		String typeR = "R";
		Proposition propositionR = createProposition(typeR, formula.get(8), formula.get(9));

		Pattern pattern = createPattern(formula.get(1), propositionP, propositionQ);
		Scope scope = createScope(formula.get(0), propositionL, propositionR);
		
		Property property = new Property(scope,pattern);			
		finalFormula = convertPropertyFormula(property);
	}

	/*convertPropertyToFormula() takes the Property object from ConvertDataToProperty()
	 * as input.  It passes this object to the FormulaCreator class and receives a full
	 * LTL Formula in return.  It then passes the LTL Formula to the SaveFormulaToFile()
	 * method.  This routine is responsible for notifying the user if an LTL Formula
	 * could not be created.
	 */
	public static String convertPropertyFormula(Property property){
		String formula = FormulaCreator.createFormula(property); 
		return formula;
	}

	/*saveFormulaToFile() takes the LTL Formula from ConvertPropertyToFormula() as
	 * input.  It writes the LTL Formula to the output file. This routine is responsible
	 * for notifying the user if the formula cannot be written to the output file.
	 */
	public void saveFormulaToFile(){

	}

	/** 
	 * @precondition Run str.trim() method beforehand */
	static Proposition createProposition(String propName, String propType, String propNumber) {	
		Proposition proposition = null;
		int number = 1;
		
		if(propNumber != null){
			number = Integer.parseInt( propNumber);
		}		

		switch(propType) {
		case "Atomic":
			proposition = new Atomic(propName);
			break;
		case "AtLeastOneC":
			proposition = new AtLeastOneC(propName, number);
			break;
		case "AtLeastOneE":
			proposition = new AtLeastOneE(propName, number);
			break;
		case "ParallelC":
			proposition = new ParallelC(propName, number);
			break;
		case "ParallelE":
			proposition = new ParallelE(propName, number);
			break;
		case "ConsecutiveC":
			proposition = new ConsecutiveC(propName, number);
			break;
		case "ConsecutiveE":
			proposition = new ConsecutiveE(propName, number);
			break;
		case "EventualC":
			proposition = new EventualC(propName, number);
			break;
		case "EventualE":
			proposition = new EventualE(propName, number);
			break;
		}
		return proposition;
	}

	static Pattern createPattern(String patternStr, Proposition propositionP, Proposition propositionQ) {
		Pattern pattern = null;

		switch(patternStr){
		case "Existence":
			pattern = new Existence(propositionP,propositionQ);
			break;
		case "Absence":
			pattern = new Absence(propositionP,propositionQ);
			break;
		case "Response":
			pattern = new Response(propositionP, propositionQ);
			break;
		case "Precedence":
			pattern = new Precedence(propositionP, propositionQ);
			break;
		case "StrictPrecedence":
			pattern = new StrictPrecedence(propositionP, propositionQ);
			break;
		}
		return pattern;
	}

	static Scope createScope(String scopeType, Proposition propositionL, Proposition propositionR) {
		Scope scope = null;
		switch(scopeType){
		case "Global":
			scope = new Global(propositionL, propositionR);
			break;
		case "AfterL":
			scope = new AfterL(propositionL, propositionR);
			break;
		case "BeforeR":
			scope = new BeforeR(propositionR);
			break;
		case "AfterLuntilR":
			scope = new AfterLuntilR(propositionL, propositionR);
			break;
		case "BetweenLandR":
			scope = new BetweenLandR(propositionL, propositionR);
			break;
		}
		return scope;
	}	
}