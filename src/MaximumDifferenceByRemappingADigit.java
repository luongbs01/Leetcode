/**
 * Description: https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/description/
 */

public class MaximumDifferenceByRemappingADigit {

    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);
        char first = numStr.charAt(0);
        for (char c : numStr.toCharArray()) {
            if (c != '9') {
                first = c;
                break;
            }
        }
        int max = Integer.parseInt(numStr.replace(first, '9'));
        int min = Integer.parseInt(numStr.replace(numStr.charAt(0), '0'));
        return max - min;
    }
}
