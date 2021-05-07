#include <stdio.h>
void bubble_sort(int arr[], int N)
{
    int i, j, k;
    for (i = 1; i < N; i++)
    {
        for(j = 0; j < N - i; j++)
        {
            if(arr[j] > arr[j + 1])
            {
                int temp;
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
void printArray(int *);
void modified_bubble_sort(int arr[], int N)
{
    int i, j, flag = 0;

    for (i = 1; i < N; i++)
    {
        for(j = 0; j < N - i; j++)
        {
            if(arr[j] > arr[j + 1])
            {
                int temp;
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                flag = 1;
            }       
        }
        printf("\n");
        if(flag == 0)
            break;
    }
}

void printArray(int arr[])
{
    for (int i = 0; i < 5 ; ++i)
    {
        printf("%d\n", arr[i]);
    }
}
int main()
{
    int i;
    int a1[5] = {11, 85, 82, 98, 99};
    bubble_sort(a1, 5);
    printArray(a1);

    int a2[5] = {11, 85, 86, 95, 99};
    modified_bubble_sort(a2, 5);
    printArray(a2);

    return 0;
}