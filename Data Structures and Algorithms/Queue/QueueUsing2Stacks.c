#include <stdio.h>
#include <stdlib.h>
#include <string.h>
struct stack
{
    int size;
    int top;
    int *S;
};
int isFull(struct stack *s)
{
    if (s->top == s->size - 1)
        return 1;
    return 0;
}
int isEmpty(struct stack *s)
{
    if (s->top == -1)
        return 1;
    return 0;
}
void create(struct stack *s, int size)
{
    int i;
    s->top = -1;
    s->S = (int *)malloc(size * sizeof(int));
}
int peek(struct stack *st, int index)
{
    if (index <= -1 || index > st->top)
        return -1;
    else
        return st->S[index];
}
void push(struct stack *s, int value)
{
    if (s->top == s->size - 1)
        printf("Overflow\n");
    else
    {
        s->top++;
        s->S[s->top] = value;
    }
}
int pop(struct stack *s)
{
    int x = -1;
    if (s->top == -1)
    {
        printf("Underflow\n");
        return x;
    }
    else
    {
        x = s->S[s->top];
        s->top--;
    }
    return x;
}
void enqueue(struct stack *s, int x)
{
    push(s, x);
}
int dequeue(struct stack *s1, struct stack *s2)
{
    int x = -1;
    if (isEmpty(s2))
    {
        if (isEmpty(s1))
        {
            printf("Stack underflow\n");
            return x;
        }
        else
        {
            while (!isEmpty(s1))
            {
                push(s2, pop(s1));
            }
        }
    }
    else
    {
        x = pop(s2);
    }
    return x;
}
int main(int argc, char const *argv[])
{
    int A[] = {1, 2, 3, 4, 5};
    struct stack s1, s2;
    create(&s1, 5);
    create(&s2, 5);
    push(&s1, A[0]);
    push(&s1, A[1]);
    push(&s1, A[2]);
    push(&s2, A[3]);
    push(&s2, A[4]);
    printf("%d\n", dequeue(&s1, &s2));
    printf("%d\n", dequeue(&s1, &s2));
    printf("%d\n", dequeue(&s1, &s2));
    printf("%d\n", dequeue(&s1, &s2));
    printf("%d\n", dequeue(&s1, &s2));
    printf("%d\n", dequeue(&s1, &s2));
    printf("%d\n", dequeue(&s1, &s2));

    return 0;
}
