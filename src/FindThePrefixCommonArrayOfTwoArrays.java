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
}
