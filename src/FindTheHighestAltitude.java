/**
 * Description: https://leetcode.com/problems/find-the-highest-altitude/
 */

public class FindTheHighestAltitude {

	public int largestAltitude(int[] gain) {
		int ans = 0, alt = 0;
		for (int i : gain) {
			alt += i;
			ans = Math.max(ans, alt);
		}
		return ans;
	}
}
