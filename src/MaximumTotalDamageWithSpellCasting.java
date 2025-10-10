import java.util.HashMap;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/maximum-total-damage-with-spell-casting/description/
 */

public class MaximumTotalDamageWithSpellCasting {

    public long maximumTotalDamage(int[] power) {
        HashMap<Long, Long> freq = new HashMap<>();
        for (int i : power) {
            freq.put((long) i, freq.getOrDefault((long) i, 0L) + i);
        }
        int n = freq.size(), index = 0;
        long[] key = new long[n], value = new long[n];
        List<Long> sortedKeys = freq.keySet().stream().sorted().toList();
        for (Long k : sortedKeys) {
            key[index] = k;
            value[index] = freq.get(k);
            index++;
        }
        long ans = 0, max = 0;
        for (int i = 0; i < n; i++) {
            if (i >= 3) max = Math.max(max, value[i - 3]);
            if (i >= 2 && key[i - 2] < key[i] - 2) max = Math.max(max, value[i - 2]);
            if (i >= 1 && key[i - 1] < key[i] - 2) max = Math.max(max, value[i - 1]);
            value[i] += max;
            ans = Math.max(ans, value[i]);
        }
        return ans;
    }
}
