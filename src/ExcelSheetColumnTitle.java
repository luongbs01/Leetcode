/**
 * Description: https://leetcode.com/problems/excel-sheet-column-title/description/
 */

public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            if (columnNumber % 26 == 0 ) {
                sb.append('Z');
                columnNumber--;
            } else {
                sb.append((char) (columnNumber % 26 - 1 + 'A'));
            }
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
