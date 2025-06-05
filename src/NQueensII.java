import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/n-queens-ii/description/
 */

public class NQueensII {

    int ans = 0;
    int[][] directions = new int[][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int totalNQueens(int n) {
        int[][] marked = new int[n][n];
        backtrack(marked, 0, new ArrayList<>(), n);
        return ans;
    }

    private void backtrack(int[][] marked, int i, List<Integer> pos, int n) {
        if (i == n) {
            ans++;
        } else {
            for (int j = 0; j < n; j++) {
                if (marked[i][j] == 0) {
                    for (int k = 0; k < n; k++) {
                        marked[i][k]++;
                        marked[k][j]++;
                    }
                    for (int[] direction : directions) {
                        int nextX = i + direction[0];
                        int nextY = j + direction[1];
                        while (nextX >= 0 && nextX < n
                                && nextY >= 0 && nextY < n) {
                            marked[nextX][nextY]++;
                            nextX = nextX + direction[0];
                            nextY = nextY + direction[1];
                        }
                    }
                    pos.add(j);
                    backtrack(marked, i + 1, pos, n);
                    pos.remove(pos.size() - 1);
                    for (int k = 0; k < n; k++) {
                        marked[i][k]--;
                        marked[k][j]--;
                    }
                    for (int[] direction : directions) {
                        int nextX = i + direction[0];
                        int nextY = j + direction[1];
                        while (nextX >= 0 && nextX < n
                                && nextY >= 0 && nextY < n) {
                            marked[nextX][nextY]--;
                            nextX = nextX + direction[0];
                            nextY = nextY + direction[1];
                        }
                    }
                }
            }
        }
    }
}
