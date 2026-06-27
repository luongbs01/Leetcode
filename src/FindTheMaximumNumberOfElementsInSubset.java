import java.util.HashMap;

/**
 * Description: https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/
 */

public class FindTheMaximumNumberOfElementsInSubset {

	public int maximumLength(int[] nums) {
		int ans = 1;
		HashMap<Integer, Integer> freq = new HashMap<>();
		for (int num : nums) {
			freq.put(num, freq.getOrDefault(num, 0) + 1);
		}
		for (int num : nums) {
			int i = num, cnt = 0;
			if (i == 1) {
				cnt = freq.get(i);
				cnt = (cnt & 1) != 0 ? cnt : cnt - 1;
				ans = Math.max(ans, cnt);
				continue;
			}
			while (freq.getOrDefault(i, 0) > 1) {
				i *= i;
				cnt++;
			}
			if (freq.getOrDefault(i, 0) > 0) {
				ans = Math.max(ans, (cnt << 1) | 1);
			} else {
				ans = Math.max(ans, (cnt << 1) - 1);
			}
		}
		return ans;
	}
}
