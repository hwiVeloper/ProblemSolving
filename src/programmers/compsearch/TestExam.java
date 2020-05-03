package programmers.compsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * level 1
 * https://programmers.co.kr/learn/courses/30/lessons/42840 
 */
public class TestExam {
	public int[] solution(int[] answers) {
		int[] answer = {};
		int[] member1 = {1, 2, 3, 4, 5};
		int[] member2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] member3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		int[] cnt = {0, 0, 0};

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == member1[i % 5]) cnt[0] += 1;
			if (answers[i] == member2[i % 8]) cnt[1] += 1;
			if (answers[i] == member3[i % 10]) cnt[2] += 1;
		}
		
		int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2])); // 최대값
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] == max) result.add(i+1);
		}
		
		answer = result.stream().mapToInt(Integer::intValue).toArray();
		
		return answer;
	}
}
