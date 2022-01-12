#include <stdio.h>
#include <stdlib.h>
#include <string.h>
struct stack
{
    int size;
    int top;
    char *S;
};
void push(struct stack *s, char value)
{
    if (s->top == s->size - 1)
        printf("Overflow\n");
    else
    {
        s->top++;
        s->S[s->top] = value;
    }
}
char pop(struct stack *s)
{
    char x = '\0';
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
char stack_top(struct stack *st)
{
    if (st->top == -1)
        return '\0';
    else
        return st->S[st->top];
}
int isEmpty(struct stack *s)
{
    if (s->top == -1)
        return 1;
    return 0;
}
int precedence(char c)
{
    if (c == '+' || c == '-')
        return 1;
    else if (c == '*' || c == '/')
        return 2;
    else
        return 3;
}
int isOperand(char c)
{
    if (c == '+' || c == '-' || c == '*' || c == '/')
        return 0;
    return 1;
}
char *convertInfixToPostfix(char *infix)
{
    struct stack s;
    int i = 0, j = 0;
    int len = strlen(infix);
    char *postfix = (char *)malloc((len + 1) * sizeof(char));
    s.size = len;
    s.top = -1;
    s.S = (char *)malloc(len * sizeof(char));

    while (infix[i] != '\0')
    {
        if (isEmpty(&s))
        {
            push(&s, infix[i++]);
        }
        else
        {
            if (precedence(infix[i]) > precedence(stack_top(&s)))
            {
                push(&s, infix[i++]);
            }
            else
            {
                if (precedence(infix[i]) <= precedence(stack_top(&s)))
                {
                    postfix[j++] = pop(&s);
                }
            }
        }
    }

    while (!isEmpty(&s))
    {
        postfix[j++] = pop(&s);
    }

    postfix[j] = '\0';
    return postfix;
}
int main(int argc, char const *argv[])
{
    char *infix = "a+b*c";
    int i;
    char *postfix = convertInfixToPostfix(infix);
    for (i = 0; i < strlen(postfix); i++)
    {
        printf("%c", postfix[i]);
    }

    return 0;
}
