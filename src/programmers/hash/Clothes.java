package programmers.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 */
class Clothes {
	public int solution(String[][] clothes) {
		int answer = 1;

		Map<String, Integer> countMap = new HashMap<String, Integer>();

		for (int i = 0; i < clothes.length; i++) {
			countMap.put(clothes[i][1], countMap.getOrDefault(clothes[i][1], 0) + 1);
		}

		for (String key : countMap.keySet()) {
			answer *= countMap.get(key) + 1;
		}

		return answer - 1;
	}
}
