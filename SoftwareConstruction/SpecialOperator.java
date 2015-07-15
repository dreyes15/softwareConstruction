import java.util.Stack;

/* 
 * The purpose this class is to perform the special operations to compensate for the areas
 * in which direct substitution does not come out properly.  It will have one method called
 * performSpecialOperations().
 */
public class SpecialOperator {

	/*
     * performSpecialOperations() will receive a base formula from SubstitutionTable as a
     * parameter.  It will call a method from MPS to parse this formula into a string array.
     * It will then search that array for special operators and call the method of the 
     * appropriate class for each such operator.  It will build a final formuala from this
     * process and return it to LTLSubstitutor.
     */
	protected static String replaceANDr(String input) {
		if (input.length() < 1)
			return input;
		String output = input;
		output = addParenthesis(output);
		int position = output.length() - 1;
		while (position > 0) {
			if (output.charAt(position) == 'r') {
				position--;
				if (output.charAt(position) == '&') {
					String graft = getGraft(output, position + 1);
					output = deleteStringFromString(output, position, position
							+ 1 + graft.length()); // delete the &r(graft)
					position--;
					if (output.charAt(position) == ' ')
						position--;
					if (output.substring(0, position).length() > 3
							&& (output.charAt(position - 5) == '|'
								|| output.charAt(position - 5) == '&'
								|| output.charAt(position - 4) == '|'
								|| output.charAt(position - 4) == '&'))
							output = addStringToString(output, "&" + graft,
									position + 1);
					 else {

						int index = getBeginContextPosition(output, position);
						while (index < position) {
							index++;
							if (output.substring(index,index+1).matches(
									"[a,b,c,d,e,h,i,j,k,m,n,o]")) {
								output = addStringToString(output, "&" + graft,
										index + 2);
								position += graft.length()+1; // new string
															// size,
															// position
															// normalized
								index += graft.length();
							}
						}
					}

				}
			}
			position--;
		}
		position = 0;
		while (position < output.length() - 1) {
			if (output.substring(position, position + 1).matches(
					"[a,b,c,d,e,h,i,j,k,m,n,o]")) {
				output = deleteStringFromString(output, position+1, position+1);
				output = deleteStringFromString(output, position-1, position-1);
				position++;
			}
			position++;
		}
		return output;
	}

	protected static String replaceANDl(String input) { // OK
		if (input.length() < 1)
			return input;
		String output = input;
		output = addParenthesis(output);
		int position = output.length() - 1;
		while (position > 0) {
			if (output.charAt(position) == 'l') {
				position--;
				if (output.charAt(position) == '&') {
					String graft = getGraft(output, position + 1);
					output = deleteStringFromString(output, position, position
							+ 1 + graft.length());
					position--;
					if (output.charAt(position) == ' ')
						position--;
					while (!output.substring(position, position + 1).matches(
							"[a,b,c,d,e,h,i,j,k,m,n,o]")) {
						position--;
					}
					if (output.charAt(position - 4) == '|'
							|| output.charAt(position - 4) == '&'
							|| output.charAt(position - 3) == '|'
							|| output.charAt(position - 3) == '&')
						output = addStringToString(output, "&" + graft,
								position + 3);
					else
						output = addStringToString(output, "&" + graft,
								position + 2);
				}
			}
			position--;
		}
		position = 0;
		while (position < output.length() - 1) {
			if (output.substring(position, position + 1).matches(
					"[a,b,c,d,e,h,i,j,k,m,n,o]")) {
				output = deleteStringFromString(output, position+1, position+1);
				output = deleteStringFromString(output, position-1, position-1);
				position++;
			}
			position++;
		}
		return output;
	}

	private static String getGraft(String input, int rORlPosition) { // OK
		String output = input;
		int endGraft = getEndContextPosition(output, rORlPosition + 1);
		String graft = output.substring(rORlPosition + 1, endGraft + 1);
		return graft;
	}

	private static String addParenthesis(String input) { // OK
		String output = input;
		int position = output.length() - 1;
		while (position > 0) {
			if (output.substring(position-1, position).matches("[a,b,c,d,e,h,i,j,k,m,n,o]")) {
				output = addStringToString(output, ")", position);
				output = addStringToString(output, "(", position - 1);
				position++;
			}
			position--;
		}
		return output;
	}

	private static String addStringToString(String input, String toAdd,
			int position) { // OK
		String output = input.substring(0, position) + toAdd
				+ input.substring(position, input.length());
		return output;
	}

	private static String deleteStringFromString(String input,
			int startPosition, int endPosition) { // OK
		String output = input.substring(0, startPosition)
				+ input.substring(endPosition + 1, input.length());
		return output;
	}

	private static int getBeginContextPosition(String str, int endContext) { // OK
		if (str.charAt(endContext) == '(')
			return endContext;
		else {
			Stack<Character> stack = new Stack<Character>();
			char last = str.charAt(endContext);
			for (int i = endContext; i > -1; i--) {
				char c = str.charAt(i);
				if (c == ')')
					stack.push(c);
				else if (c == '(') {
					if (stack.isEmpty())
						return i + 1;
					else {
						stack.pop();
						if (stack.isEmpty() && last == ')')
							return i;
					}
				}
			}
			return 0;
		}
	}

	private static int getEndContextPosition(String str, int beginContext) { // OK
		if (str.charAt(beginContext) == ')')
			return beginContext;
		else {
			Stack<Character> stack = new Stack<Character>();
			char first;
			if (str.charAt(beginContext) == ' ')
				first = str.charAt(beginContext + 1);
			else
				first = str.charAt(beginContext);
			for (int i = beginContext; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == '(')
					stack.push(c);
				else if (c == ')') {
					if (stack.isEmpty())
						return i - 1;
					else {
						stack.pop();
						if (stack.isEmpty() && first == '(')
							return i;
					}
				}
			}
			return str.length() - 1;
		}
	}

}
