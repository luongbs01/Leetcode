import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/contains-duplicate/description/
 */

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer numOfOccurrence = map.get(num);
            if (numOfOccurrence == null) {
                map.put(num, 1);
            } else {
                return true;
            }
        }
        return false;
    }
}
