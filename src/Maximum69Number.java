/**
 * Description: https://leetcode.com/problems/maximum-69-number/description/
 */
public class Maximum69Number {

    public int maximum69Number(int num) {
        return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
    }

    public int maximum69NumberV2(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
