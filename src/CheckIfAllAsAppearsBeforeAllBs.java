/**
 * Description: https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/
 */

public class CheckIfAllAsAppearsBeforeAllBs {

    public boolean checkString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == 'b' && chars[i] == 'a') {
                return false;
            }
        }
        return true;
    }
}
