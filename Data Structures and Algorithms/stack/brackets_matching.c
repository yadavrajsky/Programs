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
        return '\0';
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
    if(s->top==-1)
    return 1;
    return 0;
}
int reverse_bracket_match(char a,char b)
{
    if((a=='(' && b==')') || (a=='[' && b==']') || (a=='{' && b=='}') )
    return 1;
    return 0;
}
int parenthesis_matching(char *exp)
{
    int i;
    char charac;
    char popped_value;
    struct stack s;
    int len ;
    len= strlen(exp);
    s.size=len;
    s.top = -1;
    s.S = (char *)malloc(len * sizeof(char));



    for (i = 0; exp[i] != '\0'; i++)
    {
        charac = exp[i];
        if (charac == '(' || charac == '{' || charac == '[')
            push(&s, charac);
        else if (charac == ')' || charac == ']' || charac == '}')
        {
            if (isEmpty(&s))
                return 0;
            else
            {
                popped_value = stack_top(&s);
                if (reverse_bracket_match(popped_value,charac))
                {
                    pop(&s);
                }
                else
                {
                    return 0;
                }
            }
        }
    }
    
    return isEmpty(&s) ? 1 : 0;
}

int main(int argc, char const *argv[])
{
    struct stack s;
    char A[] = "{([a+b]*[c-d])/e}}}}";
    char B[] = "{([a+b]*[c-d])/e}";
    char C[] = "{([{a+b]*[c-d])/e}";
    printf("%d\n", parenthesis_matching(A));
    printf("%d\n", parenthesis_matching(B));
    printf("%d\n", parenthesis_matching(C));
    return 0;
}
