package linkedlist;

public class LinkedListDS {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);
        ll.add(0, 5);
        ll.add(5, 25);
        // ll.remove(3);
        ll.traverse();

    }

}
