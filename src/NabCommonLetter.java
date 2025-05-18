import java.util.Arrays;

public class NabCommonLetter {

    // O(M*N) time
    // If N >= 27, position of common letter is always 0
    public int[] solution(String[] S) {
        int N = S.length;
        int M = S[0].length();
        for (int i = 0; i < M; i++) {
            int[] f = new int[26];
            Arrays.fill(f, -1);
            for (int j = 0; j < N; j++) {
                if (f[S[j].charAt(i) - 'a'] != -1) {
                    return new int[]{f[S[j].charAt(i) - 'a'], j, i};
                }
                f[S[j].charAt(i) - 'a'] = j;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        NabCommonLetter nabCommonLetter = new NabCommonLetter();
        System.out.println(Arrays.toString(nabCommonLetter.solution(new String[]{"bdafg", "ceagi"})));
    }
}
