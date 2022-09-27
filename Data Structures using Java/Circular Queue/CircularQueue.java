
class CircularQueue {
    int front;
    int rear;
    int queue[];

    public void enQueue(int data) {
        if (isOverflow()) {
            System.out.println("Queue Overflow");
        } else {
            if (isEmpty()) {
                front++;
            }
            rear = (rear+1) % queue.length;
            queue[rear] = data;
        }

    }

    public boolean isOverflow()
    {
        if(front==(rear+1)%queue.length)
        return true;
        return false;
    }
    CircularQueue() {
        queue = new int[5];
        front=rear=-1;
    }

    public boolean isEmpty() {
        if (front == -1) {
            return true;
        }
        return false;

    }

    public int deQueue() {

        int data = -1;
        if (isEmpty()) {
            System.out.println("Underflow");
        } else {

            data = queue[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % queue.length;
            }
        }
        return data;

    }
}
