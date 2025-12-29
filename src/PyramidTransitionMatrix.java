import java.util.List;

/**
 * Description: https://leetcode.com/problems/pyramid-transition-matrix/
 */

public class PyramidTransitionMatrix {

	boolean found = false;
	boolean[] isAllowed = new boolean[216];

	public boolean pyramidTransition(String bottom, List<String> allowed) {
		for (String str : allowed) {
			isAllowed[36 * (str.charAt(0) - 'A') + 6 * (str.charAt(1) - 'A') + (str.charAt(2) - 'A')] = true;
		}
		backtrack(new StringBuilder(), new StringBuilder(bottom));
		return found;
	}

	private void backtrack(StringBuilder curr, StringBuilder prev) {
		if (found)
			return;
		if (prev.length() == 2) {
			int base = 36 * (prev.charAt(0) - 'A') + 6 * (prev.charAt(1) - 'A');
			for (int i = 0; i < 6; i++) {
				if (isAllowed[base + i]) {
					found = true;
					break;
				}
			}
		} else if (curr.length() == prev.length() - 1) {
			backtrack(new StringBuilder(), curr);
		} else {
			int base = 36 * (prev.charAt(curr.length()) - 'A') + 6 * (prev.charAt(curr.length() + 1) - 'A');
			for (int i = 0; i < 6; i++) {
				if (isAllowed[base + i]) {
					curr.append((char) ('A' + i));
					backtrack(curr, prev);
					curr.deleteCharAt(curr.length() - 1);
				}
			}
		}
	}
}
