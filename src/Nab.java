public class Nab {

	// glasses
	// Cho N glasses có capacity lần lượt là 1, 2, 3, .. N lit
	// Tìm số glasses tối thiểu để rót đúng K lit
	// Yêu cầu phải nếu rót thì phải rót đầy ly, ko được lưng chừng ly
	// 1 <= N <= 1_000_000
	// 1 <= K <= 1_000_000_000
	public int solution1(int N, int K) {
		if ((long) K  > ((long) N * (N + 1) / 2)) {
			return -1;
		}
		int ans = 0;
		for (int i = N; i > 0; i--) {
			if (K >= i) {
				K -= i;
				ans++;
			}
			if (K == 0) {
				break;
			}
		}
		return K == 0 ? ans : -1;
	}

	// video_all_numbers
	// Cho mảng A, 1 <= A.length <= 100, 1 <= A[i] <= 1_000_000_000
	// Và số K, 1 <= K <= A.length
	// Tìm số lượng vị trí tối thiểu trong A cần sửa giá trị
	// để tồn tại 1 subarray độ dài K chứa K số từ 1 đến K
	public int solution2(int[] A, int K) {
		int n = A.length, ans = Integer.MAX_VALUE;
		boolean[] seen;
		for (int endIndex = K - 1; endIndex < n; endIndex++) {
			int startIndex = endIndex - K + 1, cnt = 0;
			seen = new boolean[K + 1];
			for (int i = startIndex; i <= endIndex; i++) {
				if (A[i] <= K) {
					seen[A[i]] = true;
				}
			}
			for (int i = 1; i <= K; i++) {
				cnt += (seen[i] ? 0 : 1);
			}
			ans = Math.min(ans, cnt);
		}
		return ans;
	}

	// moving_pieces
	// Cho 1 mảng board, chứa giá trị 0 hoặc/và 1, 1 <= board.length <= 40_000
	// Các quân (pieces) ban đầu được đặt tại vị trị board[i] = 1
	// Mỗi quân được di chuyển tối đa 1 lần
	// Mỗi lần di chuyển có thể sang trái/phải
	// nhưng ko được đi qua vị trí đã có quân khác đứng (bị block bởi quân bên trái/phải)
	// score là số bước đi được của mỗi quân
	// Tính số score lớn nhất có thể khi phối hợp di chuyển tất cả các quân có thể
	public int solution3(int[] board) {
		int n = board.length;
		int[] board2 = new int[n];
		for (int i = 0; i < n; i++) {
			board2[i] = board[n - 1 - i];
		}
		return Math.max(maxDist(n, board), maxDist(n, board2));
	}

	private int maxDist(int n, int[] board) {
		int ans = 0, l = 0;
		while (l < n && board[l] == 1) {
			l++;
		}
		for (int r = l; r < n; r++) {
			if (board[r] == 1) {
				ans += (r - l);
				l++;
			}
		}
		return ans;
	}
}
