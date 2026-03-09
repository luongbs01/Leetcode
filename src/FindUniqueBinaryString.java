/**
 * Description: https://leetcode.com/problems/find-unique-binary-string/
 */

public class FindUniqueBinaryString {

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            StringBuilder sb = new StringBuilder(n);
            int k = i;
            while (sb.length() < n) {
                sb.append(k & 1);
                k >>= 1;
            }
            String s = sb.reverse().toString();
            boolean found = false;
            for (String num : nums) {
                if (num.equals(s)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return s;
            }
        }
        return null;
    }
}
