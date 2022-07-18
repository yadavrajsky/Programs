
class FinalPrivateDemo {
  final private void greet() {
    System.out.println("Hello");
  }

  public void caller() {
    greet();
  }

}

class MainFinalPrivateDemo {

  public static void main(String[] args) {
    FinalPrivateDemo fpd = new FinalPrivateDemo();
    fpd.caller();

  }
}
