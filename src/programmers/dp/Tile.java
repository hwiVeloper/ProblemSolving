package programmers.dp;

import java.util.*;

/**
 * level 3
 * https://programmers.co.kr/learn/courses/30/lessons/43104
 */
public class Tile {
	public long solution(int N) {
		if (N == 1) return 4;
		if (N == 2) return 4 + 2;
		
		List<Long> lengthList = new ArrayList<Long>();
		for (int i = 0; i < N; i++) {
			if (i == 0 || i == 1) {
				lengthList.add(i, (long) 1);
			} else {
				lengthList.add(i, lengthList.get(i - 2) + lengthList.get(i - 1));
			}
		}
		
		return lengthList.get(N - 1) * 4 + lengthList.get(N - 2) * 2;
	}
}
