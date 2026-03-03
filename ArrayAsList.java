public class ArrayAsList {

    // Data Members
    private int size;
    private int arr[];
    private int arr2[] = { 15, 25, 35, 45, 55 };
    private int arr3[];
    private int idx;

    // Default Constructor
    public ArrayAsList() {
        this.size = 6;
        this.arr = new int[size];
        this.idx = -1;
    }

    // Parameterized Constructor
    public ArrayAsList(int capacity) {
        this.size = capacity;
        this.arr = new int[size];
        this.idx = -1;
    }

    // Add at Last
    public void addAtLast(int data) {
        if (this.size - 1 == this.idx) {
            System.out.println("Array is Full");
            return;
        }
        this.arr[++this.idx] = data;
        System.out.println(data + " added at last");
    }

    // Add at Beginning
    public void addAtBegin(int data) {
        if (this.size - 1 == this.idx) {
            System.out.println("Array is Full");
            return;
        }

        this.idx++;
        for (int i = this.idx; i > 0; i--) {
            this.arr[i] = this.arr[i - 1];
        }
        this.arr[0] = data;

        System.out.println(data + " added at beginning");
    }

    // Add at Position
    public void addAtPosition(int data, int pos) {
        if (this.size - 1 == this.idx) {
            System.out.println("Array is Full");
            return;
        }

        if (pos < 1 || pos > this.idx + 2) {
            System.out.println("Invalid Position");
            return;
        }

        this.idx++;
        for (int i = this.idx; i > pos - 1; i--) {
            this.arr[i] = this.arr[i - 1];
        }

        this.arr[pos - 1] = data;
        System.out.println(data + " added at position " + pos);
    }

    // Delete from End
    public void deleteFromEnd() {
        if (this.idx == -1) {
            System.out.println("Array is Empty");
            return;
        }

        int deleted = this.arr[this.idx--];
        System.out.println("Deleted from end: " + deleted);
    }

    // Delete from Beginning
    public void deleteFromBegin() {
        if (this.idx == -1) {
            System.out.println("Array is Empty");
            return;
        }

        int deleted = this.arr[0];
        for (int i = 0; i < this.idx; i++) {
            this.arr[i] = this.arr[i + 1];
        }
        this.idx--;

        System.out.println("Deleted from beginning: " + deleted);
    }

    // Delete from Position
    public void deleteFromPosition(int pos) {
        if (this.idx == -1) {
            System.out.println("Array is Empty");
            return;
        }

        if (pos < 1 || pos > this.idx + 1) {
            System.out.println("Invalid Position");
            return;
        }

        int deleted = this.arr[pos - 1];

        for (int i = pos - 1; i < this.idx; i++) {
            this.arr[i] = this.arr[i + 1];
        }
        this.idx--;

        System.out.println("Deleted from position " + pos + ": " + deleted);
    }

    // Search
    public void search(int key) {
        if (this.idx == -1) {
            System.out.println("Array is Empty");
            return;
        }

        for (int i = 0; i <= this.idx; i++) {
            if (this.arr[i] == key) {
                System.out.println("Element found at index " + i);
                return;
            }
        }
        System.out.println("Element not found");
    }

    // Display
    public void display() {
        if (this.idx == -1) {
            System.out.println("Array is Empty");
            return;
        }

        System.out.print("Array Elements: ");
        for (int i = 0; i <= this.idx; i++) {
            System.out.print(this.arr[i] + " | ");
        }
        System.out.println();
    }

    // Size
    public void size() {
        System.out.println("Capacity of Array: " + this.size);
    }

    // Merge
    public void merge() {
        this.arr3 = new int[this.arr.length + this.arr2.length];

        for (int i = 0; i < this.arr.length; i++) {
            this.arr3[i] = this.arr[i];
        }

        for (int i = 0; i < this.arr2.length; i++) {
            this.arr3[i + this.arr.length] = this.arr2[i];
        }

        System.out.print("Merged Array: ");
        for (int i = 0; i < this.arr3.length; i++) {
            System.out.print(this.arr3[i] + " | ");
        }
        System.out.println();
    }

    // Sorted Merge (Bubble Sort)
    public void sortedMerge() {

        this.arr3 = new int[this.arr.length + this.arr2.length];

        for (int i = 0; i < this.arr.length; i++) {
            this.arr3[i] = this.arr[i];
        }

        for (int i = 0; i < this.arr2.length; i++) {
            this.arr3[i + this.arr.length] = this.arr2[i];
        }

        for (int i = 0; i < this.arr3.length - 1; i++) {
            for (int j = 0; j < this.arr3.length - i - 1; j++) {
                if (this.arr3[j] > this.arr3[j + 1]) {
                    int temp = this.arr3[j];
                    this.arr3[j] = this.arr3[j + 1];
                    this.arr3[j + 1] = temp;
                }
            }
        }

        System.out.print("Sorted Merged Array: ");
        for (int i = 0; i < this.arr3.length; i++) {
            System.out.print(this.arr3[i] + " | ");
        }
        System.out.println();
    }

    // Reverse
    void reverse() {
        if (idx == -1) {
            System.out.println("Array is Empty");
            return;
        }

        System.out.print("Reversed Array: ");
        for (int i = idx; i >= 0; i--) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }

    // Sum
    int sumOfAllElements() {
        int sum = 0;

        if (idx == -1) {
            System.out.println("Array is Empty");
            return 0;
        }

        for (int i = 0; i <= idx; i++) {
            sum += arr[i];
        }

        return sum;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        ArrayAsList list = new ArrayAsList();

        list.size();

        list.addAtLast(5);
        list.addAtLast(15);
        list.addAtLast(25);
        list.display();

        list.addAtBegin(1);
        list.display();

        list.addAtPosition(99, 3);
        list.display();

        list.deleteFromEnd();
        list.display();

        list.deleteFromBegin();
        list.display();

        list.deleteFromPosition(2);
        list.display();

        list.search(25);

        list.reverse();

        System.out.println("Sum of elements: " + list.sumOfAllElements());

        list.merge();
        list.sortedMerge();
    }
}
