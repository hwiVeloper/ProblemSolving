package programmers.stackqueue;

import java.util.Stack;

public class SteelStick {
	public int solution(String arrangement) {
		int answer = 0;
		String tmpArrangement = arrangement.replace("()", "L");

		Stack<Character> tmpStack = new Stack<Character>();

		for (int i = 0; i < tmpArrangement.length(); i++) {
			tmpStack.add(tmpArrangement.charAt(i));
		}

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < tmpStack.size(); i++) {
			Character charVal = tmpStack.get(i);
			switch (charVal) {
			case '(':
				stack.add(charVal);
				break;
			case ')':
				answer += 1;
				// stack.remove(stack.size() - 1);
				stack.pop();
				break;
			case 'L':
				answer += stack.size();
				break;
			}
		}
		return answer;
	}
}
