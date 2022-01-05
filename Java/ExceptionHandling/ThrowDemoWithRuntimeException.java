package ExceptionHandling;

class ThrowDemo extends RuntimeException {

    ThrowDemo() {
        super("Used for throwing exception");
    }

    public String toString() {
        return "This is Custom Exception";
    }

}
 public class Main {
    public static void main(String[] args) {
            throw new ThrowDemo();
        }
    }


