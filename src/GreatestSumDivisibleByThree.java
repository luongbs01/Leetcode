import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/greatest-sum-divisible-by-three/
 */

public class GreatestSumDivisibleByThree {

    public int maxSumDivThree(int[] nums) {
        int ans = 0;
        List<Integer> ones = new ArrayList<>(), twos = new ArrayList<>();
        for (int i : nums) {
            ans += i;
            if (i % 3 == 1) {
                ones.add(i);
            } else if (i % 3 == 2) {
                twos.add(i);
            }
        }
        Collections.sort(ones);
        Collections.sort(twos);
        if (ans % 3 == 1) {
            ans -= Math.min(!ones.isEmpty() ? ones.getFirst() : Integer.MAX_VALUE, twos.size() > 1 ? twos.get(0) + twos.get(1) : Integer.MAX_VALUE);
        } else if (ans % 3 == 2) {
            ans -= Math.min(ones.size() > 1 ? ones.get(0) + ones.get(1) : Integer.MAX_VALUE, !twos.isEmpty() ? twos.getFirst() : Integer.MAX_VALUE);
        }
        return ans;
    }
}
