public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        // Adding elements to the circular linked list
        list.addAtStart("Alice");
        list.addAtStart("Bob");
        list.addAtStart("Charlie");

        System.out.println("Original list:");
        list.display();

        // Rotate the list
        System.out.println("\nAfter one rotation:");
        list.rotate();
        list.display();

        // Rotate again
        System.out.println("\nAfter another rotation:");
        list.rotate();
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
            tail.next = newNode; // Update tail's next to the new node
        }
        size++;
    }

    // Rotate the list to the right by one node
    public void rotate() {
        // Check if the list is empty or has only one node
        if (tail == null || tail.next == tail) {
            System.out.println("Rotation not needed. List is empty or has only one node.");
            return;
        }

        // Move the tail pointer one step forward
        tail = tail.next;
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
