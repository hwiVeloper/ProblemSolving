package hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * level medium
 * https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
 */
public class OrganizingContainersOfBalls {
	public String solution(int[][] container) {
		List<Integer> sumContainer = new ArrayList<Integer>();
        List<Integer> sumBall = new ArrayList<Integer>();
        for(int i = 0; i < container.length; i++){
            int rs = 0;
            int cs = 0;
            for(int j = 0; j < container[i].length; j++){
                rs += container[i][j]; 
                cs += container[j][i];
            }
            sumContainer.add(rs);
            sumBall.add(cs);
        }
        
        sumContainer.removeAll(sumBall);

        if (sumContainer.isEmpty()) {
            return "Possible";
        } else {
            return "Impossible";
        }
	}
}
