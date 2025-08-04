import java.util.Scanner;

/**
 * Implements a Doubly Linked List data structure in Java.
 * Includes methods for insertion, deletion, traversal, and search.
 */
public class AllOperationDoublyLinkedList {

    // Inner class to represent a node in the doubly linked list
    private class Node {
        int data;
        Node prev;
        Node next;

        /**
         * Constructor to create a new node.
         * @param data The data to be stored in the node.
         */
        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Head and tail pointers for the list
    private Node head;
    private Node tail;
    private int size;

    /**
     * Constructor for an empty DoublyLinkedList.
     */
    public AllOperationDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns the number of nodes in the list.
     * @return The size of the list.
     */
    public int getSize() {
        return this.size;
    }

    // --- Insertion Operations ---

    /**
     * Inserts a new node at the beginning of the list.
     * @param data The data for the new node.
     */
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode; // If list is empty, new node is both head and tail
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        System.out.println(data + " inserted at the beginning.");
    }

    /**
     * Inserts a new node at the end of the list.
     * @param data The data for the new node.
     */
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode; // If list is empty, new node is both head and tail
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        System.out.println(data + " inserted at the end.");
    }
    
    /**
     * Inserts a new node at a specified position.
     * Position is 1-based.
     * @param data The data for the new node.
     * @param position The position where the node should be inserted.
     */
    public void insertAtPosition(int data, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position. Position should be between 1 and " + (size + 1));
            return;
        }
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }
        if (position == size + 1) {
            insertAtEnd(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        // Traverse to the node just before the target position
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next.prev = newNode;
        current.next = newNode;
        newNode.prev = current;
        size++;
        System.out.println(data + " inserted at position " + position + ".");
    }

    // --- Deletion Operations ---

    /**
     * Deletes the node from the beginning of the list.
     */
    public void deleteFromBeginning() {
        if (isEmpty()) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        
        int deletedData = head.data;
        if (head == tail) { // Only one node in the list
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        System.out.println(deletedData + " deleted from the beginning.");
    }

    /**
     * Deletes the node from the end of the list.
     */
    public void deleteFromEnd() {
        if (isEmpty()) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }

        int deletedData = tail.data;
        if (head == tail) { // Only one node in the list
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        System.out.println(deletedData + " deleted from the end.");
    }
    
    /**
     * Deletes a node by its value. Deletes the first occurrence.
     * @param data The value of the node to be deleted.
     */
    public void deleteByValue(int data) {
        if (isEmpty()) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }

        Node current = head;
        // Find the node with the given data
        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Value " + data + " not found in the list.");
            return;
        }
        
        // If the node to be deleted is the head
        if (current == head) {
            deleteFromBeginning();
        } 
        // If the node to be deleted is the tail
        else if (current == tail) {
            deleteFromEnd();
        } 
        // If the node is in the middle
        else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
            System.out.println(data + " deleted from the list.");
        }
    }


    // --- Traversal and Display Operations ---

    /**
     * Displays the list from head to tail.
     */
    public void displayForward() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("List (Forward): head -> ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /**
     * Displays the list from tail to head.
     */
    public void displayBackward() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("List (Backward): tail -> ");
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }
    
    // --- Main method for user interaction ---

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AllOperationDoublyLinkedList list = new AllOperationDoublyLinkedList();
        int choice, data, position;

        while (true) {
            System.out.println("\n--- Doubly Linked List Operations ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at a Specific Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete by Value");
            System.out.println("7. Display Forward");
            System.out.println("8. Display Backward");
            System.out.println("9. Get List Size");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert: ");
                    data = scanner.nextInt();
                    list.insertAtBeginning(data);
                    break;
                case 2:
                    System.out.print("Enter data to insert: ");
                    data = scanner.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 3:
                    System.out.print("Enter data to insert: ");
                    data = scanner.nextInt();
                    System.out.print("Enter position (1-based): ");
                    position = scanner.nextInt();
                    list.insertAtPosition(data, position);
                    break;
                case 4:
                    list.deleteFromBeginning();
                    break;
                case 5:
                    list.deleteFromEnd();
                    break;
                case 6:
                    System.out.print("Enter value to delete: ");
                    data = scanner.nextInt();
                    list.deleteByValue(data);
                    break;
                case 7:
                    list.displayForward();
                    break;
                case 8:
                    list.displayBackward();
                    break;
                case 9:
                    System.out.println("Current list size: " + list.getSize());
                    break;
                case 10:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return; // Exit the main method
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 10.");
            }
        }
    }
}
