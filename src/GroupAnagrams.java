import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/group-anagrams/description/
 */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            String key = arrayToString(getNumOfOccurrenceArr(str));
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(str);
            map.put(key, value);
        }
        return new ArrayList<>(map.values());
    }

    private String arrayToString(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i]);
            stringBuilder.append((char) (i + 'a'));
        }
        return stringBuilder.toString();
    }

    private int[] getNumOfOccurrenceArr(String s) {
        int[] res = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            res[s.charAt(i) - 'a']++;
        }
        return res;
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
