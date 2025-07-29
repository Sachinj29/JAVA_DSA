import java.util.Scanner;

class LinearSearch {
    public static int linearSearch(int array[], int x) {
        int n = array.length;

        // Going through array sequentially
        for (int i = 0; i < n; i++) {
            if (array[i] == x)
                return i;
        }
        return -1;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for number of elements
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int array[] = new int[n];

        // Input elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Ask user for element to search
        System.out.print("Enter the element to search: ");
        int x = scanner.nextInt();

        int result = linearSearch(array, x);

        if (result == -1)
            System.out.print("Element not found");
        else
            System.out.print("Element found at index: " + result);

        scanner.close();
    }
}
