
public class EventualESub {
    
    /* EventualHSub */
    public String generateCP(String proposition, int number)
    {
        if (number < 1){
            return "";
        }
        else if (number == 1){
            return "(!"+proposition+number+" U "+proposition+number+")";
        }
        String firstString="";
        int endParenthesisCount = 0;
        for(int i =1; i<=2 ; i++){
            firstString = firstString+"("+ genAndNot(proposition, 1, number);
            if ( i ==1){
                firstString = firstString + ")^(";
                
            }
            else if( i ==2){
                firstString = firstString + ")U(";
                endParenthesisCount++;
            }
        }
        
        String p = proposition;
        //End Parenthesis. Counts only middle parenthesis.
        
        String str2toN = genAndNot(p, 2, number);	//Generates 2-N (^!p2^...^pn)
        String str1 = p + "1^" + str2toN + "^";		//Part1 (p1^!p2^...^!pn ^
        String str2 ="(("+ str2toN +") U (";		//Part2 ((!p2^...^!pn)U(p2...
        
        /* Generate the middle section in such a way that:
         * n: (p2 ^ !p3 ^...^!pn^(...^(pn-1 ^ !pn^(!pn U pn)
         * (eg)
         * 2: (p2 ^(!p2 U p2)
         * 3: (p2^!p3 ^(!p3 U p3)
         * 4: (p2^!p3^!p4 ^(p3 ^ !p4 ^(!pn U pn)
         */
        String str3  = "";
        for(int i=2; i<number; i++)
        {
            String firstTrue = p + i + "^";
            String nextAllFalse = firstTrue + genAndNot(p, i+1, number);
            str3 = str3 + nextAllFalse + "^(";
            endParenthesisCount++;
        }
        
        String midStr = str1 + str2 + str3;
        String endStr = "(!" + p + number + " U " + p + number + ")))))";
        String endParenthesis = genEndParenthesis(endParenthesisCount);
        
        return firstString + "(" + midStr + endStr + endParenthesis;
    }
    
    /* Generates a string that have the multiple propositions with
     * "not" and an "and" in between.
     */
    private String genAndNot(String p, int start, int end)
    {
        String formula = "";
        for(int i=start; i<= end; i++) {
            if(i == start ) {
                formula = "!" + p + i;
            } else {
                formula = formula + "^!" + p + i;
            }
        }
        return formula;
    }
    
    /* Generates the closing parenthesis at the end of the formula
     * with the given number. Returns a string of closing parenthesis.
     */
    private String genEndParenthesis(int number)
    {
        String pStr = "";
        for(int i=0; i<number; i++) {
            pStr = pStr + ")";
        }
        return pStr;
    }
}
