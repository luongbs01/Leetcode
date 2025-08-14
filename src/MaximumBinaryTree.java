/**
 * Description: https://leetcode.com/problems/maximum-binary-tree/description/
 */

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        int max = 0, index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        int[] left = new int[index], right = new int[nums.length - index - 1];
        System.arraycopy(nums, 0, left, 0, index);
        for (int i = index + 1; i < nums.length; i++) {
            right[i - index - 1] = nums[i];
        }
        root.left = constructMaximumBinaryTree(left);
        root.right = constructMaximumBinaryTree(right);
        return root;
    }
}
