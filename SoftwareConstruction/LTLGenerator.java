
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

	public static void main(String [] args){

		LTLGenerator();

	}
	/*The LTLGenerator() constructor will take a text file as its parameter. It will have
	 * a string called FinalFormula that is assigned the result of passing the text file
	 * as a parameter of the formatData() method.
	 */
	public static void LTLGenerator(){ 
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("LTLInputFile.txt"));
			formatData(bufferedReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
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
				formula.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		int i = 0;
//		if(i < formula.size()) {
//			System.out.println(formula);
//			Proposition propP = new (formula.get(i));
//			Proposition propQ = new (formula.get(i + 1));
//			Proposition propL = new (formula.get(i + 2));
//			Proposition propR = new (formula.get(i + 3));
//			
//			i++;
//		}
		for(int i = 0; i < formula.size(); i++){
			if(formula.get(i).equals("Atomic")){
				Proposition propP = new Atomic(formula.get(i));
				System.out.println("propP created");
			}
			else if(formula.get(i).equals("ParalleC")){
				String breakDown = formula.get(i);
				
				Proposition propQ = new ParallelC(formula.get(i));
				System.out.println("propQ created");
			}
			else if(formula.get(i).equals("AtLeastOneC")){
				Proposition propL = new AtLeastOneC(formula.get(i),);
				System.out.println("propL created");
			}
			else if(formula.get(i).equals("ConsecutiveE")){
				Proposition propR = new ConsecutiveC(formula.get(i),);
				System.out.println("propR created");
			}
		}

		
		



	}   


	/*convertDataToProperty() takes the array from FormatData() as input. It passes this
	 * array to the Property class and receives a Property object in return. It then passes
	 * the Property object to the ConvertPropertyToFormula() method.  This routine is
	 * responsible for notifying the user if a Property object could not be created.
	 */
	public void convertDataToProperty(List<String> formula){


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
	
//	public void breakDown(String breakDown){
//		String broken[] = breakDown.split(" ");
//		System.out.println(broken[broken.length]);
//			
//		}
	}

