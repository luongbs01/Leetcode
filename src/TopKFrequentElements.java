import java.util.*;

/**
 * Description: https://leetcode.com/problems/top-k-frequent-elements/description/
 */

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        int[] arr = map.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .mapToInt(Map.Entry::getKey).limit(k).toArray();
        return arr;
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        System.out.println(topKFrequentElements.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2));
    }
}
