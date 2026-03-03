public class StackAsList {

    private int size;
    private int[] stack;
    private int top;

    public StackAsList() {
        this.size = 6;
        this.stack = new int[size];
        this.top = -1;
    }

    // Check Overflow
    public boolean stackOverFlow() {
        return top == size - 1;
    }

    // Check Underflow
    public boolean stackUnderFlow() {
        return top == -1;
    }

    // Push Operation
    public void push(int data) {

        if (stackOverFlow()) {
            System.out.println("Stack Overflow");
            return;
        }

        stack[++top] = data;
        System.out.println(data + " pushed into stack");
    }

    // Pop Operation
    public void pop() {

        if (stackUnderFlow()) {
            System.out.println("Stack Underflow");
            return;
        }

        System.out.println("Popped element: " + stack[top--]);
    }

    // Peek Operation
    public int peek() {

        if (stackUnderFlow()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        return stack[top];
    }

    // Display Stack
    public void display() {

        if (stackUnderFlow()) {
            System.out.println("Stack is Empty");
            return;
        }

        System.out.println("\nStack Elements (Top to Bottom):");

        for (int i = top; i >= 0; i--) {
            System.out.println("| " + stack[i] + " |");
        }
    }

    public static void main(String[] args) {

        StackAsList stack = new StackAsList();

        stack.push(345);
        stack.push(89);
        stack.push(1205);
        stack.push(777);
        stack.push(4512);

        stack.display();

        System.out.println("\nTop Element: " + stack.peek());

        stack.pop();
        stack.display();

        stack.pop();
        stack.display();

        System.out.println("\nIs Stack Empty? " + stack.stackUnderFlow());
        System.out.println("Is Stack Full? " + stack.stackOverFlow());
    }
}
