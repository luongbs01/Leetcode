/**
 * Description: https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/description/
 */

public class MaxDifferenceYouCanGetFromChangingAnInteger {
    public int maxDiff(int num) {
        String numStr = String.valueOf(num);
        int first = 0;
        while (first < numStr.length() && numStr.charAt(first) == '9') {
            first++;
        }
        int max = num;
        if (first < numStr.length()) {
            max = Integer.parseInt(numStr.replace(numStr.charAt(first), '9'));
        }
        first = 0;
        while (first < numStr.length() && (numStr.charAt(first) == '0' || numStr.charAt(first) == '1')) {
            first++;
        }
        int min = num;
        if (first == 0) {
            min = Integer.parseInt(numStr.replace(numStr.charAt(first), '1'));
        } else if (first < numStr.length()) {
            min = Integer.parseInt(numStr.replace(numStr.charAt(first), '0'));
        }
        return max - min;
    }
}
