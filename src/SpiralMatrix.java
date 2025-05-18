import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/spiral-matrix/description/
 */

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int[][] directions = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int i = 0, j = 0;
        ans.add(matrix[0][0]);
        matrix[0][0] = 101;
        while (true) {
            boolean canProceed = false;
            for (int[] direction : directions) {
                int nextX = i + direction[0];
                int nextY = j + direction[1];
                while (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                        && matrix[nextX][nextY] != 101) {
                    i = nextX;
                    j = nextY;
                    ans.add(matrix[i][j]);
                    matrix[i][j] = 101;
                    nextX = i + direction[0];
                    nextY = j + direction[1];
                    canProceed = true;
                }
                if (canProceed) {
                    break;
                }
            }
            if (!canProceed) {
                return ans;
            }
        }
    }
}
