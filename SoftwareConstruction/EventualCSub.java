

public class EventualCSub{

    public static String generateCP(String property, int number){
        String finalProposition = "";

        if(number == 1){
            finalProposition = endPropostion(property,number);
            return finalProposition;
        }
        int i= 1;
        
        while(i <= number){
            if(i == 1) {
                finalProposition = baseProposition(property,i);
            }

            else if (i< number){
                finalProposition = finalProposition.replace(".", midProposition(property, i));
            }
            else{
                finalProposition = finalProposition.replace(".", endPropostion(property, i));
            }
            i++;
        }
        return finalProposition;
    }
    private static String baseProposition(String property, int number){
        return "( " + property+number+ " ^X .)";
    }

    private static String midProposition(String property, int number){
        return "(!"+property+number+"U("+property+number+"^X.)";
    }

    private static String endPropostion(String property, int number){
        return "(!" +property+number+" U "+property+number+")";
    }
}