import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/description/
 */

public class MinimumDeletionsToMakeStringKSpecial {

    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = Integer.MAX_VALUE;
        int min = 0;
        for (int i : freq) {
            if (i > 0) {
                pq.offer(i);
            }
        }
        while (!pq.isEmpty()) {
            int currMin = pq.poll();
            int cnt = 0;
            for (int i : freq) {
                if (i > currMin + k) {
                    cnt += (i - currMin - k);
                }
            }
            ans = Math.min(ans, min + cnt); // keep the smallest freq
            min += currMin; // delete the smallest freq
        }
        return ans;
    }
}
