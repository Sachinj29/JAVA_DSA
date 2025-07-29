
import java.util.Arrays;
import java.util.Scanner;

class BinarySearch {
    public static int binarySearch(int array[], int x, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (x == array[mid])
                return mid;

            if (x > array[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Input number of elements
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int array[] = new int[n];

        // Input the elements
        System.out.println("Enter the elements (in any order):");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Sort the array (just in case user didn't input in order)
        Arrays.sort(array);

        // Input the element to search
        System.out.print("Enter the element to search: ");
        int x = scanner.nextInt();

       // BinarySearch ob = new BinarySearch();
        int result = binarySearch(array, x, 0, n - 1);

        if (result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index: " + result);

        scanner.close();
    }
}





/*

Time Complexities

Best case complexity: O(1)
Average case complexity: O(log n)
Worst case complexity: O(log n)
Space Complexity

The space complexity of the binary search is O(1).

*/