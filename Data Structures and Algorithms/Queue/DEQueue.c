#include <stdio.h>
#include <stdlib.h>
struct queue
{
    int size;
    int front;
    int rear;
    int *q;
};
int isFull(struct queue *Q)
{
    if (Q->rear == Q->size - 1)
    {
        return 1;
    }
    return 0;
}
int isEmpty(struct queue *Q)
{
    if (Q->front == Q->rear)
        return 1;
    else
        return 0;
}
void create_DEQueue(struct queue *Q, int size)
{
    Q->size = size;
    Q->front = Q->rear = -1;
    Q->q = (int *)malloc(size * sizeof(int));
}

void enqueueRear(struct queue *Q, int value)
{
    if (isFull(Q))
        printf("DEQ Overflow.\n");
    else
    {
        Q->rear++;
        Q->q[Q->rear] = value;
    }
}

void enqueueFront(struct queue *Q, int value)
{
    if (Q->front == -1)
        printf("DEQueue Overflow\n");
    else
    {
        Q->front++;
        Q->q[Q->front] = value;
    }
}
int dequeueFront(struct queue *Q)
{
    int value = -1;
    if (isEmpty(Q))
        printf("DEQ Underflow\n");
    else
    {
        Q->front++;
        value = Q->q[Q->front];
    }

    return value;
}
int dequeueRear(struct queue *Q)
{
    int value = -1;
    if (isEmpty(Q))
        printf("DEQ Underflow\n");

    else
    {
        value = Q->q[Q->rear];
        Q->rear--;
    }

    return value;
}
void Display(struct queue Q)
{
    int i;
    for (i = Q.front + 1; i <= Q.rear; i++)
    {
        printf("%d\n", (Q.q[i]));
    }
    printf("\n");
}
int main(int argc, char const *argv[])
{
    struct queue q;
    create_DEQueue(&q, 7);
    enqueueRear(&q, 1);
    enqueueRear(&q, 2);
    enqueueRear(&q, 3);
    Display(q);
    printf("De: ");
    printf("%d\n", dequeueRear(&q));
    enqueueFront(&q, 2);
    Display(q);
    // dequeueFront(&q);
    // dequeueFront(&q);
    dequeueRear(&q);
    Display(q);

    return 0;
}
