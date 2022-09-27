

 class CircularQueueMain {
public static void main(String[] args) {
    CircularQueue  cq=new CircularQueue();
    cq.enQueue(1);
    cq.enQueue(2);
    cq.enQueue(3);
    cq.enQueue(4);
    cq.enQueue(5);
    cq.enQueue(6);
    System.out.println(cq.deQueue());
    System.out.println(cq.deQueue());
    System.out.println(cq.deQueue());
    System.out.println(cq.deQueue());
    System.out.println(cq.deQueue());
    System.out.println(cq.deQueue());
    

}    
}
