/**
 * Description: https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
 */

public class FindTheDistanceValueBetweenTwoArrays {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for (int i : arr1) {
            boolean valid = true;
            for (int j : arr2) {
                if (Math.abs(i - j) <= d) {
                    valid = false;
                    break;
                }
            }
            ans += valid ? 1 : 0;
        }
        return ans;
    }
}
