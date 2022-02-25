#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
struct node
{
    struct node *lchild;
    int data;
    struct node *rchild;
} *root = NULL;
struct stack
{
    int size;
    int top;
    struct node **S;
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
void Stackcreate(struct stack *s, int size)
{

    s->top = -1;
    s->S = (struct node **)malloc(size * sizeof(struct node *));
}
void push(struct stack *s, struct node *value)
{
    if (s->top == s->size - 1)
        printf("Overflow\n");
    else
    {
        s->top++;
        s->S[s->top] = value;
    }
}
struct node *pop(struct stack *s)
{
    struct node *x = NULL;
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
struct node *peek(struct stack *st, int index)
{
    if (index <= -1 || index > st->top)
        return NULL;
    else
        return st->S[index];
}
struct node *stackTop(struct stack *st)
{
    if (st->top == -1)
        return NULL;
    else
        return st->S[st->top];
}

void insert(int key)
{
    struct node *t, *p, *tail;
    if (root == NULL)
    {
        p = (struct node *)malloc(sizeof(struct node));
        p->lchild = p->rchild = NULL;
        p->data = key;
        root = p;
        return;
    }
    t = root;
    while (t != NULL)
    {
        tail = t;
        if (t->data == key)
            return;
        else if (key > t->data)
            t = t->rchild;
        else
            t = t->lchild;
    }
    p = (struct node *)malloc(sizeof(struct node));
    p->lchild = p->rchild = NULL;
    p->data = key;
    if (key > tail->data)
        tail->rchild = p;
    else
        tail->lchild = p;
}
void Inorder(struct node *t)
{
    if (t)
    {
        Inorder(t->lchild);
        printf("%d ", t->data);
        Inorder(t->rchild);
    }
}
struct node *search(int key)
{
    struct node *t = root;
    while (t != NULL)
    {
        if (key == t->data)
            return t;
        else if (key < t->data)
            t = t->lchild;
        else
            t = t->rchild;
    }
    return NULL;
}
int Height(struct node *p)
{
    int x, y;
    if (p == NULL)
        return 0;
    x = Height(p->lchild);
    y = Height(p->rchild);
    return x > y ? x + 1 : y + 1;
}
struct node *InPre(struct node *p)
{
    while (p && p->rchild != NULL)
    {
        p = p->rchild;
    }
    return p;
}
struct node *InSucc(struct node *p)
{
    while (p && p->lchild != NULL)
    {
        p = p->lchild;
    }
    return p;
}
struct node *delete (struct node *p, int key)
{
    struct node *q;
    if (p == NULL)
        return NULL;
    if (p->lchild == NULL && p->rchild == NULL)
    {
        if (p == root)
            root = NULL;

        free(p);
        return NULL;
    }

    if (key < p->data)
        p->lchild = delete (p->lchild, key);
    else if (key > p->data)
        p->rchild = delete (p->rchild, key);
    else if (key == p->data)
    {
        if (Height(p->lchild) > Height(p->rchild))
        {
            q = InPre(p->lchild);
            p->data = q->data;
            p->lchild = delete (p->lchild, q->data);
        }

        else
        {
            q = InSucc(p->rchild);
            p->data = q->data;
            p->rchild = delete (p->rchild, q->data);
        }
    }

    return p;
}
struct node *Rinsert(struct node *p, int key)
{
    struct node *temp = NULL;
    if (p == NULL)
    {
        temp = (struct node *)malloc(sizeof(struct node));
        temp->data = key;
        temp->lchild = temp->rchild = NULL;
        return temp;
    }
    if (key < p->data)
        p->lchild = Rinsert(p->lchild, key);
    else
        p->rchild = Rinsert(p->rchild, key);
    return p;
}
void createPre(int pre[], int size)
{
    struct stack s;
    Stackcreate(&s, 100);
    struct node *t, *p;
    int i = 0;
    root = (struct node *)malloc(sizeof(struct node));
    root->lchild = root->rchild = NULL;
    root->data = pre[i++];
    p = root;
    while (i < size)
    {
        if (pre[i] < p->data)
        {
            t = (struct node *)malloc(sizeof(struct node));
            t->data = pre[i++];
            t->lchild = t->rchild = NULL;
            p->lchild = t;
            push(&s, p);
            p = t;
        }
        else
        {
            if (pre[i] > p->data && pre[i] < isStackEmpty(&s) ? 32767 : stackTop(&s)->data)
            {
                t = (struct node *)malloc(sizeof(struct node));
                t->data = pre[i++];
                t->lchild = t->rchild = NULL;
                p->rchild = t;
                push(&s, p);
                p = t;
            }
            else
            {
                p = pop(&s);
            }
        }
    }
}
int main(int argc, char const *argv[])
{
    // struct node *t;
    // root = Rinsert(root, 50);
    // insert(10);
    // Rinsert(root, 40);
    // insert(20);
    // insert(30);
    // delete (root, 50);
    // Inorder(root);
    // printf("\n");
    // t = search(52);
    // if (t != NULL)
    //     printf("%d key found", t->data);
    // else
    //     printf("key not found");
    int pre[] = {30, 20, 10, 15, 25, 40, 50, 45};
    createPre(pre, 8);
    Inorder(root);
    return 0;
}
