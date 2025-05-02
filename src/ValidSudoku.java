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
}
