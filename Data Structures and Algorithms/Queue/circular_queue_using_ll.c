#include <stdio.h>
#include <stdlib.h>
struct node
{
    int data;
    struct node *next;
} *front = NULL, *rear = NULL;
int isEmpty()
{
    if (front == NULL)
    {
        printf("Queue is Empty\n");

        return 1;
    }
    else
        return 0;
}
int isFull()
{
    struct node *t = (struct node *)malloc(sizeof(struct node));
    if (t == NULL)
    {
        printf("Queue is full\n");
        return 1;
    }
    else
    {
        free(t);
        return 0;
    }
}
void enqueue(int data)
{
    struct node *t;
    t = (struct node *)malloc(sizeof(struct node));

    if (t == NULL)
    {
        printf("Queue is full\n");
    }
    else
    {
        t->data = data;
        t->next = NULL;
        if (front == NULL)
        {
            front = rear = t;
        }
        else
        {
            rear->next = t;
            rear = t;
        }
    }
}
int dequeue()
{
    int data = -1;
    struct node *q;
    if (!isEmpty())
    {
        data = front->data;
        q = front;

        front = front->next;
        free(q);
    }
    return data;
}

void Display()
{
    struct node *t = front;
    while (t != NULL)
    {
        printf("%d ", t->data);
        t = t->next;
    }
    printf("\n");
}
int main(int argc, char const *argv[])
{
    enqueue(1);
    enqueue(2);
    enqueue(3);
    enqueue(4);
    enqueue(5);
    enqueue(6);
    enqueue(7);
    enqueue(8);
    Display();
    printf("\n");
    dequeue();
    dequeue();
    enqueue(7);
    dequeue();
    dequeue();
    Display();

    return 0;
}
