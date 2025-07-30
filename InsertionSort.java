import java.util.*;

class InsertionSort {

  void insertionSort(int array[]) {
    int size = array.length;

    for (int step = 1; step < size; step++) {
      int key = array[step];
      int j = step - 1;

      // Compare key with each element on the left of it until an element smaller than
      // it is found.
      // For descending order, change key<array[j] to key>array[j].
      while (j >= 0 && key < array[j]) {
        array[j + 1] = array[j];
        --j;
      }

      // Place key after the element just smaller than it.
      array[j + 1] = key;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Ask user for the number of elements
    System.out.print("Enter number of elements to sort: ");
    int n = scanner.nextInt();

    int[] data = new int[n];

    // Read elements from user input
    System.out.println("Enter " + n + " integers:");
    for (int i = 0; i < n; i++) {
      data[i] = scanner.nextInt();
    }

    // Sort the array using insertion sort
    InsertionSort sorter = new InsertionSort();
    sorter.insertionSort(data);

    // Display sorted array
    System.out.println("Sorted Array in Ascending Order:");
    System.out.println(Arrays.toString(data));

    scanner.close();
  }
}
