import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/apple-redistribution-into-boxes/description/
 */

public class AppleRedistributionIntoBoxes {

	public int minimumBoxes(int[] apple, int[] capacity) {
		int sum = 0, ans = 0, index = capacity.length - 1;
		for (int i : apple) {
			sum += i;
		}
		Arrays.sort(capacity);
		while (sum > 0 && index >= 0) {
			sum -= capacity[index];
			index--;
			ans++;
		}
		return ans;
	}
}
