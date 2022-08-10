#include <stdio.h>
void swap(int *x, int *y)
{
    int temp;
    temp = *x;
    *x = *y;
    *y = temp;
}
void SelectionSort(int A[], int n)
{
    int i, j, k;
    for (i = 0; i < n - 1; i++)
    {
        for (j = k = i; j < n; j++)
        {
            if (A[j] < A[k])
            {
                k = j;
            }
        }
        swap(&A[i], &A[k]);
    }
}

int main(int argc, char const *argv[])
{
    int A[] = {2, 7, 8, 3, 5, 6}, n = 6, i;
    SelectionSort(A, n);
    for (i = 0; i < n; i++)
    {
        printf("%d ", A[i]);
    }

    return 0;
}
