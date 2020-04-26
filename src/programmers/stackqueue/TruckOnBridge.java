package programmers.stackqueue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class TruckOnBridge {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;

		Queue<Integer> completedTruck = new ArrayBlockingQueue<Integer>(truck_weights.length); // 건너간 트럭
		Queue<Integer> bridge = new ArrayBlockingQueue<Integer>(bridge_length); // 다리
		Queue<Integer> readyTruck = new ArrayBlockingQueue<Integer>(truck_weights.length); // 대기중 트럭

		// readyTruck 초기화
		for (int i = 0; i < truck_weights.length; i++) {
			readyTruck.offer(truck_weights[i]);
		}

		// bridge 초기화
		for (int i = 0; i < bridge_length; i++) {
			bridge.offer(0);
		}

		int curWeight = 0; // 현재 다리 무게 (poll, offer 때마다 +,-)

		// 다리를 건너자
		while (completedTruck.size() != truck_weights.length) {

			int headBridge = bridge.poll();
			curWeight -= headBridge;
			
			if (headBridge > 0) {
				completedTruck.offer(headBridge);
			}

			if (readyTruck.size() > 0 && curWeight + readyTruck.peek() <= weight) {
				int poll = readyTruck.poll();
				bridge.offer(poll);
				curWeight += poll;
			} else {
				bridge.offer(0);
			}

			answer += 1;
		}

		return answer;
	}
}
