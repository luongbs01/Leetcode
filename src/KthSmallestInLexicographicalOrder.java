/**
 * Description: https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/description/
 */

public class KthSmallestInLexicographicalOrder {

    public int findKthNumber(long n, long k) {
        long currNum = 1;
        while (k > 1) {
            long currChildren = numChildren(currNum, n);
            if (currChildren < k) {
                k -= currChildren;
                currNum++;
            } else {
                k--;
                currNum *= 10;
            }
        }
        return (int) currNum;
    }

    private long numChildren(long i, long n) {
        long cnt = 0;
        long min = i, max = i;
        while (min <= max) {
            cnt += (max - min + 1);
            min = min * 10;
            max = Math.min(n, max * 10 + 9);
        }
        return cnt;
    }
}
