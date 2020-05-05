package programmers.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/42629
 */
public class RamenFactory {
	public int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;
		PriorityQueue<Integer> qSupplies = new PriorityQueue<Integer>(Collections.reverseOrder());
		int day = 0;
		int idx = 0;
		
		while (day < k) {
			System.out.println("===== " + day + " =====");
			if (idx < dates.length && dates[idx] == day) {
				qSupplies.offer(supplies[idx]);
				idx++;
			}
			
			if (stock == 0) {
				stock += qSupplies.poll();
				System.out.println(day + "번째날 공급 후 재고 : " + stock);
				answer++;
			}
			
			stock--;
			day++;
		}

		return answer;
	}
}
