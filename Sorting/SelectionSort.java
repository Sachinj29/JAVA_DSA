import java.util.Arrays;
import java.util.Scanner;

class SelectionSort {
    void selectionSort(int array[]) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[min_idx]) {
                    min_idx = j;
                }
            }
            // Swap
            int temp = array[i];
            array[i] = array[min_idx];
            array[min_idx] = temp;
        }
    }
    

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Get array size from user
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();

        int[] data = new int[size];

        // Get array elements from user
        System.out.println("Enter " + size + " integer elements:");
        for (int i = 0; i < size; i++) {
            data[i] = scanner.nextInt();
        }

        SelectionSort ss = new SelectionSort();
        ss.selectionSort(data);

        System.out.println("Sorted Array in Ascending Order:");
        System.out.println(Arrays.toString(data));
        scanner.close();
    }
}
