package hackerrank;

import java.util.List;

/**
 * level medium
 * https://www.hackerrank.com/challenges/non-divisible-subset/problem
 */
public class NonDivisibleSubset {
	public static int solution(int k, List<Integer> s) {
		int result = 0;
		int[] remainArr = new int[k];
		for (Integer i : s) {
			remainArr[i % k]++;
		}

		if (remainArr[0] > 0) {
			result += 1;
		}

		for (int i = 1; i < remainArr.length / 2 + 1; i++) {
			if (i == remainArr.length / 2 && k % 2 == 0) {
				if (remainArr[i] > 0) result++;
			} else {
				result += Math.max(remainArr[i], remainArr[k-i]);
			}
		}

		return result;
	}
}
