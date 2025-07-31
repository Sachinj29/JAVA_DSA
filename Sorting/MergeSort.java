import java.util.Scanner;

class MergeSort {

    // Merge two subarrays L and M into arr
    void merge(int arr[], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int L[] = new int[n1];
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = arr[q + 1 + j];

        int i = 0, j = 0, k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }

    // Divide the array into two subarrays, sort them and merge them
    void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    // Print the array
    static void printArray(int arr[]) {
        for (int value : arr)
            System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Get array size from user
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Get array elements from user
        System.out.println("Enter " + n + " integer elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        MergeSort ob = new MergeSort();
        ob.mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);

        scanner.close();
    }
}
