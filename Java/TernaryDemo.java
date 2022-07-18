import java.util.*;

class TernaryDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter 3 nos ");
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        String str = a > b ? a > c ? "a is greater" : "c is greater" : b > c ? "b is greater" : "c is greater";
        System.out.println(str);
    }

}
