import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted at beginning: " + data);
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        System.out.println("Inserted at end: " + data);
    }

    // Insert at position (1-based index)
    public void insertAtPosition(int data, int pos) {
        if (pos <= 1) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node curr = head;
        int count = 1;
        while (curr != null && count < pos - 1) {
            curr = curr.next;
            count++;
        }
        if (curr == null) {
            insertAtEnd(data);
            return;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        System.out.println("Inserted " + data + " at position " + pos);
    }

    // Delete at the beginning
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        System.out.println("Deleted from beginning: " + head.data);
        head = head.next;
    }

    // Delete at end
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.next == null) {
            System.out.println("Deleted from end: " + head.data);
            head = null;
            return;
        }
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        System.out.println("Deleted from end: " + curr.next.data);
        curr.next = null;
    }

    // Delete at position (1-based index)
    public void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (pos <= 1) {
            deleteAtBeginning();
            return;
        }
        Node curr = head;
        int count = 1;
        while (curr.next != null && count < pos - 1) {
            curr = curr.next;
            count++;
        }
        if (curr.next == null) {
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

    // Display the list
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

public class LinkedListAllOperations {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete at beginning");
            System.out.println("5. Delete at end");
            System.out.println("6. Delete at position");
            System.out.println("7. Search element");
            System.out.println("8. Display list");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            
            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    list.insertAtBeginning(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    list.insertAtEnd(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    System.out.print("Enter position (1-based index): ");
                    int pos = sc.nextInt();
                    list.insertAtPosition(val, pos);
                    break;
                case 4:
                    list.deleteAtBeginning();
                    break;
                case 5:
                    list.deleteAtEnd();
                    break;
                case 6:
                    System.out.print("Enter position (1-based index): ");
                    list.deleteAtPosition(sc.nextInt());
                    break;
                case 7:
                    System.out.print("Enter element to search: ");
                    list.search(sc.nextInt());
                    break;
                case 8:
                    list.display();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

