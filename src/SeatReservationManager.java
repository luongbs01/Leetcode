import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/seat-reservation-manager/description/
 */

public class SeatReservationManager {

    class SeatManager {

        PriorityQueue<Integer> pq;

        public SeatManager(int n) {
            pq = new PriorityQueue<>(n);
            for (int i = 1; i <= n; i++) {
                pq.offer(i);
            }
        }

        public int reserve() {
            return pq.poll();
        }

        public void unreserve(int seatNumber) {
            pq.offer(seatNumber);
        }
    }
}
