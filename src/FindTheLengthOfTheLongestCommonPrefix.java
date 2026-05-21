import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description/
 */

public class FindTheLengthOfTheLongestCommonPrefix {

	public int longestCommonPrefix(int[] arr1, int[] arr2) {
		int ans = 0;
		Set<Integer> set = new HashSet<>();
		for (int num : arr1) {
			int i = num;
			while (i != 0) {
				set.add(i);
				i /= 10;
			}
		}
		for (int num : arr2) {
			int i = num;
			while (i != 0) {
				if (set.contains(i)) {
					ans = Math.max(ans, String.valueOf(i).length());
					break;
				}
				i /= 10;
			}
		}
		return ans;
	}
}
