import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KMaioresElementos {

    public static List<Integer> findKthLargest(int[] arr, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.add(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] meuArray = {3, 2, 1, 5, 6, 4, 9, 8, 7, 0};
        int k = 3;

        List<Integer> kMaiores = findKthLargest(meuArray, k);

        System.out.println("Array original: " + java.util.Arrays.toString(meuArray));
        System.out.println("K = " + k);
        System.out.println("Os " + k + " maiores elementos sao: " + kMaiores);
        
        int[] outroArray = {2, 7, 1, 8, 3, 5, 9, 4, 6};
        int k2 = 4;
        List<Integer> kMaiores2 = findKthLargest(outroArray, k2);
        System.out.println("\nOs " + k2 + " maiores elementos sao: " + kMaiores2);
    }
}
