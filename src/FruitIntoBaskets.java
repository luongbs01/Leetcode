import java.util.HashMap;

/**
 * Description: https://leetcode.com/problems/fruit-into-baskets/description/
 */

public class FruitIntoBaskets {

    // 70ms, beats 5%
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0, index = 0;
        for (int fruit : fruits) {
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
            while (map.size() > 2) {
                int cnt = map.get(fruits[index]);
                if (cnt > 1) {
                    map.put(fruits[index], cnt - 1);
                } else {
                    map.remove(fruits[index]);
                }
                index++;
            }
            int sum = 0;
            for (int val : map.values()) {
                sum += val;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    // 40ms, beats 90%
    public int totalFruitV2(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0, l = 0;
        for (int r = 0; r < n; r++) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while (map.size() > 2) {
                int cnt = map.get(fruits[l]);
                if (cnt > 1) {
                    map.put(fruits[l], cnt - 1);
                } else {
                    map.remove(fruits[l]);
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
