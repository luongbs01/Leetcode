import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/single-number-ii/
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        Map<Integer, Byte> m = new HashMap<>();
        for (int i : nums) {
            if (!m.containsKey(i)) {
                m.put(i, (byte) 1);
            } else {
                m.put(i, (byte) (m.get(i) + 1));
            }
        }
        for (int i : m.keySet()) {
            if (m.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }
}
