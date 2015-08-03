package ltlGenerator.propertyBuilder.proposition;
/* Course: Software Construction / CS5374
 * Team: Victoria Bravo, Florencia Larsen, Jorge Martinez, Troy McGarity, 
 * 		 Lucia Rodriguez, and David Torres 
 * Project: LTL Generator
 * Sprint: CP Generation
 * Due Date: July 3, 2015
 * Purpose: 
 * A composite proposition is a proposition made up of more than one proposition.
 * A composite proposition will have a variable name and the number of propositions
 * this proposition is made up of. This class is abstract and cannot be instantiated.
 * The Composite class is a superclass for the composite type of classes that are
 * concrete. The composite types include the following: AtLeastOneC, AtLeastOneE,
 * ParallelC, ParallelE, ConsecutiveC, ConsecutiveE, EventualE, and EventualC.
 */

public abstract class Composite extends Proposition
{    
    public Composite(String name, int number)
    {
        super(name);
        this.numberOfPropositions = number;
    }
}