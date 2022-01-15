#include <stdio.h>
#include <stdlib.h>
struct queue
{
    int size;
    int front;
    int rear;
    int *q;
};
void create_queue(struct queue *Q, int size)
{
    Q->size = size;
    Q->front = Q->rear = 0;
    Q->q = (int *)malloc((size) * sizeof(int));
}
int isEmpty(struct queue *Q)
{
    if (Q->rear == Q->front)
    {
        printf("Queue is Empty\n");

        return 1;
    }
    else
        return 0;
}
int isFull(struct queue *Q)
{
    if ((Q->rear+1)%Q->size==Q->front)
    {
        printf("Queue is full\n");

        return 1;
    }
    else
        return 0;
}
void enqueue(struct queue *Q, int value)
{
    if (!isFull(Q))
    {
        Q->rear=(Q->rear+1)%Q->size;
        Q->q[Q->rear] = value;

    }
}
int dequeue(struct queue *Q)
{
    int value = -1;
    if (!isEmpty(Q))
    {
        Q->front=(Q->front+1)%Q->size;
        value = Q->q[Q->front];

    }
    return value;
}

void Display(struct queue Q)
{

int i=Q.front+1;
do
{
    printf("%d\n",Q.q[i]);
    i=(i+1)%Q.size;
} while (i!=(Q.rear+1)%Q.size);
    
}
int main(int argc, char const *argv[])
{
    struct queue q;
    create_queue(&q, 7);
    enqueue(&q,1);
    enqueue(&q,2);
    enqueue(&q,3);
    enqueue(&q,4);
    enqueue(&q,5);
    enqueue(&q,6);
    enqueue(&q,7);
    enqueue(&q,8);
    Display(q);
    printf("\n");
    dequeue(&q);
    dequeue(&q);
    enqueue(&q,7);
    dequeue(&q);
    dequeue(&q);
    Display(q);


    return 0;
}
