/* A composite proposition is a proposition made up of more than one proposition.
 * A composite proposition will have a variable name and the number of propositions
 * this proposition is made up of. This class is abstract and cannot be instantiated.
 * The Composite class is a superclass for the composite type of classes that are
 * concrete. The composite types include the following: AtLeastOneC, AtLeastOneE,
 * ParallelC, ParallelE, ConsecutiveC, ConsecutiveE, EventualE, and EventualC.
 */

public abstract class Composite extends Proposition {
    //number of propositions that make up this composite proposition
    int numberOfPropositions;
    
    /* Composite(String name, String type, int number) is a constructor method that creates
     * an instance of a Composite Proposition. Requires the proposition variable name,
     * type, and number as input.
     */
    public Composite(String name, int number){
        super(name);
        this.numberOfPropositions = number;
    }
    
    /*Method getNumberOfPropositions() returns the "numberOfPropositions" value of the
     * Composite Proposition object.
     */
    public int getNumber(){
        return numberOfPropositions;
    }
}