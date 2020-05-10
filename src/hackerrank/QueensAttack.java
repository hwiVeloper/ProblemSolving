package hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * level medium
 * https://www.hackerrank.com/challenges/queens-attack-2/problem
 */
public class QueensAttack {
	public static void main(String[] args) {
		int n = 5;
		int k = 3;
		int r_q = 4;
		int c_q = 3;
		int[][] obstacles = {{5, 5}, {4, 2}, {2, 3}};
		
		System.out.println(solution(n, k, r_q, c_q, obstacles));
	}
	
	public static int solution(int n, int k, int r_q, int c_q, int[][] obstacles) {
		int result = 0;
		
		// 모든 방향
		int[] x = {0, 1, 1, 1, 0, -1, -1, -1};
		int[] y = {1, 1, 0, -1, -1, -1, 0, 1};
		
		// 장애물 Map으로
		Map<String, String> mapObs = new HashMap<String, String>();
		for (int i = 0; i < obstacles.length; i++) {
			mapObs.put(obstacles[i][0] + ":" + obstacles[i][1], "obs");
		}
		
		for (int i = 0; i < 8; i++) {
			int tmpX = r_q;
			int tmpY = c_q;
			while (true) {
				tmpX += x[i];
				tmpY += y[i];
				// 벽에 막히는지
				if (tmpX > n || tmpY > n || tmpX <= 0 || tmpY <= 0) {
					break;
				}
				
				// 장애물이 있는지
				if (mapObs.containsKey(tmpX + ":" + tmpY)) {
					break;
				}
				
				System.out.println(tmpX + " : " + tmpY);
				
				result++;
			}
		}
		
		return result;
    }
}
