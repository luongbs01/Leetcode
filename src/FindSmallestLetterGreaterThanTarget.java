/**
 * Description: https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 */

public class FindSmallestLetterGreaterThanTarget {

	public char nextGreatestLetter(char[] letters, char target) {
		int n = letters.length, l = 0, r = n - 1;
		if (letters[n - 1] <= target)
			return letters[0];
		while (l < r) {
			int mid = (l + r) >> 1;
			if (letters[mid] > target) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return letters[r];
	}
}
