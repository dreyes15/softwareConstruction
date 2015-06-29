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
	
	public AfterLuntilR(parameter, parameter){
		/*This is a constructor method of type AfterLuntilR. This class will extend
		 * the Scope class, therefore the variables will be sent to the super class
		 * to sote the information.
		 */
	}
	
	
	//for L
	public Proposition getL(){
		/*This is a getter method of type Proposition. This method will return the variable
		 * of type Proposition that was declared above. 
		 */
	}
	
	public void setL(){
		/*This is a setter method of type void. This method will set the the parameter and the
		 * variable be equal to each other.
		 */	}
	
	//for R
	public Proposition getR(){
		/*This is a getter method of type Proposition. This method will return the variable
		 * of type Proposition that was declared above. 
		 */
	}
	
	public void setR(){
		/*This is a setter method of type void. This method will set the the parameter and the
		 * variable be equal to each other.
		 */	}

}
