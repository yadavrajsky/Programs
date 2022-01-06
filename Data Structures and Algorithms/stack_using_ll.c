#include<stdio.h>
struct node
{
    int data;
    struct node *next;
}*top=NULL;

void push(int x)
{
    struct node *t;
    t=(struct node*)malloc(sizeof(struct node));
    t->data=x;
    t->next=top;
    top=t;

}
int pop()
{
    struct node *t;
    t=top;
    int x=-1;
    if(t==NULL)
    {
        printf("Empty Stack");
        return x;
    }
    top=top->next;
    x=t->data;
    free(t);
    return x;    
}
void Display()
{
    struct node *t;
    t=top;
    if(t==NULL)
    {
        printf("Stack is Empty\n");
    }
    while (t!=NULL)
    {
        printf("%d\n",t->data);
        t=t->next;
    }
    
}
int main(int argc, char const *argv[])
{
    push(1);
    push(2);
    push(5);
    Display();
    printf("%d \n",pop());
    Display();
    
    return 0;
}
