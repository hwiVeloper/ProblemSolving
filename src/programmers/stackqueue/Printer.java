package programmers.stackqueue;

import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 */
public class Printer {
	public int solution(int[] priorities, int location) {
		int answer = 0;
        int tmpLoc = location;

        Queue<Integer> pQueue = new ArrayBlockingQueue<Integer>(priorities.length);
        // 큐 생성
        for (int i = 0; i < priorities.length; i++) {
            pQueue.add(priorities[i]);
        }

        while(!pQueue.isEmpty()) {
            // 큐의 첫번째 값이 최대값인지 확인
            int firstVal = pQueue.peek();
            int max = Collections.max(pQueue);
            if (firstVal == max) {
                // 맞다면 그대로 인쇄
                pQueue.poll();
                answer++;
                if (tmpLoc == 0) break;
                else tmpLoc = tmpLoc == 0 ? pQueue.size() - 1 : tmpLoc - 1;
            } else {
                // 아니라면 뽑아서 맨뒤로 보내기
                pQueue.add(pQueue.poll());
                // location 변경
                if (tmpLoc == 0) tmpLoc = pQueue.size() - 1;
                else tmpLoc--;
            }


        }

        return answer;
	}
}
