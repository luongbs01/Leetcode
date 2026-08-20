import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/distribute-elements-into-two-arrays-i/description/
 */

public class DistributeElementsIntoTwoArraysI {

	public int[] resultArray(int[] nums) {
		int n = nums.length;
		List<Integer> arr1 = new ArrayList<>();
		List<Integer> arr2 = new ArrayList<>();
		arr1.add(nums[0]);
		arr2.add(nums[1]);
		for (int i = 2; i < n; i++) {
			if (arr1.getLast() > arr2.getLast()) {
				arr1.add(nums[i]);
			} else {
				arr2.add(nums[i]);
			}
		}
		arr1.addAll(arr2);
		return arr1.stream().mapToInt(a -> a).toArray();
	}
}
