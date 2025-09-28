/**
 * Description: https://leetcode.com/problems/majority-frequency-characters/
 */

public class MajorityFrequencyCharacters {

    public String majorityFrequencyGroup(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int[] groupSize = new int[101];
        int maxGroupSize = 0, maxFreq = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            groupSize[freq[i]]++;
            if (groupSize[freq[i]] > maxGroupSize) {
                maxGroupSize = groupSize[freq[i]];
                maxFreq = freq[i];
            } else if (groupSize[freq[i]] == maxGroupSize && freq[i] > maxFreq) {
                maxFreq = freq[i];
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (freq[i] == maxFreq) {
                ans.append((char) (i + 'a'));
            }
        }
        return ans.toString();
    }
}
