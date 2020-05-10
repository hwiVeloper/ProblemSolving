package hackerrank;

/**
 * level medium
 * https://www.hackerrank.com/challenges/encryption/problem
 */
public class Encryption {
	public static void main(String[] args) {
		String s1 = "haveaniceday";
		System.out.println(solution(s1));

		String s2 = "feedthedog";
		System.out.println(solution(s2));

		String s3 = "chillout";
		System.out.println(solution(s3));

		String s4 = "iffactsdontfittotheorychangethefacts";
		System.out.println(s4.length());
		System.out.println(solution(s4));
	}

	public static String solution(String s) {
		String result = "";

		int rows = (int)Math.sqrt(s.length() * 1.0);
		int columns;
		
		if (Math.pow(Math.sqrt(s.length() * 1.0), 2) == s.length()) {
			columns = rows;
		} else {
			columns = (int) Math.sqrt(s.length() * 1.0) + 1;
		}


		while (rows * columns < s.length()) {
			if (rows < columns) {
				rows++;
			} else {
				columns++;
			}
		}
		System.out.println(rows + " / " + columns);

		String[][] tmpArr = new String[rows][columns];

		for (int i = 0; i < rows; i++) {
			if (i == rows - 1) {
				tmpArr[i] = s.substring(columns * i).split("");
			} else {
				tmpArr[i] = s.substring(columns * i, columns * (i + 1)).split("");
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				if (i > tmpArr[j].length - 1) continue;
				sb.append(tmpArr[j][i]);
			}
			sb.append(" ");
		}

		result = sb.toString().trim();


		return result;
	}
}
