import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/n-queens/
 */

public class NQueens {
    List<List<String>> ans = new ArrayList<>();
    int[][] directions = new int[][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public List<List<String>> solveNQueens(int n) {
        int[][] marked = new int[n][n];
        backtrack(marked, 0, new ArrayList<>(), n);
        return ans;
    }

    private void backtrack(int[][] marked, int i, List<Integer> pos, int n) {
        if (i == n) {
            List<String> list = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    if (k == pos.get(j)) {
                        stringBuilder.append('Q');
                    } else {
                        stringBuilder.append('.');
                    }
                }
                list.add(stringBuilder.toString());
            }
            ans.add(new ArrayList<>(list));
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
