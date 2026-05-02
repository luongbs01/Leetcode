/**
 * Description: https://leetcode.com/problems/rotated-digits/description/
 */

public class RotatedDigits {

	public int rotatedDigits(int n) {
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans += isValid(i) ? 1 : 0;
		}
		return ans;
	}

	private boolean isValid(int x) {
		int i = 1, rotated = 0;
		while (i < x) {
			i *= 10;
		}
		while (i > 0) {
			int digit = (x / i) % 10;
			rotated *= 10;
			switch (digit) {
			case 2:
			case 5:
				rotated += (7 - digit);
				break;
			case 6:
			case 9:
				rotated += (15 - digit);
				break;
			case 0:
			case 1:
			case 8:
				rotated += digit;
				break;
			default:
				return false;
			}
			i /= 10;
		}
		return x != rotated;
	}
}
