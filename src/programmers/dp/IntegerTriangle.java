package programmers.dp;

/**
 * level 3
 * https://programmers.co.kr/learn/courses/30/lessons/43105
 */
public class IntegerTriangle {
	public int solution(int[][] triangle) {
		int[][] sum = new int[triangle.length][triangle.length];
		return recursive(triangle, sum, 0, 0);
	}
	
	public int recursive(int[][] triangle, int[][] sum, int r, int c) {
		if (triangle.length == r) return 0;
		if (sum[r][c] > 0) return sum[r][c];
		return sum[r][c] = triangle[r][c] + Math.max(recursive(triangle, sum, r+1, c), recursive(triangle, sum, r+1, c+1));
	}
}
