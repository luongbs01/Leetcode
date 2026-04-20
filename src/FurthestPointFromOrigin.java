/**
 * Description: https://leetcode.com/problems/furthest-point-from-origin/
 */

public class FurthestPointFromOrigin {

	public int furthestDistanceFromOrigin(String moves) {
		int n = moves.length(), l = 0, r = 0;
		for (char c : moves.toCharArray()) {
			if (c == 'L') {
				l++;
			} else if (c == 'R') {
				r++;
			}
		}
		return Math.abs(l - r) + (n - l - r);
	}
}
