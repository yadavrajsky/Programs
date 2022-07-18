class Var_args {

  public void show(int[] s) {

    for (int x : s) {
      System.out.println(x);
    }
  }
}

class Var_agsDemo {

  public static void main(String[] args) {
    Var_ags obj = new Var_ags();
    obj.show(10);
    obj.show(10, 20);
    obj.show(10, 20, 30);
  }
}
