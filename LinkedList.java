class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {

    Node head;

    // Add at Beginning
    void addNodeAtBegin(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Add at End
    void addNodeAtEnd(int data) {
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
    }

    // Add at Position
    void addNodeAtPosition(int data, int pos) {

        if (pos == 0) {
            addNodeAtBegin(data);
            return;
        }

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

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Display
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

    // Reverse Print (Recursive)
    void reverse(Node node) {
        if (node == null)
            return;

        reverse(node.next);
        System.out.print(node.data + " | ");
    }

    // Delete at Begin
    int deleteAtBegin() {
        if (head == null)
            return -1;

        int data = head.data;
        head = head.next;
        return data;
    }

    // Delete at End
    int deleteAtEnd() {

        if (head == null)
            return -1;

        if (head.next == null) {
            int data = head.data;
            head = null;
            return data;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        int data = temp.next.data;
        temp.next = null;
        return data;
    }

    // Delete at Position
    int deleteAtPosition(int pos) {

        if (head == null)
            return -1;

        if (pos == 0)
            return deleteAtBegin();

        Node temp = head;
        int count = 0;

        while (temp.next != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }

        if (temp.next == null) {
            System.out.println("Invalid Position");
            return -1;
        }

        int data = temp.next.data;
        temp.next = temp.next.next;
        return data;
    }

    // Merge Two Lists
    void mergeTwoList(LinkedList list2) {

        if (head == null) {
            head = list2.head;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = list2.head;
    }

    // Modify at Begin
    void modifyNodeAtBegin(int data) {
        if (head != null)
            head.data = data;
    }

    // Modify at End
    void modifyNodeAtEnd(int data) {
        if (head == null)
            return;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.data = data;
    }

    // Modify at Position
    void modifyAtAnyPosition(int data, int pos) {

        Node temp = head;
        int count = 0;

        while (temp != null && count < pos) {
            temp = temp.next;
            count++;
        }

        if (temp != null)
            temp.data = data;
        else
            System.out.println("Invalid Position");
    }

    // Modify Existing Key
    void modifyExistingWithNewKey(int oldKey, int newKey) {

        Node temp = head;

        while (temp != null) {
            if (temp.data == oldKey) {
                temp.data = newKey;
                return;
            }
            temp = temp.next;
        }

        System.out.println("Key not found");
    }

    // Search
    boolean search(int key) {

        Node temp = head;

        while (temp != null) {
            if (temp.data == key)
                return true;

            temp = temp.next;
        }

        return false;
    }

    // MAIN
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.addNodeAtBegin(432);
        list.addNodeAtBegin(89);
        list.addNodeAtEnd(1205);
        list.addNodeAtEnd(777);
        list.addNodeAtPosition(9999, 2);

        System.out.println("Initial List:");
        list.display();

        list.modifyNodeAtBegin(55);
        list.modifyNodeAtEnd(8080);
        list.modifyAtAnyPosition(3333, 1);
        list.modifyExistingWithNewKey(1205, 4444);

        System.out.println("After Modification:");
        list.display();

        System.out.println("Search 4444: " + list.search(4444));

        System.out.println("Deleted from Begin: " + list.deleteAtBegin());
        System.out.println("Deleted from End: " + list.deleteAtEnd());
        System.out.println("Deleted from Position 1: " + list.deleteAtPosition(1));

        list.display();

        System.out.println("Reverse Print:");
        list.reverse(list.head);
        System.out.println();

        // Merge Example
        LinkedList list2 = new LinkedList();
        list2.addNodeAtBegin(600);
        list2.addNodeAtEnd(700);

        list.mergeTwoList(list2);

        System.out.println("After Merging:");
        list.display();
    }
}
