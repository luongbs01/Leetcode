/**
 * Description: https://leetcode.com/problems/find-the-encrypted-string/description/
 */

public class FindTheEncryptedString {

    public String getEncryptedString(String s, int k) {
        int n = s.length();
        k %= n;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(chars[(i + k) % n]);
        }
        return sb.toString();
    }
}
