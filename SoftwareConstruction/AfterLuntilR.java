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
	
	initializing variable L of type Proposition;
	initializing variable R of type Proposition;

	
	public AfterLuntilR(parameter of type Proposition, parameter of type Proposition){
		/*This is a constructor method of type AfterLuntilR. This class will extend
		 * the Scope class, therefore the variables will be sent to the super class
		 * to sote the information.
		 */
		
		set variable L be equal to the parameter;
		set variable R be equal to the parameter;


	}
	


}
