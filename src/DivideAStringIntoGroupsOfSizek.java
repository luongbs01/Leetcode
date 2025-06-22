/**
 * Description: https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/description/
 */

public class DivideAStringIntoGroupsOfSizek {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int size = (int) Math.ceil((double) n / k);
        String[] ans = new String[size];
        StringBuilder sb = new StringBuilder(k);
        for (int i = 0; i < n; i++) {
            if (i > 0 && i % k == 0) {
                ans[i / k - 1] = sb.toString();
                sb = new StringBuilder(k);
            }
            sb.append(chars[i]);
        }
        while (sb.length() < k) {
            sb.append(fill);
        }
        ans[size - 1] = sb.toString();
        return ans;
    }
}
