package tema13StivaSiCoadaLeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {

	public boolean isValid(String s) {
		Deque<Character> stack = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '[' || ch == '(' || ch == '{') {
				stack.push(ch);
			} else if (ch == ')' && (stack.isEmpty() || stack.pop() != '(')) {
				return false;
			} else if (ch == ']' && (stack.isEmpty() || stack.pop() != '[')) {
				return false;
			} else if (ch == '}' && (stack.isEmpty() || stack.pop() != '{')) {
				return false;
			}
		}
		return stack.isEmpty();
	}

}
