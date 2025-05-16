/**
 * Description: https://leetcode.com/problems/merge-triplets-to-form-target-triplet/description/
 */

public class MergeTripletsToFormTargetTriplet {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] t = new int[]{0, 0, 0};
        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0]
                    && triplet[1] <= target[1]
                    && triplet[2] <= target[2]) {
                t = new int[]{Math.max(t[0], triplet[0]),
                        Math.max(t[1], triplet[1]),
                        Math.max(t[2], triplet[2])};
            }
        }
        return t[0] == target[0] && t[1] == target[1] && t[2] == target[2];
    }
}
