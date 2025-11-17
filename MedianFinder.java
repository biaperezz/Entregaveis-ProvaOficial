import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();

        System.out.println("Adicionando 5...");
        mf.addNum(5);
        System.out.println("Mediana atual: " + mf.findMedian()); // 5.0

        System.out.println("\nAdicionando 10...");
        mf.addNum(10);
        System.out.println("Mediana atual: " + mf.findMedian()); // 7.5

        System.out.println("\nAdicionando 2...");
        mf.addNum(2);
        System.out.println("Mediana atual: " + mf.findMedian()); // 5.0

        System.out.println("\nAdicionando 8...");
        mf.addNum(8);
        System.out.println("Mediana atual: " + mf.findMedian()); // 6.5

        System.out.println("\nAdicionando 100...");
        mf.addNum(100);
        System.out.println("Mediana atual: " + mf.findMedian()); // 8.0
    }
}
