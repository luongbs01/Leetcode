/**
 * Description: https://leetcode.com/problems/n-th-tribonacci-number/description/
 */

public class NthTribonacciNumber {

    public int tribonacci(int n) {
        int[] arr = new int[n + 1];
        if (n < 2) {
            return n;
        }
        arr[1] = arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
        }
        return arr[n];
    }
}
