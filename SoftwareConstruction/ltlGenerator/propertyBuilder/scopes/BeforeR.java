package ltlGenerator.propertyBuilder.scopes;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Reyes
 * Project: LTL Generator
 * Sprint: Global Table
 * Due Date: July 24, 2015
 * Purpose:
 * Here we will need to declare a variable of type Proposition that will be used for
 * the following methods. For the purpose of this class we will be naming this variable L.
 */

import ltlGenerator.propertyBuilder.proposition.Proposition;

public class BeforeR extends Scope
{
	public BeforeR(PropositionL, Proposition propR)
	{
		this.propositionR = propR;		//set variable R be equal to the parameter;
	}
}