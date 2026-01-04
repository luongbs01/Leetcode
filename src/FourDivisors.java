/**
 * Description: https://leetcode.com/problems/four-divisors/
 */

public class FourDivisors {

	public int sumFourDivisors(int[] nums) {
		int ans = 0;
		for (int num : nums) {
			int sqrt = (int) Math.sqrt(num);
			int count = 2, sum = 1 + num;
			for (int i = 2; i <= sqrt && count <= 4; i++) {
				if (num / i * i == num && i != num / i) {
					sum += i + num / i;
					count += 2;
				} else if (num / i * i == num && i == num / i) {
					count++;
				}
			}
			if (count == 4)
				ans += sum;
		}
		return ans;
	}
}
