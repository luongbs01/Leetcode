import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/binary-prefix-divisible-by-5/
 */

public class BinaryPrefixDivisibleBy5 {

    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length, x = 0;
        List<Boolean> ans = new ArrayList<>(n);
        for (int i : nums) {
            x = (x << 1) ^ i;
            if (x >= 10) x %= 10;
            ans.add(x == 0 || x == 5);
        }
        return ans;
    }
}
