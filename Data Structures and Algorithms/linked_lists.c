#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
struct node
{
    struct node *prev;
    int data;
    struct node *next;
};
void insert_start(struct node**,int);
void insert_last(struct node**,int);
void insert_after(struct node**,struct node*,int);
struct node* find(struct node**,int);
void show_forward(struct node**);
int delete_first(struct node**);
int delete_last(struct node**);
int delete_after(struct node**,struct node*);
void insert_start(struct node **s,int data)
{
    struct node *p;
    p=(struct node*)malloc(sizeof(struct node));
    p->data=data;
    p->prev=NULL;
    p->next=*s;
    *s=p;
    printf("Inserted at first position.\n");
}

void insert_last(struct node **s,int data)
{
    struct node *p,*t;
    p=(struct node*)malloc(sizeof(struct node));
    p->data=data;
    p->next=NULL;
    if(*s==NULL)
    {
        p->prev=NULL;
        *s=p;
    }
    else
    {
        t=*s;
        while(t->next!=NULL)
        {
            t=t->next;
        }
        p->prev=t;
        t->next=p;  
    }  
    printf("Inserted at last position.\n");
}
void show_forward(struct node **st)
{
    struct node *p;
    p=*st;
    while(p!=NULL)
    {
        printf("%d\n",p->data);
        p=p->next;
    }
}
struct node* find(struct node**s,int data)
{
    if(*s==NULL)
    {
    return NULL;
    }
    else
    {
        struct node *t;
        t=*s;
        while(t!=NULL)
        {
            if(data==t->data)
            return t;
            t=t->next;
        }
        return NULL;
    }
}

void insert_after(struct node **s,struct node *ptr,int data)
{
    if(*s==NULL)
    printf("Invalid Insertion\n");
    else
    {
        struct node *p;
        p=(struct node*)malloc(sizeof(struct node));
        p->data=data;
        p->prev=ptr;
        p->next=ptr->next;
        if(ptr->next!=NULL)
        {
            ptr->next->prev=p;
        }
        ptr->next=p;
    }
}
int delete_first(struct node **s)
{
    struct node *t;
    if(*s==NULL)
        return(0);
    else
    {
        t=*s;
        (*s)=(*s)->next;
        (*s)->prev=NULL;
        free(t);
        return(1);
    }
}
int delete_last(struct node **s)
{
    struct node *t,*t1;
    if(*s==NULL)
        return(0);
    t=*s;
    while(t->next!=NULL)
        t=t->next;
    if((*s)->next==NULL)
        *s=NULL;
    else
        t->prev->next=NULL;
    free(t);
    return(1);
    
}
int delete_after(struct node **s,struct node *ptr)
{
    struct node *t;
    if(*s==NULL)
    return 0;
    if(ptr->prev==NULL)
    {
        *s=ptr->next;
        ptr->next->prev=NULL;
        free(ptr);
    }
    if(ptr->next==NULL)
    {
        ptr->prev->next=NULL;
        free(ptr);

    }   
    ptr->prev->next=ptr->next;
    ptr->next->prev=ptr->prev;
    
}
int main()
{
    int deleted_f,deleted_l;
    struct node *ptr;
    struct node *start=NULL;
    insert_start(&start,1);
    insert_last(&start,3);
    ptr=find(&start,1);
    insert_after(&start,ptr,2);
    deleted_f=delete_first(&start);
    if(deleted_f==1)
    printf("Deleted first node.\n");
    else
    printf("Cannot be deleted first node.");
    deleted_l=delete_last(&start);
    if(deleted_l==1)
    printf("Deleted last node.\n");
    else
    printf("Cannot be deleted last node.");   
    show_forward(&start);
    insert_start(&start,1);
    delete_after(&start,ptr);
    show_forward(&start);
    return 0;
}
