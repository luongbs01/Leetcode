/**
 * Description: https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
 */
public class MaximizeTheConfusionOfAnExam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int len = answerKey.length();
        int left = 0, right = 0;
        int countF = 0, countT = 0;
        int ans = Integer.MIN_VALUE;
        while (right < len) {
            while ((countT <= k || countF <= k) && (right < len)) {
                if (answerKey.charAt(right) == 'T')
                    countT++;
                else countF++;
                right++;
            }

            if ((countT > k && countF > k))
                ans = Math.max(ans, countT + countF - 1);
            else ans = Math.max(ans, countT + countF);

            while (!(countT <= k || countF <= k) && (left < right)) {
                if (answerKey.charAt(left) == 'T')
                    countT--;
                else countF--;
                left++;
            }
        }
        return ans;
    }
}
