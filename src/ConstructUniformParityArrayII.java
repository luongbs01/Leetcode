/**
 * Description: https://leetcode.com/problems/construct-uniform-parity-array-ii/description/
 */

public class ConstructUniformParityArrayII {

	public boolean uniformArray(int[] nums1) {
		int minEven = Integer.MAX_VALUE, minOdd = Integer.MAX_VALUE;
		for (int num : nums1) {
			if ((num & 1) != 0) {
				minOdd = Math.min(minOdd, num);
			} else {
				minEven = Math.min(minEven, num);
			}
		}
		return minOdd == Integer.MAX_VALUE || minEven > minOdd;
	}
}
