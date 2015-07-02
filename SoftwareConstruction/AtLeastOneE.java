/* Represents a composite proposition of type event, that holds if all the propositions
 * are false at some state. Then, at least one of these propositions becomes true at
 * some future state. 
 */
import java.util.*;
public class AtLeastOneE extends Composite {

	/* AtLeastOneE(String name, int number) is a constructor method for a composite
	 * proposition of type AtLeastOneE. The name being the name of the proposition
	 * and the number is the number of propositions that make up this composite
	 * proposition.  
	 */
	public AtLeastOneE(String name, int number){
		super(name, number);
		typeOfProposition = "AtLeastOneE";
	}


	//(-p1^....^pn)^((-p1^...^-pn)U(p1V..Vpn))
	public String AtLeastOneESub(String name, int number){
		String formula = name;
		String portion2 = null;
		String portion3 = null;
		for(int i = 1; i <= number; i++){
			x = "(¬" + name + i;
			while(i != number){
				i++;
				formula += " ^¬ "+name +i;
			}
			formula += ")^";
			i = 1;

			portion2 = "((¬" + name + i;
			while(i != number){
				i++;
				portion2 += " ^¬ "+name +i;
			}
			portion2 += ")U";
			i = 1;

			portion3 = "(" + name + i;
			while(i != number){
				i++;
				portion3 += " V "+ name +i;
			}
			portion3 += "))";


		}
		return formula + portion2 + portion3;
		//System.out.println(x + p2 + p3);
	}
}
