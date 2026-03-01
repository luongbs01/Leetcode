/**
 * Description: https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 */

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

	public int minPartitions(String n) {
		int ans = 1;
		for (int i = 0; i < n.length(); i++) {
			ans = Math.max(ans, n.charAt(i) - '0');
		}
		return ans;
	}
}
