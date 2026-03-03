public class QueueAsList {

    int size;
    int[] queue;
    int fIdx;
    int rIdx;

    public QueueAsList() {
        this.size = 6;
        this.queue = new int[size];
        this.fIdx = -1;
        this.rIdx = -1;
    }

    // Check if Empty
    public boolean isEmpty() {
        return this.fIdx == -1 || fIdx > rIdx;
    }

    // Check if Full
    public boolean isFull() {
        return this.rIdx == this.size - 1;
    }

    // Enqueue
    public void enqueue(int data) {

        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }

        if (this.fIdx == -1) {
            this.fIdx = 0;
        }

        this.rIdx++;
        this.queue[this.rIdx] = data;

        System.out.println(data + " inserted into queue");
    }

    // Dequeue
    public void dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        int deleted = queue[fIdx];
        fIdx++;

        if (fIdx > rIdx) {
            fIdx = -1;
            rIdx = -1;
        }

        System.out.println("Deleted element: " + deleted);
    }

    // Get Front
    public int getFront() {

        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        return queue[fIdx];
    }

    // Get Rear
    public int getRear() {

        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        return queue[rIdx];
    }

    // Display
    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Queue: ");

        for (int i = fIdx; i <= rIdx; i++) {
            System.out.print(queue[i] + " | ");
        }

        System.out.println();
    }

    // MAIN METHOD
    public static void main(String[] args) {

        QueueAsList queue = new QueueAsList();

        queue.enqueue(345);
        queue.enqueue(89);
        queue.enqueue(1205);
        queue.enqueue(777);
        queue.enqueue(4512);

        queue.display();

        System.out.println("Front Element: " + queue.getFront());
        System.out.println("Rear Element: " + queue.getRear());

        queue.dequeue();
        queue.display();

        queue.dequeue();
        queue.display();

        queue.enqueue(9999);
        queue.display();

        System.out.println("Is Queue Empty? " + queue.isEmpty());
        System.out.println("Is Queue Full? " + queue.isFull());
    }
}
