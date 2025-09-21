import java.util.*;

/**
 * Description: https://leetcode.com/problems/design-movie-rental-system/
 */

public class DesignMovieRentalSystem {

    class MovieRentingSystem {

        Map<List<Integer>, Integer> priceMap = new HashMap<>();
        Map<Integer, TreeSet<List<Integer>>> unrented = new HashMap<>(); // movie -> [shop, price]
        TreeSet<List<Integer>> rented = new TreeSet<>((o1, o2) -> !Objects.equals(o1.get(2), o2.get(2)) ? o1.get(2) - o2.get(2) : !Objects.equals(o1.get(0), o2.get(0)) ? o1.get(0) - o2.get(0) : o1.get(1) - o2.get(1)); // [shop, movie, price]


        public MovieRentingSystem(int n, int[][] entries) {
            for (int[] entry : entries) {
                priceMap.put(List.of(entry[0], entry[1]), entry[2]);
                unrented.putIfAbsent(entry[1], new TreeSet<>((o1, o2) -> !Objects.equals(o1.get(1), o2.get(1)) ? o1.get(1) - o2.get(1) : o1.get(0) - o2.get(0)));
                unrented.get(entry[1]).add(List.of(entry[0], entry[2]));
            }
        }

        public List<Integer> search(int movie) {
            List<Integer> shops = new ArrayList<>(5);
            TreeSet<List<Integer>> set = unrented.get(movie);
            if (set == null) return shops;
            Iterator<List<Integer>> it = set.iterator();
            while (it.hasNext() && shops.size() < 5) {
                List<Integer> shop = it.next();
                shops.add(shop.get(0));
            }
            return shops;
        }

        public void rent(int shop, int movie) {
            int price = priceMap.get(List.of(shop, movie));
            unrented.get(movie).remove(List.of(shop, price));
            rented.add(List.of(shop, movie, price));
        }

        public void drop(int shop, int movie) {
            int price = priceMap.get(List.of(shop, movie));
            unrented.get(movie).add(List.of(shop, price));
            rented.remove(List.of(shop, movie, price));
        }

        public List<List<Integer>> report() {
            Iterator<List<Integer>> it = rented.iterator();
            List<List<Integer>> list = new ArrayList<>(5);
            while (it.hasNext() && list.size() < 5) {
                List<Integer> movie = it.next();
                list.add(List.of(movie.get(0), movie.get(1)));
            }
            return list;
        }
    }
}
