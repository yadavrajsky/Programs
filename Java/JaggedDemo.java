import java.util.*;

class JaggedDemo {
    public static void main(String[] args) {
        System.out.println("Enter total number of salesmen ");
        Scanner s = new Scanner(System.in);
        int salesperson = s.nextInt();
        int[][] sales = new int[salesperson][];
        for (int i = 0; i < sales.length; i++) {
            System.out.println("Enter number of sales by salesman " + (i + 1));
            int sale;
            sale = s.nextInt();
            sales[i] = new int[sale];
            for (int j = 0; j < sales[i].length; j++) {
                System.out.println("Enter number of sale value " + (j + 1));
                sales[i][j] = s.nextInt();
            }
        }

        for (int[] sale_person : sales) {
            int sum = 0;
            for (int sale_value : sale_person) {
                sum = sum + sale_value;
            }
            System.out.println("Total sale : " + sum);
        }
    }
}