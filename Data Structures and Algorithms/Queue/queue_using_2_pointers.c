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
    Q->front = Q->rear = -1;
    Q->q = (int *)malloc(size * sizeof(int));
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
    if (Q->rear == Q->size - 1)
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
        Q->rear++;
        Q->q[Q->rear] = value;

    }
}
int dequeue(struct queue *Q)
{
    int value = -1;
    if (!isEmpty(Q))
    {
        Q->front++;
        value = Q->q[Q->front];

    }
    return value;
}

void Display(struct queue Q)
{
    while (!isEmpty(&Q))
    {
        printf("%d\n",dequeue(&Q));
    }
    printf("\n");
    
}
int main(int argc, char const *argv[])
{
    struct queue q;
    create_queue(&q, 7);
    enqueue(&q,1);
    enqueue(&q,2);
    enqueue(&q,3);
    enqueue(&q,4);
    Display(q);
    printf("\n");
    dequeue(&q);
    dequeue(&q);
    dequeue(&q);
    // dequeue(&q);
    Display(q);


    return 0;
}
