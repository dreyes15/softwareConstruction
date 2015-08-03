package ltlGenerator.propertyBuilder.proposition;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 * Purpose:
 * Represents a proposition variable in propositional logic, where propositions
 * are declarative sentences. This class is abstract and cannot be instantiated. A 
 * Proposition will have a name, and be either an atomic or composite proposition. If 
 * the Proposition is composite, it will also have a composite proposition (CP) class. 
 * Proposition is an abstract superclass of the Atomic and Composite concrete subclasses. 
 */

public abstract class Proposition
{
	String nameOfProposition = "";	//Proposition variable name
	String typeOfProposition = "";	//Proposition variable type
	int numberOfPropositions = 0;	//applicable to composite propositions that contain more than 1 proposition
	
	public Proposition(String name)
	{
		this.nameOfProposition = name;
		this.numberOfPropositions = 1;
	}
	
	//Method getName() returns the "nameOfProposition" string of the Proposition object.
	public String getName()
	{
		return this.nameOfProposition;
	}
	 
	//Method getType() returns the "typeOfProposition" string of the Proposition object.
	public String getType()
	{
		return this.typeOfProposition;
	}
	
	public int getNumber()
	{
		return this.numberOfPropositions;
	}
	
	public boolean isEventType() {
		if (getLastLetter() == 'E') {
			return true;
		}
		return false;
	}
	
    private char getLastLetter(){
        return this.typeOfProposition.charAt(this.typeOfProposition.length()-1);
    }
}