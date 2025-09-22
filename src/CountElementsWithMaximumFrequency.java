/**
 * Description: https://leetcode.com/problems/count-elements-with-maximum-frequency/
 */

public class CountElementsWithMaximumFrequency {

    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int ans = 0, max = 0;
        for (int num : nums) {
            freq[num]++;
            if (freq[num] > max) {
                max = freq[num];
                ans = max;
            } else if (freq[num] == max) {
                ans += max;
            }
        }
        return ans;
    }
}
