import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

class LinkedList {
    private Node head;

    // Delete at beginning
    public void deleteAtBeginning() {
        if(head == null) {
            System.out.println("List is empty!");
            return;
        }
        System.out.println("Deleted from beginning: " + head.data);
        head = head.next;
    }

    // Delete at end
    public void deleteAtEnd() {
        if(head == null) {
            System.out.println("List is empty!");
            return;
        }
        if(head.next == null) {
            System.out.println("Deleted from end: " + head.data);
            head = null;
            return;
        }
        Node curr = head;
        while(curr.next.next != null)
            curr = curr.next;
        System.out.println("Deleted from end: " + curr.next.data);
        curr.next = null;
    }

    // Delete at position (1-based index)
    public void deleteAtPosition(int pos) {
        if(head == null) {
            System.out.println("List is empty!");
            return;
        }
        if(pos <= 1) {
            deleteAtBeginning();
            return;
        }
        Node curr = head;
        int count = 1;
        while(curr.next != null && count < pos - 1) {
            curr = curr.next;
            count++;
        }
        if(curr.next == null) {
            System.out.println("Invalid position!");
            return;
        }
        System.out.println("Deleted from position " + pos + ": " + curr.next.data);
        curr.next = curr.next.next;
    }

    // Search for an element
    public void search(int key) {
        Node curr = head;
        int pos = 1;
        while(curr != null) {
            if(curr.data == key) {
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
        if(head == null) {
            System.out.println("List is empty!");
            return;
        }
        System.out.print("Linked List: ");
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Utility method for initial setup (optional)
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
    }
}

public class LinkedListDeletation {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);

        // Optional: Initialize the list with some elements
        System.out.print("Enter number of initial elements: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value: ");
            list.insertAtEnd(sc.nextInt());
        }

        while(true) {
            System.out.println("\nMenu:");
            System.out.println("1. Delete at beginning");
            System.out.println("2. Delete at end");
            System.out.println("3. Delete at position");
            System.out.println("4. Search for an element");
            System.out.println("5. Display all elements");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    list.deleteAtBeginning();
                    break;
                case 2:
                    list.deleteAtEnd();
                    break;
                case 3:
                    System.out.print("Enter position to delete (1-based): ");
                    int pos = sc.nextInt();
                    list.deleteAtPosition(pos);
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
