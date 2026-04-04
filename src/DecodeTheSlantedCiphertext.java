/**
 * Description: https://leetcode.com/problems/decode-the-slanted-ciphertext/
 */

public class DecodeTheSlantedCiphertext {

	public String decodeCiphertext(String encodedText, int rows) {
		int cols = encodedText.length() / rows, index = 0;
		char[][] chars = new char[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				chars[i][j] = encodedText.charAt(index);
				index++;
			}
		}
		StringBuilder ans = new StringBuilder(encodedText.length());
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				if (i + j < cols) {
					ans.append(chars[j][i + j]);
				}
			}
		}
		while (!ans.isEmpty() && ans.charAt(ans.length() - 1) == ' ') {
			ans.deleteCharAt(ans.length() - 1);
		}
		return ans.toString();
	}
}
