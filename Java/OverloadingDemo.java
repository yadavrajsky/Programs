class Demo {
    public void display() {
        System.out.println("Demo Display ");
    }

    private static void display1() {
        System.out.println("Demo");
    }

}

class Demo1 extends Demo {
    // overloading
    public void display(int a) {
        System.out.println("Number is " + a);
    }

    // Hiding
    public static void display1() {
        System.out.println("Hiding ");
    }

}

class Overloading {
    public static void main(String[] args) {
        Demo1 c = new Demo1();
        c.display(1);
        c.display();
        c.display1();
    }
}
