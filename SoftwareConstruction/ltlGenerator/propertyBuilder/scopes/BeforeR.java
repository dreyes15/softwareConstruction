package ltlGenerator.propertyBuilder.scopes;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Reyes
 * Project: LTL Generator
 * Due Date: August 3, 2015
 */

import ltlGenerator.propertyBuilder.proposition.Proposition;

public class BeforeR extends Scope
{
	public BeforeR(Proposition propL, Proposition propR)
	{
		this.propositionR = propR;		//set variable R be equal to the parameter;
	}
}