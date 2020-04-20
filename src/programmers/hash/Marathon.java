package programmers.hash;

import java.util.Arrays;

/**
 * level 1
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class Marathon {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 정렬 후 비교?
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        
        if (answer.equals("")) return participant[participant.length - 1];
        
        return answer;
    }
}