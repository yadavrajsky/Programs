class Base {
    Base(String s) {
        System.out.println("Hello From Base." + s);
    }

}

class Child extends Base {
    Child() {
        super("Akash");
        System.out.println("Hello From Child.");
    }
}

class SuperDemo {
    public static void main(String[] args) {
        Child c = new Child();
    }
}