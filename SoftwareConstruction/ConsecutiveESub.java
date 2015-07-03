
public class ConsecutiveESub {

	public  String generateCP (String name, int number){
		String one ="";
		String two = "";
		String formula =""; 

			for(int i =1; i<=2 ; i++){
				one = one +"("+ notProperties(name, 1, number);
				if ( i ==1){
					one = one + ")^(";
				}
				else if( i ==2){
					one = one + ")U(";
				}
			}

		for ( int i =1; i <=number; i++){
			if(i!= number){
				two= two + firstTrueAndNotProperties( name, i, number);
				two = two +"^X(";
			}
			else {
				two = two + firstTrueAndNotProperties( name, number, number);
				for(int j=1; j<= (number+1) ; j++){
					two = two + ")";
				}
			}
		}
		return formula= one + two;
	}


	private String firstTrueAndNotProperties(String property, int count, int number){
		String temp = "";

		for (int i=count; i<=number; i++){

			if(i==count){
				temp = property+i;
			}
			else if(i !=count){
				temp = temp +"^!"+property+i;
			}
		}
		return temp;
	}

	private static String notProperties(String property, int count, int number){
		String temp="";
		for(int i= count; i<=number; i++ ){
			if(i!= number){
				temp = temp+"!"+property+i+"^";
			}
			else if(i== number){
				temp = temp+"!"+property+i;
			}
		}
		temp.replace("^", "");
		return temp;
	}

}
