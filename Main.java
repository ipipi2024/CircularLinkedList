public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        
        // Adding elements to the circular linked list
        list.addAtStart("Alice");
        list.addAtStart("Bob");
        list.addAtStart("Charlie");
        
        // Display the list
        list.display();
    }
}

class Node {
    String name;
    Node next;

    public Node(String name) {
        this.name = name;
        this.next = null;
    }
}

class CircularLinkedList {
    Node tail;
    int size;

    // Adding a node at the start
    public void addAtStart(String name) {
        Node newNode = new Node(name);
        // Check if the list is empty
        if (tail == null) {
            tail = newNode;
            tail.next = tail; // Point to itself to form a circular link
        } else {
            newNode.next = tail.next; // Point new node's next to the head
            tail.next = newNode;      // Update tail's next to the new node
        }
        size++;
    }

    // Display the list
    public void display() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        
        Node current = tail.next; // Start from the head
        do {
            System.out.print(current.name + " -> ");
            current = current.next;
        } while (current != tail.next); // Loop until we return to the head
        
        System.out.println("(back to " + tail.next.name + ")");
    }
}
