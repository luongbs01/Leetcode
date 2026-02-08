/**
 * Description: https://leetcode.com/problems/count-monobit-integers/description/
 */

public class CountMonobitIntegers {

	public int countMonobit(int n) {
		int cnt = 0;
		while ((1 << cnt) - 1 <= n) {
			cnt++;
		}
		return cnt;
	}
}
