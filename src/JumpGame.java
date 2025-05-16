/**
 * Description: https://leetcode.com/problems/jump-game/description/
 */

public class JumpGame {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int curr = 0;
        while (true) {
            if (nums[curr] == 0 && curr < length - 1) {
                return false;
            } else if (curr + nums[curr] >= length - 1) {
                return true;
            }
            int maxStep = Integer.MIN_VALUE;
            int nextPos = curr + 1;
            for (int i = curr + 1; i <= curr + nums[curr]; i++) {
                if (maxStep <= nums[i]) {
                    for (int j = i + 1; j <= Math.min(i + nums[i], length - 1); j++) {
                        if (nums[j] != 0) {
                            maxStep = nums[i];
                            nextPos = i;
                            break;
                        }
                    }
                }
            }
            curr = nextPos;
        }
    }

    public boolean canJumpV2(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{4, 2, 0, 0, 1, 1, 4, 4, 4, 0, 4, 0}));
    }
}
