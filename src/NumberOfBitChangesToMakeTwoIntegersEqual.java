/**
 * Description: https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal/description/
 */

public class NumberOfBitChangesToMakeTwoIntegersEqual {

    public int minChanges(int n, int k) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0 && (k & (1 << i)) == 0) {
                count++;
            } else if ((n & (1 << i)) == 0 && (k & (1 << i)) != 0) {
                return -1;
            }
        }
        return count;
    }
}
