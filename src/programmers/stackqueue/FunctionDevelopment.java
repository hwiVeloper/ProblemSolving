package programmers.stackqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelopment {
	public static void main(String[] args) {
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}
	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};

		Queue<Integer> answerQueue = new LinkedList<Integer>();
		Queue<Integer> rQueue = new LinkedList<Integer>();

		for (int i = 0; i < progresses.length; i++) {
			rQueue.offer((int) (Math.ceil((100 - progresses[i]) * 1.0 / speeds[i])));
		}
		
		int day = 0;
		while (!rQueue.isEmpty()) {
			day += 1;
			int count = 0;
			
			while (rQueue.size() > 0 && rQueue.peek() <= day) {
				count += 1;
				rQueue.poll();
			}
			
			if (count > 0) {
				answerQueue.offer(count);
			}
		}

		answer = answerQueue.stream().mapToInt(Integer::intValue).toArray();

		return answer;
	}
}
