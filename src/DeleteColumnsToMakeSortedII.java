/**
 * Description: https://leetcode.com/problems/delete-columns-to-make-sorted-ii/
 */

public class DeleteColumnsToMakeSortedII {

	public int minDeletionSize(String[] strs) {
		int n = strs.length, m = strs[0].length(), ans = 0, unsolved = n - 1;
		boolean[] resolved = new boolean[n - 1];
		for (int i = 0; i < m && unsolved > 0; i++) {
			boolean needDeletion = false;
			for (int j = 0; j < n - 1; j++) {
				if (!resolved[j] && strs[j].charAt(i) > strs[j + 1].charAt(i)) {
					needDeletion = true;
					break;
				}
			}
			if (needDeletion) {
				ans++;
				continue;
			}
			for (int j = 0; j < n - 1; j++) {
				if (!resolved[j] && strs[j].charAt(i) < strs[j + 1].charAt(i)) {
					resolved[j] = true;
					unsolved--;
				}
			}
		}
		return ans;
	}
}
