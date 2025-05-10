/**
 * Description: https://leetcode.com/problems/word-search/description/
 */

public class WordSearch {

    char[] arr;
    int rows, cols;
    boolean[][] marked;

    public boolean exist(char[][] board, String word) {
        arr = word.toCharArray();
        rows = board.length;
        cols = board[0].length;
        if (rows == 1 && cols == 1 && word.length() == 1) {
            return board[0][0] == word.charAt(0);
        }
        marked = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                marked[i][j] = true;
                if (backtrack(board, 0, i, j, false)) {
                    return true;
                }
                marked[i][j] = false;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int index, int row, int col, boolean ans) {
        if (index == arr.length - 1 && board[row][col] == arr[index]) {
            return true;
        } else if (!ans) {
            if (board[row][col] == arr[index]) {
                if (row + 1 < rows && !marked[row + 1][col]) {
                    marked[row + 1][col] = true;
                    ans = backtrack(board, index + 1, row + 1, col, ans);
                    marked[row + 1][col] = false;
                    if (ans) {
                        return ans;
                    }
                }
                if (row - 1 >= 0 && !marked[row - 1][col]) {
                    marked[row - 1][col] = true;
                    ans = backtrack(board, index + 1, row - 1, col, ans);
                    marked[row - 1][col] = false;
                    if (ans) {
                        return ans;
                    }
                }
                if (col + 1 < cols && !marked[row][col + 1]) {
                    marked[row][col + 1] = true;
                    ans = backtrack(board, index + 1, row, col + 1, ans);
                    marked[row][col + 1] = false;
                    if (ans) {
                        return ans;
                    }
                }
                if (col - 1 >= 0 && !marked[row][col - 1]) {
                    marked[row][col - 1] = true;
                    ans = backtrack(board, index + 1, row, col - 1, ans);
                    marked[row][col - 1] = false;
                    if (ans) {
                        return ans;
                    }
                }
            }
        }
        return ans;
    }
}
