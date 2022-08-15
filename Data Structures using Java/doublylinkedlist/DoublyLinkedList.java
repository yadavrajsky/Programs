package doublylinkedlist;

public class DoublyLinkedList {

    private Node start;
    private Node last;
    private int length;

    private class Node {

        private int data;
        private Node prev;
        private Node next;

        Node(int data) {
            this.data = data;
            length++;
        }
    }

    public void add(int data) {
        Node node = new Node(data);
        if (start == null) {
            start = last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
    }

    public void traverse() {
        Node temp = start;
        if (temp == null) {
            System.out.println("[]");
        } else {
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }

    public void reverseTraverse() {
        Node temp = last;
        if (temp == null) {
            System.out.println("[]");
        } else {
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.prev;
            }
        }
    }

    public int delete(int data) {
        int index = -1;
        Node temp = start;
        if (temp == null) {
            return -1;
        } else {
            do {
                index++;
                if (temp.data == data) {
                    if (temp.prev == null) { //First node
                        start = temp.next;
                        if (temp.next != null) {   //Checking only one node
                            temp.next.prev = null;
                        } else {
                            last = start;
                        }
                    } else if (temp.next == null) { //Last node
                        temp.prev.next = null;
                        last = temp.prev;
                    } else {  //In between deletion
                        temp.prev.next = temp.next;
                        temp.next.prev = temp.prev;
                    }
                    length--;
                    return index;
                }
                temp = temp.next;
            } while (temp != null);
            return -1;
        }
    }

    public int length() {
        return length;
    }
}
