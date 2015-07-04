/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 * Purpose: Represents a proposition variable in propositional logic, where propositions
 * are declarative sentences. This class is abstract and cannot be instantiated. A 
 * Proposition will have a name, and be either an atomic or composite proposition. If 
 * the Proposition is composite, it will also have a composite proposition (CP) class. 
 * Proposition is an abstract superclass of the Atomic and Composite concrete subclasses. 
 */

public abstract class Proposition {
	//Proposition variable name
	String nameOfProposition;
	//Proposition variable type
	String typeOfProposition;
	
	/* Proposition(String name) is a constructor method that creates an instance of a 
	 * Proposition. Requires the proposition variable name as input.
	 */
	public Proposition(String name){
		this.nameOfProposition = name;
		this.typeOfProposition = this.getClass().getName();
	}
	
	//Method getName() returns the "nameOfProposition" string of the Proposition object.
	public String getName(){
		return nameOfProposition;
	}
	 
	//Method getType() returns the "typeOfProposition" string of the Proposition object.
	public String getType(){
		return typeOfProposition;
	}
}