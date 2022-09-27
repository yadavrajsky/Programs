public class QueueMain {
    public static void main(String[] args) {
        Queue q=new Queue();
        System.out.println(q.isEmpty());
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        q.enQueue(6);
        q.isEmpty();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.isEmpty();

    }
}
