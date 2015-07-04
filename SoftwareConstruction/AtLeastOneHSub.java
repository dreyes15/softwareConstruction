/* Represents a composite proposition of type event, that holds if all the propositions
 * are false at some state. Then, at least one of these propositions becomes true at
 * some future state. 
 */
import java.util.*;
public class AtLeastOneESub{
	//piV...Vpn
			public String AtLeastOneHSub(String name, int number){
				String formula = name;
				
				for(int i = 1; i <= number; i++ ){
					formula = name + i;
					while(i != number){
						i++;
						formula += " V "+name +i;
					}
				}
				
				return formula;
			}
}