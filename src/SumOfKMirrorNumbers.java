/**
 * Description: https://leetcode.com/problems/sum-of-k-mirror-numbers/description/
 */

public class SumOfKMirrorNumbers {
    long ans = 0;
    int cnt = 0;

    public long kMirror(int k, int n) {
        int numOfDigits = 0;
        while (cnt < n) {
            numOfDigits++;
            StringBuilder sb = new StringBuilder("0".repeat(numOfDigits));
            for (int i = 1; i <= 9; i++) {
                sb.setCharAt(0, (char) (i + '0'));
                sb.setCharAt(numOfDigits - 1, (char) (i + '0'));
                dfs(sb, numOfDigits, 1, k, n);
            }
        }
        return ans;
    }

    private void dfs(StringBuilder sb, int numOfDigits, int i, int k, int n) {
        if (numOfDigits > 2 && ((numOfDigits % 2 == 1 && i <= numOfDigits / 2) || (numOfDigits % 2 == 0 && i < numOfDigits / 2))) {
            for (int l = 0; l <= 9; l++) {
                sb.setCharAt(i, (char) (l + '0'));
                sb.setCharAt(numOfDigits - 1 - i, (char) (l + '0'));
                dfs(sb, numOfDigits, i + 1, k, n);
            }
        } else if (isKMirror(k, Long.parseLong(sb.toString())) && cnt < n) {
            ans += Long.parseLong(sb.toString());
            cnt++;
        }
    }

    private boolean isKMirror(int k, long i) {
        StringBuilder sb = new StringBuilder();
        while (i != 0) {
            sb.append(i % k);
            i /= k;
        }
        int length = sb.length();
        for (int j = 0; j < length / 2; j++) {
            if (sb.charAt(j) != sb.charAt(length - 1 - j)) {
                return false;
            }
        }
        return true;
    }
}
