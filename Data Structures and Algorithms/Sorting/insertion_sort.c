#include<stdio.h>
void InsertionSort(int A[],int n)
{
    int i,j,x;
    for ( i = 1; i < n; i++)
    {
        j=i-1;
        x=A[i];
        while (j>-1 && A[j]>x)
        {
            A[j+1]=A[j];
            j--;
        }
        A[j+1]=x;
    }
    
}
int main(int argc, char const *argv[])
{
    int A[]={10,2,3,7,6,8},i,n=6;
    InsertionSort(A,6) ;   
    for ( i = 0; i <n ; i++)
    { 
        printf("%d ",A[i]);
    }
    
    return 0;
}
