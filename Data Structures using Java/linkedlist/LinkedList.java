package linkedlist;

public class LinkedList {

    private Node start;
    private Node last;
    private int length;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // public void add(int data) {
    // Node node = new Node(data);
    // if (start == null) {
    // start = node;
    // } else {
    // Node temp = start;
    // while (temp.next != null) {
    // temp = temp.next;
    // }
    // temp.next = node;
    // }
    // }
    public void add(int data) {
        Node node = new Node(data);
        if (start == null) {
            start = node;
            this.length++;
            last = start;
        } else {
            last.next = node;
            this.length++;
            last = last.next;

        }
    }

    public int remove(int index) {
        int result = -1;
        if (index > this.length - 1 || index < 0) {
            return -1;
        } else if (index == 0) {
            if (start == null) {
                return -1;
            } else {
                result = start.data;
                start = start.next;

            }
        } else {
            Node temp = start;
            Node prev = start;
            int i = 0;
            while (i < index) {
                prev = temp;
                temp = temp.next;
                i++;
            }
            result = temp.data;
            prev.next = temp.next;
        }
        return result;
    }

    public void add(int pos, int data) {
        Node n = new Node(data);
        if (pos > this.length || pos < 0)
            System.out.println("Invalid Position.");
        else {
            if (pos == 0) {
                n.next = start;
                start = n;
                this.length++;
            } else {
                int i = 0;
                Node temp = start;
                Node prev = start;
                while (i < pos) {
                    prev = temp;
                    temp = temp.next;
                    i++;

                }
                n.next = temp;
                prev.next = n;
                this.length++;
            }
        }
    }

    public void traverse() {
        String result = "[";
        Node temp = start;
        int data;
        while (temp != null) {
            data = temp.data;
            if (temp.equals(start)) {
                result += data;
            } else {
                result += ", " + data;

            }
            temp = temp.next;
        }
        result += "]";
        System.out.println(result);
    }
}
