package tree;

import tree.BinarySearchTree.Node;

public class Stack {
    private Node[] stack;
    private int top = -1;

    public Stack() {
        stack = new Node[10];
    }

    public void push(Node data) {
        try {
            stack[++top] = data;
        } catch (ArrayIndexOutOfBoundsException e) {
            top--;
            System.out.println("Stack Overflow");
        }
    }

    public Node pop() {
        Node temp = null;
        try {
            temp = stack[top--];
        } catch (Exception e) {
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
