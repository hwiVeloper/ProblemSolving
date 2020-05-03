package programmers.stackqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */
public class StockPrice {
	public int[] solution(int[] prices) {
		int[] answer = {};
		List<Integer> answerList = new ArrayList<Integer>();
		Stack<Integer> pStack = new Stack<Integer>(); // 가격 스택
		List<Integer> reverseList = new ArrayList<Integer>();
		
		for (int p : prices) {
			reverseList.add(p);
		}
		
		Collections.reverse(reverseList);
		for (int r : reverseList) {
			pStack.push(r);
		}
		
		while (!pStack.isEmpty()) {
			int top = pStack.pop();
			int time = 0;
			for (int i = 0; i < pStack.size(); i++) {
				time++;
				if (top > pStack.get(pStack.size() - (i+1))) {
					break;
				}
			}
			answerList.add(time);
		}
		answer = answerList.stream().mapToInt(Integer::intValue).toArray();
		
        return answer;
	}
}
