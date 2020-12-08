#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
struct node 
{
  int data;
  struct node *next;
};
void display(struct node*);
struct node* create_list(struct node*);
struct node* add_to_empty(struct node*,int);
struct node* add_at_beg(struct node*,int);
struct node* add_at_end(struct node*,int);
struct node* add_after(struct node*,int,int);
struct node* del(struct node*,int);

struct node* add_at_beg(struct node *last,int value)
{
  struct node *n;
  n=malloc(sizeof(struct node));
  n->data=value;
  n->next=last->next;
  last->next=n;
  return(last);

}

struct node* add_to_empty(struct node *last,int value)
{
  struct node *n;
  n=malloc(sizeof(struct node));
  n->data=value;
  last=n;
  last->next=last;


}

struct node* add_at_end(struct node *last,int value)

{
  struct node *n;
  n=malloc(sizeof(struct node));
  n->data=value;
  n->next=last->next;
  last->next=n;
  last=n;
  return(last);


}

void display(struct node *last)
{
  if(last==NULL)
    printf("List is empty.");
  else
  {
    struct node *t;
    t=last->next;
    do
    {
      printf("%d\n",t->data);
      t=t->next;
      
    }while(t!=last->next);
  }
}
struct node* add_after(struct node *last,int value,int item)
{
  struct node *t;
  t=last->next;
  do
  {
    if(t->data==item)
    {
      struct node *n;
      n=malloc(sizeof(struct node));
      n->data=value;
      n->next=t->next;
      t->next=n;
      if(t==last)
      {
        last=n;
      }
      return(last);
    }
  }while(t!=last->next);

  printf("%d is not in the list.\n",item);
  return(last);
}
struct node* del(struct node *last,int value)
{
  if(last==NULL)
  {
    printf("List is empty.\n");
    return(last);
  }
  struct node *t;
  if(last==last->next && last->data==value)
  {
    t=last;
    last=NULL;
    free(t);
    return(last);
  }

  if(last->next->data==value)
  {
    struct node *n;
    t=last->next;
    last->next=t->next;
    free(t);
    return(last);
  }
  struct node *p;
  p=last->next;
  while(p->next!=last)
  {
    if(p->next->data==value)
    {
      t=p->next;
      p->next=t->next;
      free(t);
      return(last);
    }
    p=p->next;
  }
  if(last->data==value)
  {
    t=last;
    p->next=last->next;
    free(t);
    last=p;
    return(last);
  }
  printf("%d element not found.\n",value);
  return(last);
}

struct node* create_list(struct node *last)
{
  int n,value,i;
  printf("How many values you want to enter.\n");
  scanf("%d",&n);
  printf("Enter first value of the list");
  scanf("%d",&value);
  last=add_to_empty(last,value);
  for(i=2;i<=n;i++)
  {
    printf("Enter data for the list.\n");
    scanf("%d",&value);
    last=add_at_end(last,value);
    
  }
  return(last);
}
int main()
{
  int choice,item,value;
  struct node *last=NULL;
  while(1)
  {
    system("cls");
    printf("1.Create list\n");
    printf("2.Display list\n");
    printf("3.Add to empty list\n");
    printf("4.Add at beginning\n");
    printf("5.Add at end\n");
    printf("6.Add after\n");
    printf("7.Delete\n");
    printf("8.Exit\n");
    printf("\n\nEnter your choice. ");
    scanf("%d",&choice);
    switch(choice)
    {
      case 1:
      last=create_list(last);
      break;
      case 2:
      display(last);
      break;
      case 3:
      printf("Enter a number for the list\n");
      scanf("%d",&value);
      last=add_to_empty(last,value);
      break;
      case 4:
      printf("Enter a number for the list\n");
      scanf("%d",&value);
      last=add_at_beg(last,value);
      break;
      case 5:
      printf("Enter a number for the list\n");
      scanf("%d",&value);
      last=add_at_end(last,value); 
      break;     
      case 6:
      printf("Enter a item value after which new number you want to enter in the list\n");
      scanf("%d",&item);
      printf("Enter a number for the list\n");
      scanf("%d",&value);
      last=add_after(last,value,item); 
      break;
      case 7:
      printf("Enter a number which you want to delete from the list\n");
      scanf("%d",&value);
      last=del(last,value);    
      break;    
      case 8:
      exit(0);
      break;
      default:
      printf("Invalid Input.\n");
     }
     getch();
     
  }
  return 0;
}
