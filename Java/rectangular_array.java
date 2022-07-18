import java.util.Scanner;

class ClassArray {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter element :");
            arr[i] = s.nextInt();
        }

        System.out.println("Elements in the array are :");
        /*
         * for(int i=0;i<5;i++)
         * {
         * System.out.println(arr[i]);
         * }
         */
        // System.out.println(arr);
        // enhanced for loop
        for (int a : arr) {
            System.out.println(a);
        }
    }
}