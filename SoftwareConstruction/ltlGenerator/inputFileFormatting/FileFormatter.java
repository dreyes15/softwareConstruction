package ltlGenerator.inputFileFormatting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity,
 * 		 Lucia Rodriguez, and David Reyes
 * Project: LTL Generator
 * Sprint: LTL Generator
 * Due Date: July 3, 2015
 */

public class FileFormatter {
	
	public static BufferedReader readFile() {
		
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("file.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("The file does not exist");
		}
		return bufferedReader;
	}
	
	/*formatData() takes the text file as an input. It parses this text file by line
	 * into a string array.  It passes this array to the ConvertDataToProperty() method.
	 * This routine is responsible for notifying the user if the text file does
	 * not exist.
	 */
	public static List<String> formatData(){

		BufferedReader bufferedReader = readFile();
		List<String> propertyData = new ArrayList<String>();
		String line;
		try {
			while((line = bufferedReader.readLine()) != null){
				StringTokenizer tokenizer = new StringTokenizer (line, " ");
				while(tokenizer.hasMoreElements()){
					tokenizer.nextElement();
					String pattern = tokenizer.nextElement().toString();
					pattern.trim();
					propertyData.add(pattern);
					if(tokenizer.hasMoreElements()){
						String number = tokenizer.nextElement().toString();
						propertyData.add(number);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propertyData;
	} 
}