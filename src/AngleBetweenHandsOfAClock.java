/**
 * Description: https://leetcode.com/problems/angle-between-hands-of-a-clock/
 */

public class AngleBetweenHandsOfAClock {

	public double angleClock(int hour, int minutes) {
		double ans = Math.abs(hour * 30 + minutes / 2.0 - minutes * 6);
		return ans > 180 ? 360 - ans : ans;
	}
}
