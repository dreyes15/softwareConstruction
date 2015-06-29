/*
 * A composite proposition is a proposition made up of more than one proposition.
 * 
 * A composite proposition will have a variable name and the number of propositions
 * this proposition is made up of. This clas is abstract and cannot be instantiated.
 * The Composite class is a superclass for the composite type of classes that are
 * concrete. The composite types include the following: AtLeastOneC, AtLeastOneE,
 * ParallelC, ParallelE, ConsecutiveC, ConsecutiveE, EventualE, and EventualC.  
 */

public abstract class Composite extends Proposition {
	//number of propositions that make up this composite proposition	
}