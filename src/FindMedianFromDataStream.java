import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/find-median-from-data-stream/description/
 */

public class FindMedianFromDataStream {

    class MedianFinder {

        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        }

        public void addNum(int num) {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }
            while (maxHeap.size() - minHeap.size() > 1) {
                minHeap.offer(maxHeap.poll());
            }
            while (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            return minHeap.size() == maxHeap.size() ? (minHeap.peek() + maxHeap.peek()) / 2.0 :
                    minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
        }
    }
}
