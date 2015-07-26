/*
 * This class is a type of scope that will describe the extent of 
 * program execution over which property holds.
 * 
 * With the given information this class should be able to generate itself
 * as the "After L until R" scope. 
 * 
 * After L until R, will denotate the execution between intervals defined by L and R,
 * and in the case where R doesn't occur, until the end of the execution. 
 * 
 */
public class AfterLuntilR extends Scope{
	
	/*Here we will need to declare two variables of type Proposition that will be used for
	 * the following methods. For the purpose of this class we will be naming these variables
	 * L and R.
	 */
	private Proposition propositionL;	//initializing variable L of type Proposition;
	private Proposition propositionR;	//initializing variable R of type Proposition;

	/*This is a constructor method of type AfterLuntilR. This class will extend
	 * the Scope class, therefore the variables will be sent to the super class
	 * to sote the information.
	 */	
	public AfterLuntilR(Proposition propL, Proposition propR)
	{
		this.propositionL = propL;	//set variable L be equal to the parameter;
		this.propositionR = propR;	//set variable R be equal to the parameter;
	}
	
	public Proposition getPropositionL()
	{
		return this.propositionL;
	}
	
	public Proposition getPropositionR()
	{
		return this.propositionR;
	}
}