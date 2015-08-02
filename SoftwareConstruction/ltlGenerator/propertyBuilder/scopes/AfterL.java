package ltlGenerator.propertyBuilder.scopes;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: Global Table
 * Due Date: July 24, 2015
 * Purpose:
 * This class is a type of scope that will describe the extent of program execution
 * over which property holds. With the given information this class should be able
 * to generate itself as the "After L" scope.  After L will denote the execution
 * after the first time L holds.
 */

import ltlGenerator.propertyBuilder.proposition.Proposition;

public class AfterL extends Scope
{
	public AfterL(Proposition propL, Proposition propR)
	{
		this.propositionL = propL;	// Pass the L proposition
	}
}