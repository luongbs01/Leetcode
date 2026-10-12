/**
 * Description: https://leetcode.com/problems/maximize-sum-of-squares-of-digits/
 */

public class MaximizeSumOfSquaresOfDigits {

    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        while (sum > 0) {
            for (int i = 9; i > 0; i--) {
                if (sum >= i) {
                    sum -= i;
                    num--;
                    ans.append(i);
                    break;
                }
            }
        }
        ans.repeat("0", num);
        return ans.toString();
    }
}
