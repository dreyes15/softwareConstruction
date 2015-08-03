package ltlGenerator.propertyBuilder.scopes;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Reyes 
 * Project: LTL Generator
 * Due Date: August 3, 2015
 */

import ltlGenerator.propertyBuilder.proposition.Proposition;

public class BetweenLandR extends Scope {
	/*This is a constructor method of type BetweenLandR. This class will extend
	 * the Scope class, therefore the variables will be sent to the super class
	 * to sort the information.
	 */
	public BetweenLandR(Proposition propL, Proposition propR)
	{		
		this.propositionL = propL;	//set variable L be equal to the parameter;
		this.propositionR = propR;	//set variable R be equal to the parameter;
	}
}