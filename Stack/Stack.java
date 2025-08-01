import java.util.Scanner;

class Stack {
    private int arr[];
    private int top;
    private int capacity;

    // Creating a stack
    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // Add elements into stack
    public void push(int x) {
        if (isFull()) {
            System.out.println("OverFlow: Stack is full!");
            return;
        }
        arr[++top] = x;
        System.out.println("Inserted " + x);
    }

    // Remove element from stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("UnderFlow: Stack is empty!");
            return -1; // Sentinel value
        }
        int val = arr[top--];
        System.out.println("Removed " + val);
        return val;
    }

    // Return the size of the stack
    public int size() {
        return top + 1;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("Stack elements:");
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take stack size from user
        System.out.print("Enter stack size: ");
        int size = sc.nextInt();
        Stack stack = new Stack(size);

        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Print Stack");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    stack.push(val);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.printStack();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
