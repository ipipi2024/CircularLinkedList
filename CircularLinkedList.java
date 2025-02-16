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

    //method for adding last
    public void addAtLast(int data) {
        Node newNode = new Node(data, null);
        if(size == 0) {
            tail = newNode;
            tail.next = tail;
        }else{
            newNode.next = tail.next; // point next of newnode to head
            tail.next = newNode; //prev tail point to newNode since it is now second last
            tail = newNode; //new tail to be at newNode
        }

        size++;
    }

    //method to removefirst
    public int removeFirst() {
        if(size == 0) {
            System.out.println("List is empty. Cannot remove");
            return -1;
        }

        int removedItem = tail.next.data;

        if (size == 1) {
            tail = null;
        }else{
            tail.next = tail.next.next;
        }

        size--;
        return removedItem;

    }

    //remove first
    public int removeLast() {
        if(size == 0) {
            System.out.println("List is empty. Cannot remove");
            return -1;
        }

        int removedItem = tail.data;

        if (size == 1) {
            tail = null;
        }else{
            Node currentNode = tail.next; //head node
            while (currentNode.next != tail) { //current
                currentNode = currentNode.next;
            }
            //current node is now the previous node to tail
            currentNode.next = tail.next; 
            tail = currentNode;
        }
        size--;
        return removedItem;

    }

    //method to rotate list
    public void rotate () {
        if (size <= 1) {
            //essentially nothing to rotate
            return;
        }
        //just set tail to the next of tail 
        //so head begins becomes tail
        //there tail becomes head
        tail = tail.next;
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
        circularLinkedList.rotate();
        circularLinkedList.printList();
        circularLinkedList.rotate();
        circularLinkedList.printList();
        
      
        

    }
}