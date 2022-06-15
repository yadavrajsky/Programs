#include <stdio.h>
void insert(int A[], int n)
{
    int i = n, temp;
    temp = A[n];
    while (i > 1 && temp > A[i / 2])
    {
        A[i] = A[i / 2];
        i = i / 2;
    }
    A[i] = temp;
}
int delete (int A[], int n)
{
    int i = 1, j, temp, deleted_val;
    deleted_val = A[i];
    A[1] = A[n];
    A[n] = deleted_val;
    j = 2 * i;
    while (j < n - 1)
    {
        if (A[j + 1] > A[j])
        {
            j = j + 1;
        }
        if (A[j] > A[i])
        {
            temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i = j;
            j = 2 * i;
        }
        else
        {
            break;
        }
    }
    return deleted_val;
}
int main(int argc, char const *argv[])
{
    int A[] = {0, 10, 20, 30, 25, 5, 40, 35};
    int i, n = 7;
    for (i = 2; i <= n; i++)
    {
        insert(A, i);
    }
    // printf("Deleted value is : %d \n", delete (A, 8));
    // Heap Sort
    for (i = 7; i >= 1; i--)
    {
        delete (A, i);
        // printf("%d ", delete (A, i));
    }
    for (i = 1; i <= n; i++)
    {
        printf("%d ", A[i]);
    }

    return 0;
}
