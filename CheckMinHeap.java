import java.util.Arrays;

public class CheckMinHeap {

    public static boolean isMinHeap(int[] arr) {
        int n = arr.length;

        if (n <= 1) {
            return true;
        }

        for (int i = 1; i < n; i++) {
            
            int parentIndex = (i - 1) / 2;

            if (arr[parentIndex] > arr[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        
        int[] heapValido = {2, 5, 4, 10, 7, 6, 9};
        System.out.println("Array: " + Arrays.toString(heapValido));
        System.out.println("É Min-Heap? " + isMinHeap(heapValido)); // true

        int[] heapInvalido1 = {2, 5, 4, 3, 7, 6, 9};
        System.out.println("\nArray: " + Arrays.toString(heapInvalido1));
        System.out.println("É Min-Heap? " + isMinHeap(heapInvalido1)); // false

        int[] heapInvalido2 = {8, 5, 4, 10, 7, 6, 9};
        System.out.println("\nArray: " + Arrays.toString(heapInvalido2));
        System.out.println("É Min-Heap? " + isMinHeap(heapInvalido2)); // false

        int[] heapUmElemento = {100};
        System.out.println("\nArray: " + Arrays.toString(heapUmElemento));
        System.out.println("É Min-Heap? " + isMinHeap(heapUmElemento)); // true
    }
}
