class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoubleLinkedList {

    Node head;

    // Add at Beginning
    public void addNodeAtBegin(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add at End
    public void addAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Add at Position
    void addAtPos(int data, int pos) {

        if (pos == 0) {
            addNodeAtBegin(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int count = 0;

        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;
    }

    // Display Forward
    void display() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " | ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Display Reverse
    void displayRev() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != null) {
            System.out.print(temp.data + " | ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // Delete from Beginning
    int deleteFromBegin() {

        if (head == null)
            return -1;

        int data = head.data;

        if (head.next == null) {
            head = null;
            return data;
        }

        head = head.next;
        head.prev = null;

        return data;
    }

    // Delete from End
    int deleteFromEnd() {

        if (head == null)
            return -1;

        Node temp = head;

        if (temp.next == null) {
            int data = temp.data;
            head = null;
            return data;
        }

        while (temp.next != null) {
            temp = temp.next;
        }

        int data = temp.data;
        temp.prev.next = null;

        return data;
    }

    // Delete from Position
    int deleteFromPos(int pos) {

        if (head == null)
            return -1;

        if (pos == 0)
            return deleteFromBegin();

        Node temp = head;
        int count = 0;

        while (temp != null && count < pos) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return -1;
        }

        int data = temp.data;

        if (temp.next != null)
            temp.next.prev = temp.prev;

        if (temp.prev != null)
            temp.prev.next = temp.next;

        return data;
    }

    // Search by Value
    void search(int key) {

        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        Node temp = head;
        int index = 0;

        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Element found at index: " + index);
                return;
            }
            temp = temp.next;
            index++;
        }

        System.out.println("Element not found");
    }

    // Count Nodes
    int countNode() {

        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        DoubleLinkedList list = new DoubleLinkedList();

        list.addNodeAtBegin(345);
        list.addNodeAtBegin(78);
        list.addAtEnd(999);
        list.addAtEnd(1204);
        list.addAtPos(5678, 2);

        System.out.println("Forward Display:");
        list.display();

        System.out.println("Reverse Display:");
        list.displayRev();

        System.out.println("Deleted from Begin: " + list.deleteFromBegin());
        System.out.println("Deleted from End: " + list.deleteFromEnd());
        System.out.println("Deleted from Position 1: " + list.deleteFromPos(1));

        list.display();

        list.search(345);

        System.out.println("Total Nodes: " + list.countNode());
    }
}
