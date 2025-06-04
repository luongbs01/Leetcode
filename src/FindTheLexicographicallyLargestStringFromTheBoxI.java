/**
 * Description: https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/description/
 */

public class FindTheLexicographicallyLargestStringFromTheBoxI {

    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length() - numFriends + 1;
        String ans = word.substring(word.length() - 1);
        int right = word.length() - 2;
        while (right >= 0) {
            String s = word.substring(right, Math.min(right + n, word.length()));
            if (ans.compareTo(s) < 0) {
                ans = s;
            }
            right--;
        }
        return ans;
    }
}
