/**
 * Description: https://leetcode.com/problems/decode-xored-permutation/description/
 */

public class DecodeXORedPermutation {

    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] ans = new int[n];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum ^= i;
        }
        sum ^= encoded[0];
        for (int i = 1; i < encoded.length; i++) {
            encoded[i] = encoded[i] ^ encoded[i - 1];
            sum ^= encoded[i];
        }
        ans[0] = sum;
        for (int i = 1; i < n; i++) {
            ans[i] = sum ^ encoded[i - 1];
        }
        return ans;
    }
}
