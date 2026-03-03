class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {

    Node head;

    // Add Node at End
    void addNodeAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // Add Node at Beginning
    void addNodeAtBegin(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
        head = newNode;
    }

    // Add Node at Position
    void addAtPos(int data, int pos) {
        Node newNode = new Node(data);

        if (head == null || pos == 0) {
            addNodeAtBegin(data);
            return;
        }

        Node temp = head;
        int count = 0;

        while (count < pos - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Display List
    void display() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(Back to Head)");
    }

    // Delete at Beginning
    int deleteAtBegin() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return -1;
        }

        if (head.next == head) {  // only one node
            int data = head.data;
            head = null;
            return data;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        int data = head.data;
        temp.next = head.next;
        head = head.next;

        return data;
    }

    // Delete at End
    int deleteAtEnd() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return -1;
        }

        if (head.next == head) {
            int data = head.data;
            head = null;
            return data;
        }

        Node temp = head;
        Node prev = null;

        while (temp.next != head) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = head;
        return temp.data;
    }

    // Delete at Position
    int deleteAtPos(int pos) {
        if (head == null) {
            System.out.println("Linked List is empty");
            return -1;
        }

        if (pos == 0) {
            return deleteAtBegin();
        }

        Node temp = head;
        Node prev = null;
        int count = 0;

        while (count < pos && temp.next != head) {
            prev = temp;
            temp = temp.next;
            count++;
        }

        if (count != pos) {
            System.out.println("Invalid Position");
            return -1;
        }

        prev.next = temp.next;
        return temp.data;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        CircularLinkedList cll = new CircularLinkedList();

        cll.addNodeAtEnd(116);
        cll.addNodeAtEnd(223);
        cll.addNodeAtEnd(33);
        cll.addNodeAtEnd(444);
        cll.addNodeAtEnd(553);

        cll.display();

        cll.addNodeAtBegin(5);
        cll.display();

        cll.addAtPos(99, 3);
        cll.display();

        System.out.println("Deleted at Begin: " + cll.deleteAtBegin());
        cll.display();

        System.out.println("Deleted at End: " + cll.deleteAtEnd());
        cll.display();

        System.out.println("Deleted at Position 2: " + cll.deleteAtPos(2));
        cll.display();
    }
}
