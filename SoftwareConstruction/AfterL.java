/*
 * This class is a type of scope that will describe the extent of 
 * program execution over which property holds. 
 * 
 * With the given information this class should be able to generate itself
 * as the "After L" scope. 
 * 
 * After L will denote the execution after the first time L holds.
 * 
 */
public class AfterL extends Scope{
	
	/*Here we will need to declare a variable of type Proposition that will be used for
	 * the following methods. For the purpose of this class we will be naming this variable L.
	 */
	private Proposition propositionL; 		//initializing variable L of type Proposition;
	
	/*This is a constructor method of type AfterL. This class will extend
	 * the Scope class, therefore the variables will be sent to the super class
	 * to sote the information.
	 */
	public AfterL(Proposition propL)
	{
		this.propositionL = propL;	// Pass the L proposition
	}
	
	public Proposition getPropositionL()
	{
		return this.propositionL;
	}
}