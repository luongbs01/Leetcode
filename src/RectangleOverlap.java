/**
 * Description: https://leetcode.com/problems/rectangle-overlap/
 */

public class RectangleOverlap {

    // Idea from https://leetcode.com/problems/rectangle-overlap/solutions/8519984/solution-by-la_castille-a7g0
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] && rec2[0] < rec1[2]
                && rec1[1] < rec2[3] && rec2[1] < rec1[3];
    }
}
