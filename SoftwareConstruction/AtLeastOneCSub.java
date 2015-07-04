/* Represents a composite proposition of type condition, that holds at a state 's' if at least
 * one proposition is true at state 's'.
 * AtLeastOneC is a subclass of the Composite superclass. 
 */
public class AtLeastOneCSub{
   
	//piV...Vpn
		public String generateCP(String name, int number){
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
