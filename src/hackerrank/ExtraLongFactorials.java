package hackerrank;

import java.math.BigDecimal;

public class ExtraLongFactorials {
	public BigDecimal solution(int a) {
		BigDecimal result = BigDecimal.ONE;
		
		for (int i = a; i > 0; i--) {
			result = result.multiply(new BigDecimal(i));
		}
		
		return result;
	}
}
