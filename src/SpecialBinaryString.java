import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/special-binary-string/
 */

public class SpecialBinaryString {

	// s = 1 + s1 + 0 + 1 + s2 + 0 + .. + 1 + sN + 0
	// N >= 1
	// makeLargestSpecial(s) = Arrays.sort(makeLargestSpecial(s1), makeLargestSpecial(s2),.. makeLargestSpecial(sN))
	public String makeLargestSpecial(String s) {
		List<String> specialSubStrings = new ArrayList<>();
		int i = 0, cnt = 0;
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) == '1') {
				cnt++;
			} else {
				cnt--;
			}

			// found a special substring
			if (cnt == 0) {
				specialSubStrings.add("1" + makeLargestSpecial(s.substring(i + 1, j)) + "0");
				i = j + 1;
			}
		}
		specialSubStrings.sort(Collections.reverseOrder());

		StringBuilder ans = new StringBuilder();
		for (String str : specialSubStrings) {
			ans.append(str);
		}
		return ans.toString();
	}
}
