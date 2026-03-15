/**
 * Description: https://leetcode.com/problems/first-unique-even-element/description/
 */

public class FirstUniqueEvenElement {

	public int firstUniqueEven(int[] nums) {
		int[] freq = new int[101];
		for (int i : nums) {
			freq[i]++;
		}
		for (int i = 0; i < nums.length; i++) {
			if (freq[nums[i]] == 1 && (nums[i] & 1) == 0) {
				return nums[i];
			}
		}
		return -1;
	}
}
