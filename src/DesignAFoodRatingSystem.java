import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class DesignAFoodRatingSystem {

    class FoodRatings {

        HashMap<String, String> foodToCuisine = new HashMap<>();
        HashMap<String, Integer> rating = new HashMap<>();
        HashMap<String, TreeMap<Integer, TreeSet<String>>> highestRated = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                foodToCuisine.put(foods[i], cuisines[i]);
                rating.put(foods[i], ratings[i]);
                highestRated.putIfAbsent(cuisines[i], new TreeMap<>());
                highestRated.get(cuisines[i]).putIfAbsent(ratings[i], new TreeSet<>());
                highestRated.get(cuisines[i]).get(ratings[i]).add(foods[i]);
            }
        }

        public void changeRating(String food, int newRating) {
            String cuisine = foodToCuisine.get(food);
            int currRating = rating.get(food);
            highestRated.get(cuisine).get(currRating).remove(food);
            if (highestRated.get(cuisine).get(currRating).isEmpty()) {
                highestRated.get(cuisine).remove(currRating);
            }
            highestRated.get(cuisine).putIfAbsent(newRating, new TreeSet<>());
            highestRated.get(cuisine).get(newRating).add(food);
            rating.put(food, newRating);
        }

        public String highestRated(String cuisine) {
            return highestRated.get(cuisine).lastEntry().getValue().first();
        }
    }
}
