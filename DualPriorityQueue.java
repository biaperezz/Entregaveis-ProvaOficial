import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DualPriorityQueue {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    private Map<Integer, Integer> frequencyMap;

    public DualPriorityQueue() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        frequencyMap = new HashMap<>();
    }

    public void insert(int value) {
        minHeap.add(value);
        maxHeap.add(value);
        frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
    }

    public Integer getMin() {
        while (!minHeap.isEmpty() && frequencyMap.getOrDefault(minHeap.peek(), 0) == 0) {
            minHeap.poll();
        }
        return minHeap.isEmpty() ? null : minHeap.peek();
    }

    public Integer getMax() {
        while (!maxHeap.isEmpty() && frequencyMap.getOrDefault(maxHeap.peek(), 0) == 0) {
            maxHeap.poll();
        }
        return maxHeap.isEmpty() ? null : maxHeap.peek();
    }

    public Integer removeMin() {
        Integer minValue = getMin(); 

        if (minValue != null) {
            minHeap.poll();
            frequencyMap.put(minValue, frequencyMap.get(minValue) - 1);
        }

        return minValue;
    }

    public Integer removeMax() {
        Integer maxValue = getMax();

        if (maxValue != null) {
            maxHeap.poll();
            frequencyMap.put(maxValue, frequencyMap.get(maxValue) - 1);
        }

        return maxValue;
    }

    public static void main(String[] args) {
        DualPriorityQueue dpq = new DualPriorityQueue();

        dpq.insert(10);
        dpq.insert(5);
        dpq.insert(20);
        dpq.insert(2);
        dpq.insert(7);

        System.out.println("Min atual: " + dpq.getMin()); 
        System.out.println("Max atual: " + dpq.getMax()); 

        System.out.println("\nRemovendo Min: " + dpq.removeMin()); 
        System.out.println("Min atual: " + dpq.getMin()); 
        System.out.println("Max atual: " + dpq.getMax()); 

        System.out.println("\nRemovendo Max: " + dpq.removeMax());
        System.out.println("Min atual: " + dpq.getMin()); 
        System.out.println("Max atual: " + dpq.getMax()); 

        System.out.println("\nAdicionando duplicatas...");
        dpq.insert(10); 
        System.out.println("Max atual: " + dpq.getMax()); 

        System.out.println("\nRemovendo Max: " + dpq.removeMax()); 
        System.out.println("Max atual: " + dpq.getMax()); 
        
        System.out.println("\nRemovendo Max: " + dpq.removeMax()); 
        System.out.println("Max atual: " + dpq.getMax()); 
        System.out.println("Min atual: " + dpq.getMin()); 
    }
}
