import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

class LinkedList {
    private Node head;

    // Insert at beginning
    public void insertAtBeginning(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted at beginning: " + val);
    }

    // Insert at end
    public void insertAtEnd(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null)
                curr = curr.next;
            curr.next = newNode;
        }
        System.out.println("Inserted at end: " + val);
    }

    // Insert at position (1-based index)
    public void insertAtPosition(int val, int pos) {
        if (pos <= 1) {
            insertAtBeginning(val);
            return;
        }
        Node newNode = new Node(val);
        Node curr = head;
        int count = 1;
        while (curr != null && count < pos - 1) {
            curr = curr.next;
            count++;
        }
        if (curr == null) {
            insertAtEnd(val);
            return;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        System.out.println("Inserted " + val + " at position " + pos);
    }

    // Search for an element
    public void search(int key) {
        Node curr = head;
        int pos = 1;
        while (curr != null) {
            if (curr.data == key) {
                System.out.println("Element " + key + " found at position: " + pos);
                return;
            }
            curr = curr.next;
            pos++;
        }
        System.out.println("Element " + key + " not found in the list.");
    }

    // Display all elements
    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        System.out.print("Linked List: ");
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}

public class LinkedListInsertion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position");
            System.out.println("4. Search for an element");
            System.out.println("5. Display all elements");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value to insert at beginning: ");
                    list.insertAtBeginning(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value to insert at end: ");
                    list.insertAtEnd(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter value to insert: ");
                    int val = sc.nextInt();
                    System.out.print("Enter position (1-based): ");
                    int pos = sc.nextInt();
                    list.insertAtPosition(val, pos);
                    break;
                case 4:
                    System.out.print("Enter value to search: ");
                    list.search(sc.nextInt());
                    break;
                case 5:
                    list.display();
                    break;
                case 6:
                    System.out.println("Exiting. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}




