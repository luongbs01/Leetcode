import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/rotate-image/description/
 */

public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // LinkedList: 1ms --> ArrayList: 0ms
        List<Integer> list = new ArrayList<>(n * n);
        for (int[] row : matrix) {
            for (int i : row) {
                list.add(i);
            }
        }
        Iterator<Integer> iterator = list.iterator();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                matrix[j][i] = iterator.next();
            }
        }
    }
}
