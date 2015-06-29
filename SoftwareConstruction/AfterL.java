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
	
	public AfterL(parameter){
		/*This is a constructor method of type AfterL. This class will extend
		 * the Scope class, therefore the variables will be sent to the super class
		 * to sote the information.
		 */
	}
	
	//Then a getter and setter method that will return the variable.
	public Proposition getL(){
		/*This is a getter method of type Proposition. This method will return the variable
		 * of type Proposition that was declared above. 
		 */
	}
	
	public void setL(parameter){
		/*This is a setter method of type void. This method will set the the parameter and the
		 * variable be equal to each other.
		 */
	}

}
