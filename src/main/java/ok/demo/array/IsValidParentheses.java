package ok.demo.array;

import java.util.Stack;

public class IsValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("()[]{}"));
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		if (s == null || s.isEmpty())
			return true;

		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (c.equals('{') || c.equals('[') || c.equals('(')) {
				stack.add(c);
			} else {
				if (c.equals('}')) {
					if (stack.isEmpty() ||  !stack.pop().equals('{')) {
						return false;
					}
				}
				if (c.equals(']')) {

					if (stack.isEmpty() || !stack.pop().equals('[')) {
						return false;
					}
				}
				if (c.equals(')')) {
					if (stack.isEmpty() || !stack.pop().equals('(')) {
						return false;
					}
				}

			}

		}

		return stack.isEmpty()?true:false;
	}
}
