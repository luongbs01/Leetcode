public class NabMinimumCars {

    // O(N) time
    // greedy
    public int solution(int[] P, int[] S) {
        int people = 0; // number of people
        int[] cars = new int[10]; // cars[i]: total number of cars having i seats
        int length = P.length;
        for (int i = 0; i < length; i++) {
            people += P[i];
            cars[S[i]]++;
        }
        int ans = 0;
        int seat = 9;
        while (people >= 0 && seat > 0) {
            if (cars[seat] > 0) {
                int numOfCars = Math.min(people < seat ? 1 : people / seat, cars[seat]);
                ans += numOfCars;
                people -= numOfCars * seat;
            }
            seat--;
        }
        return ans;
    }

    public static void main(String[] args) {
        NabMinimumCars nabMinimumCars = new NabMinimumCars();
        System.out.println(nabMinimumCars.solution(new int[]{2, 3, 4, 2}, new int[]{2, 5, 7, 2}));
    }
}
