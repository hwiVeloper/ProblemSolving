package programmers.heap;

import java.util.PriorityQueue;

/**
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */
public class MoreSpicy {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> sQueue = new PriorityQueue<Integer>();
		
        for (int s : scoville) {
			sQueue.offer(s);
		}
		
		while (sQueue.peek() <= K) {
            if (sQueue.size() < 2) return -1; // 될 수 없는 경우
            
			answer++;
            
			int resultScoville = sQueue.poll() + (sQueue.poll() * 2);
			sQueue.offer(resultScoville);
		}
		
		return answer;
	}
}
