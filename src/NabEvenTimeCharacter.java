import java.util.HashMap;
import java.util.Map;

public class NabEvenTimeCharacter {

    // O(N^2) time
    // XOR : x ^ x = 0
    public int solution(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = chars[i] - 'a';
        }
        int ans = 0;
        for (int i = 0; i < length - 1; i++) {
            int num = arr[i];
            for (int j = i + 1; j < length; j++) {
                num = num ^ arr[j];
                if (num == 0) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    // O(N) time
    public int solutionV2(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int ans = 0;
        int mask = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 0; i < length; i++) {
            mask ^= 1 << (chars[i] - 'a');
            if (!map.containsKey(mask)) {
                map.put(mask, i + 1);
            }
            ans = Math.max(ans, i + 1 - map.get(mask));
        }
        return ans;
    }

    public static void main(String[] args) {
        NabEvenTimeCharacter nabEvenTimeCharacter = new NabEvenTimeCharacter();
        System.out.println(nabEvenTimeCharacter.solution("zthtzh"));
        System.out.println(nabEvenTimeCharacter.solutionV2("zthtzh"));
    }
}
