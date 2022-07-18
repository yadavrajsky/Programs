import java.util.*;

class Try {
  public int calculate() {
    int num, den, ans;
    Scanner s = new Scanner(System.in);

    try {
      num = s.nextInt();
      den = s.nextInt();
      ans = num / den;
      System.out.println(ans);
      // return 2;
    } catch (Exception e) {
      System.out.println(e);
      // return 3;
    } finally {

      System.out.println("Progran Executed Successfully.");
      return 1;

    }
  }
}

class TryDemo {
  public static void main(String[] args) {
    int a;
    Try obj = new Try();
    a = obj.calculate();
    System.out.println(a);
  }
}
