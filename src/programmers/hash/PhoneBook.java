package programmers.hash;

import java.util.HashMap;

/**
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class PhoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
		
		HashMap<String, String> phoneMap = new HashMap<String, String>();
		
		for (String phone : phone_book) {
			phoneMap.put(phone, phone);
		}
		
		for (String phoneKey : phoneMap.keySet()) {
			int keyLen = phoneKey.length();
			for (String phoneKeyComp : phoneMap.keySet()) {
				if (!phoneKey.equals(phoneKeyComp)
                && phoneKey.length() < phoneKeyComp.length()
                && phoneKeyComp.substring(0, phoneKey.length()).equals(phoneKey)) {
					return false;
				}
			}
		}
        return answer;
    }
}