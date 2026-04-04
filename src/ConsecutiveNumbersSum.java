/**
 * Description: https://leetcode.com/problems/consecutive-numbers-sum/description/
 */

public class ConsecutiveNumbersSum {

	public int consecutiveNumbersSum(int n) {
		if (n <= 2)
			return 1;
		int ans = 1, num = 2;
		while (true) {
			double median = (double) n / num;
			if (median - num / 2 <= 0) {
				break;
			}
			if ((median % 1 == 0 && num % 2 == 1) || ((median - 0.5) % 1 == 0 && num % 2 == 0)) {
				ans++;
			}
			num++;
		}
		return ans;
	}
}
