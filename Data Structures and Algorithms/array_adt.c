	#include<stdio.h>
	#include<stdlib.h>
	#include <conio.h>
	struct Array
	{
		int capacity;
		int lastIndex;
		int *ptr;
		
	};
	struct Array* createArray(int);
	struct Array* createArray(int cap)
	{
		struct Array *p=(struct Array*)malloc(sizeof(struct Array));
		p->capacity=cap;
		p->lastIndex=-1;
		p->ptr=(int*)malloc(sizeof(int)*cap);
		return p;
	}
	void printMetaData(struct Array *p)
	{
		printf("Capacity of Array : %d\n",p->capacity);
		printf("Is list empty ? %s\n",p->lastIndex==-1?"Yes":"No");
		printf("Is list full ? %s\n",p->lastIndex==p->capacity-1?"Yes":"No");		
		printf("Number of item : %d\n", p->lastIndex+1);
		for (int i = 0; i <= p->lastIndex; i++)

		{
			printf("%d ",p->ptr[i]);
		}
		printf("\n");
	}
	int isFull(struct Array *p)
	{
		if(p->capacity==p->lastIndex+1)
		{
			return 1;
		}
		return 0;
	}
	int isEmpty(struct Array *p)
	{
		if(p->lastIndex==-1)
		{
			return 1;
		}
		return 0;
	}
	void append(struct Array *p,int data)
	{
		if(isFull(p))
			printf("Overflow\n");
		else
		{
			p->lastIndex++;
			p->ptr[p->lastIndex]=data;
		}
	}
	void insertItem(struct Array *p,int index,int value)
	{
		if(index<0 || index>p->lastIndex)
		{
			printf("Invalid Index\n");
		}
		else if(p->capacity==p->lastIndex+1)
		{
			printf("Overflow\n");
		}
		else
		{
			for(int i=p->lastIndex;i>=index;i--)
			{
				p->ptr[i+1]=p->ptr[i];
			}
			p->ptr[index]=value;
			p->lastIndex++;
		}

	}
	int getItem(struct Array *arr,int index)
	{
		if(arr->lastIndex<0 || index>arr->lastIndex)
			return -1; 
		else
			return arr->ptr[index];
		
	}
	void deleteItem(struct Array *arr,int index)
	{
		if(index<0 || index>arr->lastIndex)
		{
			printf("Invalid Index\n");
		}
		else
		{
			for (int i = index; i < arr->lastIndex; i++)
			{
				arr->ptr[i]=arr->ptr[i+1];
			}
			arr->lastIndex--;
		}
	}
	int countItems(struct Array *arr)
	{
		return arr->lastIndex+1;
	}
	void editItems(struct Array *p,int index,int value)
	{
		if(index<0 || index>p->lastIndex)
		{
			printf("Invalid Index\n");
		}
		else
		{
			p->ptr[index]=value;
		}
	}
	int search(struct Array *p,int value)
	{
		for (int i = 0; i <=p->lastIndex; ++i)
			{
				if(p->ptr[i]==value)
				{
					return i;
				}
			}	
			return -1;
	}
	int menu()
	{
		int choice;
		printf("1.Append New Item \n");
		printf("2.Insert New Item \n");
		printf("3.Edit An Item \n");
		printf("4.Delete An Item\n");
		printf("5.Search An Item\n");
		printf("6.Get An Item\n");
		printf("7.Exit\n");
		printf("\n\nEnter your choice : ");
		scanf("%d",&choice);
		return choice;
	}
	int main()
	{
		int item,index;

		struct Array *p=createArray(5);
		while(1)
		{
			system("cls");
			printMetaData(p);
			switch(menu())
			{
				case 1:
				printf("Enter item : \n");
				scanf("%d",&item);
				append(p,item);
				getch();
				break;
				case 2:
				printf("Enter the index number at which you want to insert :\n");
				scanf("%d",&index);
				printf("Enter the value that you want to insert :\n");
				scanf("%d",&item);
				insertItem(p,index,item);
				getch();
				break;
				case 3:
				printf("Enter the index number :\n");
				scanf("%d",&index);
				printf("Enter the value that you want to edit :\n");
				scanf("%d",&item);
				editItems(p,index,item);
				getch();
				break;
				case 4:
				printf("Enter the index number :\n");
				scanf("%d",&index);
				deleteItem(p,index);
				getch();
				break;	
				case 5:
				printf("Enter the value that you want to search :\n");
				scanf("%d",&item);
				index=search(p,item);
				if (index==-1)
					printf("Element Not Found.\n");
				else
					printf("Element Found at index %d.\n",index);
				getch();
				break;	
				case 6:
				printf("Enter the index number :\n");
				scanf("%d",&index);
				if (getItem(p,index)==-1)
					printf("Invalid Index\n");
				else
					printf("%d",getItem(p,index));
				getch();
				break;										
				case 7:
				exit(0);
				default:
				printf("Invalid option\n");
				getch();
		
			}
		}	

		return 0;
	}