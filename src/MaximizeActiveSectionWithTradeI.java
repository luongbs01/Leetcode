import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/maximize-active-section-with-trade-i/
 */

public class MaximizeActiveSectionWithTradeI {

	public int maxActiveSectionsAfterTrade(String s) {
		int n, cntOnes = 0, cntZeros = 0;
		for (char c : s.toCharArray()) {
			cntOnes += c == '1' ? 1 : 0;
		}
		s = '1' + s + '1';
		List<Integer> zeros = new ArrayList<>();
		for (char c : s.toCharArray()) {
			if (c == '0') {
				cntZeros++;
			} else if (cntZeros > 0) {
				zeros.add(cntZeros);
				cntZeros = 0;
			}
		}
		n = zeros.size();
		if (n < 2) {
			return cntOnes;
		}
		for (int i = 1; i < n; i++) {
			cntZeros = Math.max(cntZeros, zeros.get(i - 1) + zeros.get(i));
		}
		return cntOnes + cntZeros;
	}
}
