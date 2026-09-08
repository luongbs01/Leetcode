/**
 * Description: https://leetcode.com/problems/reverse-degree-of-a-string/
 */

public class ReverseDegreeOfAString {

    public int reverseDegree(String s) {
        int ans = 0, idx = 1;
        for (char c : s.toCharArray()) {
            ans += (26 + 'a' - c) * idx;
            idx++;
        }
        return ans;
    }
}
