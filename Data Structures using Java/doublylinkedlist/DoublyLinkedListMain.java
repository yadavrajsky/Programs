package doublylinkedlist;

public class DoublyLinkedListMain {

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.add(10);
        dll.add(20);
        dll.add(30);
        dll.add(40);
        dll.add(50);
        dll.delete(10);
        System.out.println(dll.delete(50));
        System.out.println("Length of DLL is " + dll.length());
        dll.traverse();
        dll.reverseTraverse();

    }
}
