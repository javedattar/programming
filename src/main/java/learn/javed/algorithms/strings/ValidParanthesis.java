/**
* author: Javed Attar
*/
package learn.javed.algorithms.strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParanthesis {

	public static void main(String[] args) {
		System.out.println(isValid("(]"));
		System.out.println(isValid("]"));
		System.out.println(isValid("[]{}()"));
		System.out.println(isValid("}[[]]{}()"));
		System.out.println(isValid("(){}}{"));

	}
	public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int index = 1;
        stack.push(s.charAt(0));
        while(index < s.length()) {
            char bracket = s.charAt(index);
            if(bracket == '[' || bracket == '{' || bracket == '(') {
                stack.push(bracket);
                // continue;
            }
            else {
            	if(stack.isEmpty()) {
            		return false;
            	}
                char openingBracket = stack.peek();
                if((openingBracket == '[' && bracket == ']') || (openingBracket == '{' && bracket == '}' )|| (openingBracket == '(' && bracket == ')')) {
                    stack.pop();
                    // continue;
                }
            }
            index++;
            
            
        }
        return stack.isEmpty();
    }

}
