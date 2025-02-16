/**
 * Date Started: 2nd of February 2025
 * Author: Ipule Pipi
 * Description: Implementation of Circular Linked List
 * Key Note:
 * Circular linked just need a tail pointer or reference
 * Instead of having tail to null, we set it to point back to the head
 */

public class CircularLinkedList {
    int size;
    Node tail;

    // Node class
    public class Node {
        int data;
        Node next;

        // node constructor
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public CircularLinkedList() {
        this.size = 0;
        this.tail = null;
    }

    // Method for adding element at head
    public void addAtFirst(int data) {
        Node newNode = new Node(data, null);
        if (size == 0) {
            tail = newNode;
            tail.next = tail;
        } else {

            newNode.next = tail.next;
            tail.next = newNode;
        }
        size++;
    }

    public void printList() {
        // Handle empty list
        if (tail == null) {
            System.out.println("null");
            return;
        }

        Node current = tail.next; // Start at head (tail.next)
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != tail.next); // Stop when we get back to head

        System.out.println("null"); // Optional, since it's circular
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.addAtFirst(10);
        circularLinkedList.addAtFirst(20);
        circularLinkedList.addAtFirst(30);

        circularLinkedList.printList();
    }
}