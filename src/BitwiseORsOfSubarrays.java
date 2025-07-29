import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/bitwise-ors-of-subarrays/description/
 */

public class BitwiseORsOfSubarrays {

    // Got this idea from this problem: https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or/description/
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        int[] pos = new int[32];
        Arrays.fill(pos, -1);
        for (int i = n - 1; i >= 0; i--) {
            int num = arr[i];
            set.add(num);
            int[] sorted = Arrays.copyOf(pos, 32);
            Arrays.sort(sorted);
            for (int j : sorted) {
                if (j >= 0) {
                    num |= arr[j];
                    set.add(num);
                }
            }

            for (int j = 0; j < 32; j++) {
                if (((1 << j) & arr[i]) != 0) {
                    pos[j] = i;
                }
            }
        }
        return set.size();
    }
}
