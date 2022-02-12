#include <stdlib.h>
#include <stdio.h>
#include <conio.h>
//Queue



struct node
{
    struct node *lchild;
    int value;
    struct node *rchild;
};
struct queue
{
    int size;
    int front;
    int rear;
    struct node **q;
};

void create_queue(struct queue *Q, int size)
{
    Q->size = size;
    Q->front = Q->rear = 0;
    Q->q = (struct node **)malloc(size * sizeof(struct node *));
}
int isEmpty(struct queue *Q)
{
    if (Q->rear == Q->front)
    {

        return 1;
    }
    else
        return 0;
}
int isFull(struct queue *Q)
{
    if ((Q->rear + 1) % Q->size == Q->front)
    {
        return 1;
    }
    else
        return 0;
}
void enqueue(struct queue *Q, struct node *value)
{
    if (isFull(Q))
        printf("Queue is Full");
    else
    {
        Q->rear = (Q->rear + 1) % Q->size;
        Q->q[Q->rear] = value;
    }
}
struct node *dequeue(struct queue *Q)
{
    struct node *value = NULL;
    if (!isEmpty(Q))
    {
        Q->front = (Q->front + 1) % Q->size;
        value = Q->q[Q->front];
    }
    return value;
}


//Queue end


// Stack
struct stack
{
    int size;
    int top;
   struct node** S;
};
int isStackFull(struct stack *s)
{
     if (s->top == s->size - 1)
     return 1;
     return 0;
}
int isStackEmpty(struct stack *s)
{
    if (s->top == -1)
       return 1;
       return 0;
    
}
void Stackcreate(struct stack *s,int size)
{

    s->top = -1;
    s->S = (struct node**)malloc(size * sizeof(struct node*));
}
void push(struct stack *s, struct node* value)
{
    if (s->top == s->size - 1)
        printf("Overflow\n");
    else
    {
        s->top++;
        s->S[s->top] = value;
    }
}
struct node* pop(struct stack *s)
{
    struct node* x = NULL;
    if (s->top == -1)
    {
        printf("Underflow\n");
    }
    else
    {
        x = s->S[s->top];
        s->top--;
    }
    return x;
}
struct node* peek( struct stack *st,int index)
{
    if(index<=-1||index>st->top)
    return NULL;
    else
    return st->S[index];
}
//stack end
struct node *root = NULL;
void create_tree()
{
    struct node *p, *t;
    int x;
    struct queue Q;
    create_queue(&Q, 10);
    printf("Enter root value : ");
    scanf("%d", &x);
    root = (struct node *)malloc(sizeof(struct node));
    root->value = x;
    root->lchild = root->rchild = NULL;
    enqueue(&Q, root);
    while (!isEmpty(&Q))
    {
        p = dequeue(&Q);
        printf("Enter left child of %d : ", p->value);
        scanf("%d", &x);
        if (x != -1)
        {
            t = (struct node *)malloc(sizeof(struct node));
            t->value = x;
            t->lchild = t->rchild = NULL;
            p->lchild = t;
            enqueue(&Q, t);
        }
        printf("Enter right child of %d : ", p->value);
        scanf("%d", &x);
        if (x != -1)
        {
            t = (struct node *)malloc(sizeof(struct node));
            t->value = x;
            t->lchild = t->rchild = NULL;
            p->rchild = t;
            enqueue(&Q, t);
        }
    }
}
void preorder(struct node *t)
{
    if (t)
    {
        printf("%d ", t->value);
        preorder(t->lchild);
        preorder(t->rchild);
    }
}
void postorder(struct node *t)
{
    if (t)
    {
        postorder(t->lchild);
        postorder(t->rchild);
        printf("%d ", t->value);
    }
}
void inorder(struct node *t)
{
    if (t)
    {
        inorder(t->lchild);
        printf("%d ", t->value);
        inorder(t->rchild);
    }
}
void iterative_preorder(struct node *p)
{
    struct stack stk;
    Stackcreate(&stk, 50);
    while (p || !isStackEmpty(&stk))
    {
        if (p)
        {
            printf("%d ", p->value);
            push(&stk, p);
            p = p->lchild;
        }
        else
        {
            p = pop(&stk);
            p = p->rchild;
        }
    }
}
void iterative_inorder(struct node *p)
{
    struct stack stk;
    Stackcreate(&stk, 50);
    while (p || !isStackEmpty(&stk))
    {
        if (p)
        {
            push(&stk, p);
            p = p->lchild;
        }
        else
        {
            p = pop(&stk);
            printf("%d ", p->value);
            p = p->rchild;
        }
    }
}
// void iterative_postorder(struct node *p)
// {
//     struct stack stk;
//     long temp;
//     Stackcreate(&stk, 100);
//     while (p || !isStackEmpty(&stk))
//     {
//         if (p)
//         {
//             push(&stk, p);
//             p = p->lchild;
//         }
//         else
//         {
//             temp = pop(&stk);
//             if (temp > 0)
//             {
//                 push(&stk, -temp);
//                 p = ((struct node *)temp)->rchild;
//             }
//             else
//             {

//                 printf("%d ", p->value);
//                 p = NULL;
//             }
//         }
//     }
// }
int main()
{

    create_tree();
    printf("Preorder : \n");
    preorder(root);
    printf("\n");
    printf("Inorder : \n");
    inorder(root);
    printf("\n");
    printf("Postorder : \n");
    postorder(root);
    printf("\n");

    iterative_preorder(root);
    iterative_inorder(root);
    // printf("Postorder : \n");
    // iterative_postorder(root);
    return 0;
}
