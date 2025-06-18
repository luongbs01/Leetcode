import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/valid-square/description/
 */

public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] slides = new int[6];
        slides[0] = dist(p1, p2);
        slides[1] = dist(p1, p3);
        slides[2] = dist(p1, p4);
        slides[3] = dist(p2, p3);
        slides[4] = dist(p2, p4);
        slides[5] = dist(p3, p4);
        Arrays.sort(slides);
        return slides[0] == slides[3] && slides[4] == slides[5] && slides[4] > slides[3];
    }

    private int dist(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
