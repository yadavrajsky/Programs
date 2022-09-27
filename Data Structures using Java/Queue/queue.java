class Queue
{
    int []arr;
    int front;
    int rear;
    public Queue()
    {
        arr=new int[5];
        front=-1;
        rear=-1;
    }
    public void enQueue(int data)
    {
        if(rear==arr.length-1)
        {
            System.out.println("Overflow");
        }
        else
        {
            if(front==-1)
            {
                front++;
            }
            rear++;
        }

    }
    public int deQueue()
    {
        int data;
         if(front==-1)
         {
            System.out.println("Empty Queue");
            return -1;
         }
         else
         {
        data=arr[front];
        if(front==rear)
            {
                front=rear=-1;
            }
            front++;

         }
         return data;
    }
    public boolean isEmpty()
    {
        return front==-1;
    }
}
