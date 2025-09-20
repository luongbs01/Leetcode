/**
 * Description: https://leetcode.com/problems/design-spreadsheet/description/
 */

public class DesignSpreadsheet {

    class Spreadsheet {

        int[][] grid;

        public Spreadsheet(int rows) {
            grid = new int[rows + 1][26];
        }

        public void setCell(String cell, int value) {
            int[] pos = stringToArray(cell);
            grid[pos[0]][pos[1]] = value;
        }

        public void resetCell(String cell) {
            setCell(cell, 0);
        }

        public int getValue(String formula) {
            String[] strings = formula.substring(1).split("\\+");
            return convert(strings[0]) + convert(strings[1]);
        }

        private int convert(String str) {
            if (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') {
                int[] pos = stringToArray(str);
                return grid[pos[0]][pos[1]];
            }
            return Integer.parseInt(str);
        }

        private int[] stringToArray(String cell) {
            int[] ans = new int[2];
            ans[1] = cell.charAt(0) - 'A';
            cell = cell.substring(1);
            ans[0] = Integer.parseInt(cell);
            return ans;
        }
    }
}
