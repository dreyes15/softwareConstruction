package formulaBuilder;
import formulaBuilder.propertyBuilder.Property;
import propertyBuilder.patterns.Pattern;
import propertyBuilder.proposition.Proposition;
import propertyBuilder.scopes.Scope;

public class SpecialOperatorUpdater {
	
	public String specialOperationsReplacement(Property P, String baseFormula){
		
		Property property = P;
		Scope scope = property.getScope();
		Pattern pattern = property.getPattern();
		
		Proposition propP = pattern.getPropositionP();
		String propPType = propP.getType();
		Proposition propQ = pattern.getPropositionQ();
		String propQType = propQ.getType();
		Proposition propL = scope.getPropositionL();
		String propLType = propL.getType();
		Proposition propR = scope.getPropositionR();
		String propRType = propR.getType();
		
		String updatedBaseFormula = baseFormula;
		int searchPosition = 0;
		
		while (searchPosition < updatedBaseFormula.length()-1){
			if (updatedBaseFormula.charAt(searchPosition) == '&'){
				char prevOperand = updatedBaseFormula.charAt(searchPosition-1);
				char endLetter = '.';
				if (updatedBaseFormula.charAt(searchPosition+1) == 'r'){
					switch (prevOperand){
					case 'P':
						endLetter = getLastLetter(propP);
						if (endLetter == 'E'){
							updatedBaseFormula = updatedBaseFormula.substring(0,searchPosition+1) + "e" + updatedBaseFormula.substring(searchPosition+2, updatedBaseFormula.length());
						}
						break;
					case 'Q':
						endLetter = getLastLetter(propQ);
						if (endLetter == 'E'){
							updatedBaseFormula = updatedBaseFormula.substring(0,searchPosition+1) + "e" + updatedBaseFormula.substring(searchPosition+2, updatedBaseFormula.length());						
						}
						break;
					case 'L':
						endLetter = getLastLetter(propL);
						if (endLetter == 'E'){
							updatedBaseFormula = updatedBaseFormula.substring(0,searchPosition+1) + "e" + updatedBaseFormula.substring(searchPosition+2, updatedBaseFormula.length());
						}
						break;
					case 'R':
						endLetter = getLastLetter(propR);
						if (endLetter == 'E'){
							updatedBaseFormula = updatedBaseFormula.substring(0,searchPosition+1) + "e" + updatedBaseFormula.substring(searchPosition+2, updatedBaseFormula.length());
						}
						break;
					default:
						System.out.println("Error: Not a valid proposition before the special operator.)");
					}
				}
				else if (updatedBaseFormula.charAt(searchPosition+1) == '-'){
					switch (prevOperand){
					case 'P':
						if (propPType.equals("ConsecutiveC")||propPType.equals("EventualC")){
							updatedBaseFormula = updatedBaseFormula.substring(0,searchPosition+1) + "c" + updatedBaseFormula.substring(searchPosition+2, updatedBaseFormula.length());
						}
						else if (propPType.equals("AtLeastOneE")||propPType.equals("ParallelE")){
							updatedBaseFormula = updatedBaseFormula.substring(0,searchPosition+1) + "x" + updatedBaseFormula.substring(searchPosition+2, updatedBaseFormula.length());
						}
						else if (propPType.equals("ConsecutiveE")||propPType.equals("EventualE")){
							updatedBaseFormula = updatedBaseFormula.substring(0,searchPosition+1) + "e" + updatedBaseFormula.substring(searchPosition+2, updatedBaseFormula.length());
						}
						break;
					case 'Q':
						if (propQType.equals("ConsecutiveC")||propQType.equals("EventualC")){
							updatedBaseFormula = updatedBaseFormula.substring(0,searchPosition+1) + "c" + updatedBaseFormula.substring(searchPosition+2, updatedBaseFormula.length());
						}
						else if (propQType.equals("AtLeastOneE")||propQType.equals("ParallelE")){
							updatedBaseFormula = updatedBaseFormula.substring(0,searchPosition+1) + "x" + updatedBaseFormula.substring(searchPosition+2, updatedBaseFormula.length());
						}
						else if (propQType.equals("ConsecutiveE")||propQType.equals("EventualE")){
							updatedBaseFormula = updatedBaseFormula.substring(0,searchPosition+2) + "e" + updatedBaseFormula.substring(searchPosition+3, updatedBaseFormula.length());
						}
						break;
					case 'L':
						if (propLType.equals("ConsecutiveC")||propLType.equals("EventualC")){
							updatedBaseFormula = updatedBaseFormula.substring(0,searchPosition+2) + "c" + updatedBaseFormula.substring(searchPosition+3, updatedBaseFormula.length());
						}
						else if (propLType.equals("AtLeastOneE")||propLType.equals("Parallel")){
							updatedBaseFormula = updatedBaseFormula.substring(0,searchPosition+2) + "x" + updatedBaseFormula.substring(searchPosition+3, updatedBaseFormula.length());
						}
						else if (propLType.equals("ConsecutiveE")||propLType.equals("EventualE")){
							updatedBaseFormula = updatedBaseFormula.substring(0,searchPosition+2) + "e" + updatedBaseFormula.substring(searchPosition+3, updatedBaseFormula.length());
						}
						break;
					case 'R':
						if (propRType.equals("ConsecutiveC")||propRType.equals("EventualC")){
							updatedBaseFormula = updatedBaseFormula.substring(0,searchPosition+2) + "c" + updatedBaseFormula.substring(searchPosition+3, updatedBaseFormula.length());
						}
						else if (propRType.equals("AtLeastOneE")||propRType.equals("Parallel")){
							updatedBaseFormula = updatedBaseFormula.substring(0,searchPosition+2) + "x" + updatedBaseFormula.substring(searchPosition+3, updatedBaseFormula.length());
						}
						else if (propRType.equals("ConsecutiveE")||propRType.equals("EventualE")){
							updatedBaseFormula = updatedBaseFormula.substring(0,searchPosition+2) + "e" + updatedBaseFormula.substring(searchPosition+3, updatedBaseFormula.length());
						}
						break;
					default:
						System.out.println("Error: Not a valid proposition before the special operator.)");
					}
				}
				else{
					//Not an AndR or AndNotL Operation
				}
			}
			searchPosition++;
		}
		return updatedBaseFormula;
	}
	
	private char getLastLetter(Proposition prop){

		Proposition proposition = prop;
		String propType = proposition.getType();
		char lastLetter = propType.charAt(propType.length()-1);

		return lastLetter;
	}

}
