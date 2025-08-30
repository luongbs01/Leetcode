import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/top-k-frequent-elements/description/
 */

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<String, Map<Character, Boolean>> map = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            map.put("row" + i, new HashMap<>());
            map.put("col" + i, new HashMap<>());
            map.put("box" + i, new HashMap<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (Boolean.TRUE.equals(map.get("row" + i).get(c))
                            || Boolean.TRUE.equals(map.get("col" + j).get(c))
                            || Boolean.TRUE.equals(map.get("box" + ((i / 3) * 3 + (j / 3))).get(c))) {
                        return false;
                    }
                    map.get("row" + i).put(c, true);
                    map.get("col" + j).put(c, true);
                    map.get("box" + ((i / 3) * 3 + (j / 3))).put(c, true);
                }
            }
        }
        return true;
    }

    public boolean isValidSudokuV2(char[][] board) {
        boolean[][][] marked = new boolean[3][9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (marked[0][i][c - '1'] || marked[1][j][c - '1'] || marked[2][(i / 3) * 3 + (j / 3)][c - '1']) {
                        return false;
                    }
                    marked[0][i][c - '1'] = true;
                    marked[1][j][c - '1'] = true;
                    marked[2][(i / 3) * 3 + (j / 3)][c - '1'] = true;
                }
            }
        }
        return true;
    }
}
