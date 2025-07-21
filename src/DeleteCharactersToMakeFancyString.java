/**
 * Description: https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/
 */

public class DeleteCharactersToMakeFancyString {

    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        char currChar = s.charAt(0);
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c != currChar) {
                sb.append(c);
                currChar = c;
                cnt = 1;
            } else if (cnt < 2) {
                sb.append(c);
                cnt++;
            }
        }
        return sb.toString();
    }
}
