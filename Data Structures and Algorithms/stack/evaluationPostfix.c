#include <stdio.h>
#include <stdlib.h>
#include <string.h>
struct stack
{
    int size;
    int top;
    int *S;
};
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
int isOperand(char c)
{
    if (c == '+' || c == '-' || c == '*' || c=='/')
        return 0;
    return 1;
}
int evaluatePostfix(char* postfix_exp)
{
    struct stack s;
    int len = strlen(postfix_exp);
    s.size = len;
    s.top = -1;
    s.S = (int *)malloc(len * sizeof(int));
    int value1;
    int value2;
    int result;
    int i=0;
while (postfix_exp[i]!='\0')
{
    if (isOperand(postfix_exp[i]))
    {
        push(&s,postfix_exp[i++]-'0');
    }
    else
    {
        value2=pop(&s);
        value1=pop(&s);
        switch (postfix_exp[i])
        {
        case '+':
            result=value1+value2;
            break;
        case '-':
            result=value1-value2;
            break;
        case '*':
            result=value1*value2;
            break;
        case '/':
            result=value1/value2;
            break;
        break;
    
        }
        push(&s,result);
        i++;
    }
}
return pop(&s);
}
int main(int argc, char const *argv[])
{
    char* postfix_exp="123*+";
    printf("%d\n",evaluatePostfix(postfix_exp));
    return 0;
}
