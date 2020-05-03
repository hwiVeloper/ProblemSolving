package programmers.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 */
public class FunctionDevelopment {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		
		Queue<Integer> answerQueue = new LinkedList<Integer>();
		Queue<Integer> rQueue = new LinkedList<Integer>();

		// 남은 기간을 계산하여 queue에 쌓는다.
		for (int i = 0; i < progresses.length; i++) {
			rQueue.offer((int) (Math.ceil((100 - progresses[i]) * 1.0 / speeds[i])));
		}
		
		int day = 0; // 하루씩 추가되는 day
		while (!rQueue.isEmpty()) {
			day += 1;
			int count = 0; // 이번 day에 배포하는 건수
			
			// day 보다 작거나 같은 remain queue의 값을 count 후 poll()
			while (rQueue.size() > 0 && rQueue.peek() <= day) {
				count += 1;
				rQueue.poll();
			}
			
			// count가 자연일 경우 answerQueue에 쌓는다.
			if (count > 0) {
				answerQueue.offer(count);
			}
		}

		// convert
		answer = answerQueue.stream().mapToInt(Integer::intValue).toArray();

		return answer;
	}
}
