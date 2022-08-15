package stack;

//import java.util.Arrays;
public class Stack {

    private int[] stack;
    private int top = -1;

    public Stack() {
        stack = new int[5];
    }

    public void push(int data) {
        try {
            stack[++top] = data;
        } catch (ArrayIndexOutOfBoundsException e) {
            top--;
            System.out.println("Stack Overflow");
//           stack=Arrays.copyOf(stack, stack.length*2);
//           stack[top]=data;
        }
    }

    public int pop() {
        int temp = -1;
        try {
            temp = stack[top--];
        } catch (Exception e) {
//          System.out.println("Stack Underflow");
            top++;
        } finally {
            return temp;
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}
