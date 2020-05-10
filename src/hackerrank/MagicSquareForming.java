package hackerrank;

/**
 * level medium
 * https://www.hackerrank.com/challenges/magic-square-forming/problem
 */
public class MagicSquareForming {
	public int solution(int[][] s) {
		int result = 0;
		
		// 3차 마방진의 모든 경우의 수는 8개이다.
		// 가운데는 5, 네 곳의 꼭지점은 2,4,6,8로 고정
		// 그에 따라 1,3,5,7이 결정
		int[][] ms0 = {{8,1,6}, {3,5,7}, {4,9,2}};
        int[][] ms1 = {{6,1,8}, {7,5,3}, {2,9,4}};
        int[][] ms2 = {{4,9,2}, {3,5,7}, {8,1,6}};
        int[][] ms3 = {{2,9,4}, {7,5,3}, {6,1,8}};
        int[][] ms4 = {{8,3,4}, {1,5,9}, {6,7,2}};
        int[][] ms5 = {{4,3,8}, {9,5,1}, {2,7,6}};
        int[][] ms6 = {{6,7,2}, {1,5,9}, {8,3,4}};
        int[][] ms7 = {{2,7,6}, {9,5,1}, {4,3,8}};
        
        int[] arrAbs = new int[8];
        for (int i = 0; i < s.length; i++) {
        	for (int j = 0; j < s[i].length; j++) {
        		// 각각의 경우의 수와 차이를 비교해서 더하여 담아준다.
        		arrAbs[0] += Math.abs(s[i][j] - ms0[i][j]);
        		arrAbs[1] += Math.abs(s[i][j] - ms1[i][j]);
        		arrAbs[2] += Math.abs(s[i][j] - ms2[i][j]);
        		arrAbs[3] += Math.abs(s[i][j] - ms3[i][j]);
        		arrAbs[4] += Math.abs(s[i][j] - ms4[i][j]);
        		arrAbs[5] += Math.abs(s[i][j] - ms5[i][j]);
        		arrAbs[6] += Math.abs(s[i][j] - ms6[i][j]);
        		arrAbs[7] += Math.abs(s[i][j] - ms7[i][j]);
        	}
        }
        
        result = 100;
        for (int i = 0; i < arrAbs.length; i++) {
        	if (result > arrAbs[i]) {
        		result = arrAbs[i];
        	}
        }
        
		return result;
	}
}
