/**
 * Description: https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
 */

public class CheckIfAll1sAreAtLeastLengthKPlacesAway {

    public boolean kLengthApart(int[] nums, int k) {
        int count = 0;
        boolean firstOne = true;
        for (int i : nums) {
            if (i == 0) {
                count++;
            } else if (count < k && !firstOne) {
                return false;
            } else {
                count = 0;
                firstOne = false;
            }
        }
        return true;
    }
}
