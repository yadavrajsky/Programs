import java.util.Scanner;

class InputDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter 2 Numbers :");
        int x = s.nextInt();
        int y = s.nextInt();
        // int c=System.in.read();
        // System.out.println("Character is : "+c);
        System.out.println("Sum is : " + (x + y));

    }
}