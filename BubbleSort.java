
import java.util.*;
import java.util.Arrays;
import java.util.Scanner;

class BubbleSort {

  // perform the bubble sort
  static void bubbleSort(int array[]) {
    int size = array.length;

    for (int i = 0; i < size - 1; i++) {
      for (int j = 0; j < size - i - 1; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
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

    // Sort the array
    BubbleSort.bubbleSort(data);

    // Display sorted array
    System.out.println("Sorted Array in Ascending Order:");
    System.out.println(Arrays.toString(data));

    scanner.close();
  }
}
