/**
 * Description: https://leetcode.com/problems/jump-game-ii/description/
 */

public class JumpGameII {

    public int jump(int[] nums) {
        int length = nums.length;
        int ans = 0;
        int curPos = 0;
        while (curPos < length - 1) {
            ans++;
            if (curPos + nums[curPos] >= length - 1) {
                return ans;
            }
            int nextPos = curPos + 1;
            int maxStep = Integer.MIN_VALUE;
            for (int i = curPos + 1; i <= curPos + nums[curPos]; i++) {
                if (i + nums[i] > maxStep) {
                    maxStep = i + nums[i];
                    nextPos = i;
                }
            }
            curPos = nextPos;
        }
        return ans;
    }
}
