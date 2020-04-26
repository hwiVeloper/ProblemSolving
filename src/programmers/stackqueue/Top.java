package programmers.stackqueue;

import java.util.Stack;

/**
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/42588
 */
public class Top {
	public static int[] solution(int[] heights) {
		int[] answer = new int[heights.length];

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < heights.length; i++) {
            stack.add(heights[i]);
        }

        int pop;
        while (stack.size() > 0) {
            pop = stack.pop();
            for (int i = stack.size() - 1; i >= 0; i--) {
                if (stack.get(i) > pop) {
                    answer[stack.size()] = i + 1;
                    break;
                }
            }
        }

        return answer;
	}
}
