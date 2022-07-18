interface UpdateDemo {
  void show();

  default void display() {
    System.out.println("In display of UpdateDemo");
  }

  default void greet() {

    System.out.println("Hello From Interface");
  }

  default void caller() {

    greet();
  }
}

class InterfaceUpdate implements UpdateDemo {
  public void show() {

    System.out.println("Implemented show");
  }

  public void display() {
    System.out.println("In display of InterfaceUpdateDemo");
    caller();
  }

}

class InterfaceUpdateDemo {
  public static void main(String[] args) {
    UpdateDemo obj = new InterfaceUpdate();
    obj.display();
    obj.show();
  }
}
