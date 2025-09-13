import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/
 */

public class MinimumConsecutiveCardsToPickUp {

    // 44ms
    public int minimumCardPickup(int[] cards) {
        int n = cards.length, ans = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = cards[i];
            if (map.containsKey(val)) {
                ans = Math.min(ans, i - map.get(val) + 1);
            }
            map.put(val, i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // 22ms
    public int minimumCardPickupV2(int[] cards) {
        int n = cards.length, ans = Integer.MAX_VALUE, max = 0;
        for (int card : cards) {
            max = Math.max(max, card);
        }
        int[] arr = new int[max + 1];
        Arrays.fill(arr, -1);
        for (int i = 0; i < n; i++) {
            int val = cards[i];
            if (arr[val] != -1) {
                ans = Math.min(ans, i - arr[val] + 1);
            }
            arr[val] = i;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
