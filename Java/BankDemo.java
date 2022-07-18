import java.util.*;

class Customer {
    private int acc_no;
    private String name;
    private int bal;
    private static int rate = 5;
    private double i;

    public static void getRate() {
        System.out.println("Rate of interest is :" + rate);
    }

    private static void setRate() {
        System.out.println("Enter the rate : ");
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        rate = s;
    }

    public Customer(int a, String n, int b) {
        acc_no = a;
        name = n;
        bal = b;

    }

    public void getInterest() {
        i = bal * rate / 100;
    }

    public void display() {
        System.out.println("Name : " + name + " Balance: " + bal + " Interest: " + i);
    }
}

class BankDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("How many customers?");
        int n = s.nextInt();
        Customer[] arr = new Customer[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter account number ");
            int a = s.nextInt();
            System.out.println("Enter Name ");
            s.nextLine();
            String str = s.nextLine();
            System.out.println("Enter Balance");
            int b = s.nextInt();
            arr[i] = new Customer(a, str, b);
        }

        for (Customer c : arr) {

            c.getInterest();
            c.display();
        }

    }
}
