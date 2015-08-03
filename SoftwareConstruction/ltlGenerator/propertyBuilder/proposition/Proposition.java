package ltlGenerator.propertyBuilder.proposition;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Reyes 
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

public abstract class Proposition {
	String nameOfProposition = "";	// Proposition variable name
	String typeOfProposition = "";	// Proposition type
	int numberOfPropositions = 0;	// applicable to composite propositions

	public Proposition(String name) {
		this.nameOfProposition = name;
		this.numberOfPropositions = 1;
	}

	public String getName() {
		return this.nameOfProposition;
	}

	public String getType() {
		return this.typeOfProposition;
	}

	public int getNumber() {
		return this.numberOfPropositions;
	}

	public boolean isEventType() {
		if (getLastLetter() == 'E') {
			return true;
		}
		return false;
	}

	private char getLastLetter() {
		int lastLetterIndex = this.typeOfProposition.length() - 1;
		return this.typeOfProposition.charAt(lastLetterIndex);
	}
}