package hackerrank;

import java.util.LinkedList;
import java.util.Queue;

/**
 * level medium
 * 
 */
public class AppendAndDelete {
	public String solution(String s, String t, int k) {
		Queue<Character> qS = new LinkedList<Character>();
		Queue<Character> qT = new LinkedList<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			qS.offer(s.charAt(i));
		}
		
		for (int i = 0; i < t.length(); i++) {
			qT.offer(t.charAt(i));
		}
		
		while(!qS.isEmpty() && !qT.isEmpty() && qS.peek() == qT.peek()) {
			qS.poll();
			qT.poll();
		}
		
		int length = qS.size() + qT.size();
		
		if (length > k) {
            return "No";
        } else if (length % 2 == k % 2) {
            return "Yes";
        } else if (s.length() + t.length() < k) {
            return "Yes";
        } else {
            return "No";
        }
	}
}
