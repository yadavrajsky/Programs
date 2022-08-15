package circularlinkedlist;

public class CircularLinkedList {

    private Node start;
    private Node last;
    private int length;

    private class Node {

        private int data;
        Node next;

        Node(int data) {
            this.data = data;
            length++;
        }
    }

    public void traverse() {
        Node temp = start;
        if (temp == null) {
            System.out.println("[ ]");
        } else {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != start);
        }
    }

    public void add(int data) {
        Node n = new Node(data);
        if (this.start == null) {
            this.start = this.last = n;
        } else {
            last.next = n;
            last = n;
        }
        last.next = start;
    }

    public int remove(int data) {
        Node temp = start;
        Node prev = start;
        int index = 0;
        if (temp == null) {
            return -1;
        } else {
            do {
                if (temp.data == data) {
                    prev.next = temp.next;
                    index--;
                    return index + 1;
                }
                prev = temp;
                temp = temp.next;
                index++;
            } while (temp != start);
            return -1;
        }
    }
}
