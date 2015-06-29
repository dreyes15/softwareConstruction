/*
 * This class is a type of scope that will describe the extent of 
 * program execution over which property holds. 
 * 
 * With the given information this class should be able to generate itself
 * as the "Before R" scope. 
 * 
 * Before R will denote the execution before the first time the condition R holds.
 */
public class BeforeR extends Scope{
	
	/*Here we will need to declare a variable of type Proposition that will be used for
	 * the following methods. For the purpose of this class we will be naming this variable R.
	 */
	
	initializing variable R of type Proposition;

	public BeforeR(parameter){
		/*This is a constructor method of type BeforeR. This class will extend
		 * the Scope class, therefore the variables will be sent to the super class
		 * to sote the information.
		 */
		
		set variable R be equal to the parameter;

	}
	

}
