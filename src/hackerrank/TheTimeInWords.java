package hackerrank;

/**
 * level medium
 * https://www.hackerrank.com/challenges/the-time-in-words/problem
 */
public class TheTimeInWords {
	public String timeInWords(int h, int m) {
		String[] numberText = {
	            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", 
	            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
	            "twenty", "twenty one",    "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", 
	            "twenty eight", "twenty nine", 
	        };
	        
	        if (m == 0) {
	            return String.format("%s o' clock", numberText[h]);
	        }
	        
	        if ((m > 0 && m < 15) || (m > 15 && m < 30)) {
	            return String.format("%s " + (m == 1 ? "minute": "minutes") + " past %s", numberText[m], numberText[h]);
	        }
	        
	        if (m == 15) {
	            return String.format("quarter past %s", numberText[h]);
	        }
	        
	        if (m == 30) {
	            return String.format("half past %s", numberText[h]);
	        }
	        
	        if ((m > 30 && m < 45) || (m > 45 && m < 60)) {
	            return String.format("%s " + (60 - m == 1 ? "minute": "minutes") + " to %s", numberText[60 - m], numberText[h+1]);
	        }
	        
	        if (m == 45) {
	            return String.format("quarter to %s", numberText[h+1]);
	        }
	        
	        return null;
	}
}
