/**
 * Description: https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/description/
 */

public class MaximumDifferenceBetweenEvenAndOddFrequencyI {

    public int maxDifference(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] freq = new int[26];
        for (char c : chars) {
            freq[c - 'a']++;
        }
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        for (int i : freq) {
            if (i > 0 && i % 2 == 0) {
                minEven = Math.min(minEven, i);
            } else if (i % 2 == 1) {
                maxOdd = Math.max(maxOdd, i);
            }
        }
        return maxOdd - minEven;
    }
}
