package hackerrank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * level medium
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 * https://duzi077.tistory.com/159
 */
public class ClimbingLeaderboard {	
	public int[] solution(int[] scores, int[] alice) {
		int[] result = new int[alice.length];
		
		TreeSet<Integer> setScores = new TreeSet<Integer>();
		for (int i = 0; i < scores.length; i++) {
			setScores.add(scores[i]);
		}
		
		//
		NavigableSet<Integer> descendingSet = setScores.descendingSet();
		
		
		System.out.println(descendingSet);
		
//		for (int i = 0; i < alice.length; i++) {
//			System.out.println(alice[i]);
//			for (int j = scores.length - 1; j >= 0; j--) {
//				System.out.println(alice[i] + " :: " + scores[j]);
//				if (alice[i] < scores[j]) {
//					result[i] = j+2;
//					break;
//				} else {
//					result[i] = j+1;
//				}
//			}
//			System.out.println("결국 등수 : " + result[i]);
//		}
//		
//		return result;
		HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        Iterator iter = descendingSet.iterator();
        while(iter.hasNext()) map.put((Integer)iter.next(), rank++);
        
        for(int i = 0; i < alice.length; i++) {
            int as = alice[i];
            if(as > descendingSet.first()) {
            	result[i] = 1;
                continue;
            }
            if(as < descendingSet.last()) {
            	result[i] = map.get(descendingSet.last()) + 1;
                continue;
            }
            result[i] = map.get(descendingSet.ceiling(as));
        }
        
        return result;
	}
}
