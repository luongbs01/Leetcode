/**
 * Description: https://leetcode.com/problems/mirror-distance-of-an-integer/
 */

public class MirrorDistanceOfAnInteger {

	public int mirrorDistance(int n) {
		return (int) Math.abs(n - reverse(n));
	}

	private long reverse(int n) {
		long ans = 0L;
		while (n > 0) {
			ans = (ans * 10 + n % 10);
			n /= 10;
		}
		return ans;
	}
}
