package ExceptionHandling;

class ThrowDemo extends Exception {

    ThrowDemo() {
        super("Used for throwing exception");
    }

    public String toString() {
        return "This is Custom Exception";
    }

}
 class Main {
    public static void main(String[] args) {

        try {
            throw new ThrowDemo();
        } catch (ThrowDemo e) {
            System.out.println(e.getMessage());
            System.out.println(e);
            e.printStackTrace();
        }
    }
}

