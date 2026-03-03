public class Circularque {

    int size;
    int[] queue;
    int fIdx;
    int rIdx;

    // Constructor
    public Circularque() {
        this.size = 6;
        this.queue = new int[size];
        this.fIdx = -1;
        this.rIdx = -1;
    }

    // Enqueue Method
    void enqueue(int data) {

        if ((rIdx + 1) % size == fIdx) {
            System.out.println("Queue is Full");
            return;
        }

        if (fIdx == -1) {
            fIdx = rIdx = 0;
        } else {
            rIdx = (rIdx + 1) % size;
        }

        queue[rIdx] = data;
        System.out.println(data + " inserted");
    }

    // Dequeue Method
    void dequeue() {

        if (fIdx == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        int data = queue[fIdx];

        if (fIdx == rIdx) {
            fIdx = rIdx = -1;
        } else {
            fIdx = (fIdx + 1) % size;
        }

        System.out.println("Deleted element: " + data);
    }

    // Display Method
    void display() {

        if (fIdx == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Queue: ");

        int i = fIdx;

        do {
            System.out.print(queue[i] + " | ");
            i = (i + 1) % size;
        } while (i != (rIdx + 1) % size);

        System.out.println();
    }

    // MAIN METHOD
    public static void main(String[] args) {

        Circularque obj = new Circularque();

        // Random-type 2, 3, 4 digit numbers
        obj.enqueue(47);
        obj.enqueue(893);
        obj.enqueue(1205);
        obj.enqueue(76);
        obj.enqueue(4512);

        obj.display();

        obj.dequeue();
        obj.display();

        obj.enqueue(339);
        obj.enqueue(8888);

        obj.display();

        obj.dequeue();
        obj.display();
    }
}
