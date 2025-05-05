import java.util.HashMap;

/**
 * Description: https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int length = arr.length;
        int left = 0, sum, maxF;
        int ans = 0;
        for (int right = 0; right < length; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            sum = 0;
            maxF = 0;
            for (int i : map.values()) {
                sum += i;
                maxF = Math.max(maxF, i);
            }
            if (sum - maxF <= k) {
                ans = Math.max(ans, right - left + 1);
            } else {
                map.put(arr[left], map.get(arr[left]) - 1);
                left++;
            }
        }
        return ans;
    }

    public int characterReplacementV2(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int length = arr.length;
        int left = 0, maxF;
        int ans = 0;
        for (int right = 0; right < length; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            maxF = 0;
            for (int i : map.values()) {
                maxF = Math.max(maxF, i);
            }
            // sum equals to (right - left + 1)
            if (right - left + 1 - maxF <= k) {
                ans = Math.max(ans, right - left + 1);
            } else {
                map.put(arr[left], map.get(arr[left]) - 1);
                left++;
            }
        }
        return ans;
    }
}
