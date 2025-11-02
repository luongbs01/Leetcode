import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/count-unguarded-cells-in-the-grid/description/
 */

public class CountUnguardedCellsInTheGrid {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid1 = new int[m][n], grid2 = new int[m][n];
        ArrayList<ArrayList<Integer>> rows = new ArrayList<>(m), cols = new ArrayList<>(n);
        for (int i = 0; i < m; i++) {
            rows.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            cols.add(new ArrayList<>());
        }
        for (int[] guard : guards) {
            grid1[guard[0]][guard[1]] = 2;
            grid2[guard[0]][guard[1]] = 2;
            rows.get(guard[0]).add(guard[1]);
            cols.get(guard[1]).add(guard[0]);
        }
        for (int[] wall : walls) {
            grid1[wall[0]][wall[1]] = 3;
            grid2[wall[0]][wall[1]] = 3;
        }
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> row = rows.get(i);
            for (int j : row) {
                int k = j + 1;
                while (k < n && grid1[i][k] == 0) {
                    grid1[i][k] = 1;
                    k++;
                }
                k = j - 1;
                while (k >= 0 && grid1[i][k] == 0) {
                    grid1[i][k] = 1;
                    k--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> col = cols.get(i);
            for (int j : col) {
                int k = j + 1;
                while (k < m && grid2[k][i] == 0) {
                    grid2[k][i] = 1;
                    k++;
                }
                k = j - 1;
                while (k >= 0 && grid2[k][i] == 0) {
                    grid2[k][i] = 1;
                    k--;
                }
            }
        }
        int ans = 0;
        for (int i = 0 ; i < m; i++) {
            System.out.println(Arrays.toString(grid1[i]));
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
