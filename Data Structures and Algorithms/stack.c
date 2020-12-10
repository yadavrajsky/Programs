#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
struct ArrayStack
{
    int top;
    int capacity;
    int *array;
};
struct ArrayStack* createStack(int cap)
{
    struct ArrayStack *stack;
    stack=malloc(sizeof(struct ArrayStack));
    stack->capacity=cap;
    stack->top=-1;
    stack->array=malloc(sizeof(int)*cap);
    return(stack);

};
int isfull(struct ArrayStack *stack)
{
    if(stack->top==stack->capacity-1)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}
int isempty(struct ArrayStack *stack)
{
    if(stack->top==-1)
    {
        return 1;
    }
    else
    {
        return 0;
    }    
}
void push(struct ArrayStack *stack,int item)
{
    
    if(!isfull(stack))
    {
        stack->top=++stack->top;
        stack->array[stack->top]=item;
    }
    else
    {
        printf("Stack is full\n");
    }
}
int pop(struct ArrayStack *stack)
{
    
    int item;
    if(!isempty(stack))
    {
        item=stack->array[stack->top];
        stack->top--;
        return item;
    }
    else
    {
        return -1;
    }
    
}
int main()
{
    int c,num,capacity;
    system("cls");
    struct ArrayStack *stack;
    printf("Enter the capacity ");
    scanf("%d",&capacity);
    stack=createStack(capacity);
    while(1)
    {
        system("cls");
        printf("1.Push\n");
        printf("2.Pop\n");
        printf("3.Exit\n");
        printf("\n\nEnter your choice ");
        scanf("%d",&c);
        switch(c)
        {
            case 1:
            printf("\nEnter a number ");
            scanf("%d",&num);
            push(stack,num);
            break;
            case 2:
            num=pop(stack);
            if(num==-1)
            printf("Stack is empty.\n");
            else
            printf("The popped value is %d",num);
            break;
            case 3:
            exit(0);
            break;
            default:
            printf("Invalid Input.\n");
        }
        getch();
    }
    return 0;
}

