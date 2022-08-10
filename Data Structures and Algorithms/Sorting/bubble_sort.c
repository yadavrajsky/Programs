#include <stdio.h>
void swap(int *a,int *b)
{
    int temp;
    temp=*a;
    *a=*b;
    *b=temp;
}
void bubble_sort(int A[],int n)
{
    int flag;
    int i,j;
    for(i=0;i<n-1;i++)
    {
        flag=0;
        for(j=0;j<n-1-i;j++)
        {
            if (A[j]>A[j+1])
            {
                swap(&A[j],&A[j+1]);
                flag=1;
            }
            
        }
        if (flag==0)
        {
            return;
        }
        
    }

}
int main(int argc, char const *argv[])
{
    int A[]={3,7,9,8,5,11},i;
    bubble_sort(A,6);
    for (int i = 0; i < 6; i++)
    {
        printf("%d ",A[i]);
    }
    
    return 0;
}
