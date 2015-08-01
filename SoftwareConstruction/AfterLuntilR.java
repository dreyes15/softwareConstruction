/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: Global Table
 * Due Date: July 24, 2015
 * Purpose:
 * This class is a type of scope that will describe the extent of program 
 * execution over which property holds. With the given information this class
 * should be able to generate itself as the "After L until R" scope. 
 * After L until R, will denote the execution between intervals defined by L and R,
 * and in the case where R doesn't occur, until the end of the execution. 
 */

public class AfterLuntilR extends Scope
{	
	public AfterLuntilR(Proposition propL, Proposition propR)
	{
		this.propositionL = propL;	//set variable L be equal to the parameter;
		this.propositionR = propR;	//set variable R be equal to the parameter;
	}
}