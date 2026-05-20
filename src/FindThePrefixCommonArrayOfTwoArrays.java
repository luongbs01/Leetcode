/**
 * Description: https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/
 */

public class FindThePrefixCommonArrayOfTwoArrays {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        boolean[] marked = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            marked[A[i]] = true;
            int count = 0;
            for (int j = 0; j <= i; j++) {
                if (marked[B[j]]) count++;
            }
            ans[i] = count;
        }
        return ans;
    }

	public int[] findThePrefixCommonArrayV2(int[] A, int[] B) {
		int n = A.length, total = 0;
		int[] ans = new int[n];
		int[] cnt = new int[n + 1];
		for (int i = 0; i < n; i++) {
			cnt[A[i]]++;
			if (cnt[A[i]] == 2) {
				total++;
			}
			cnt[B[i]]++;
			if (cnt[B[i]] == 2) {
				total++;
			}
			ans[i] = total;
		}
		return ans;
	}
}
