import java.util.Scanner;

public class Queue {
    private int SIZE;
    private int[] items;
    private int front, rear;

    // Constructor to set queue size dynamically
    Queue(int size) {
        SIZE = size;
        items = new int[SIZE];
        front = -1;
        rear = -1;
    }

    boolean isFull() {
        return rear == SIZE - 1;
    }

    boolean isEmpty() {
        return front == -1;
    }

    void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1)
                front = 0;
            items[++rear] = element;
            System.out.println("Inserted " + element);
        }
    }

    int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int element = items[front];
            if (front == rear) {
                // Queue has only one element, reset after removing it
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            System.out.println("Deleted -> " + element);
            return element;
        }
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Front index-> " + front);
            System.out.print("Items -> ");
            for (int i = front; i <= rear; i++)
                System.out.print(items[i] + "  ");
            System.out.println("\nRear index-> " + rear);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get queue size from user
        System.out.print("Enter the size of the queue: ");
        int size = sc.nextInt();
        Queue q = new Queue(size);

        while (true) {
            System.out.println("\nSelect operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int val = sc.nextInt();
                    q.enQueue(val);
                    break;
                case 2:
                    q.deQueue();
                    break;
                case 3:
                    q.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }
}
