package circularlinkedlist;

public class CircularLinkedListMain {

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.add(10);
        cll.add(20);
        cll.add(30);
        cll.add(40);
        cll.add(50);
        cll.add(60);
        System.out.println(cll.remove(60));
        cll.traverse();

    }
}
