import java.util.*;

/**
 * Description: https://leetcode.com/problems/design-twitter/description/
 */

public class DesignTwitter {

    Map<Integer, LinkedList<int[]>> posts;
    Map<Integer, LinkedList<Integer>> following;
    int timestamp;
    int n;

    public DesignTwitter() {
        posts = new HashMap<>();
        following = new HashMap<>();
        timestamp = 0;
        n = 10;
    }

    public void postTweet(int userId, int tweetId) {
        posts.putIfAbsent(userId, new LinkedList<>());
        posts.get(userId).addFirst(new int[]{timestamp++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> followers = following.getOrDefault(userId, new LinkedList<>());
        followers.addFirst(userId);
        PriorityQueue<int[]> pq = new PriorityQueue<>(n, Comparator.comparingInt(o -> o[0]));
        followers.forEach(follower -> {
            LinkedList<int[]> post = posts.getOrDefault(follower, new LinkedList<>());
            for (int i = 0; i < Math.min(n, post.size()); i++) {
                if (pq.size() < n) {
                    pq.offer(post.get(i));
                } else if (pq.peek()[0] < post.get(i)[0]) {
                    pq.poll();
                    pq.offer(post.get(i));
                }
            }
        });
        following.getOrDefault(userId, new LinkedList<>()).remove((Integer) userId);
        return pq.stream().sorted(Comparator.comparingInt(value -> -value[0])).map(a -> a[1]).distinct().toList();
    }

    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new LinkedList<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        following.getOrDefault(followerId, new LinkedList<>()).remove((Integer) followeeId);
    }
}
