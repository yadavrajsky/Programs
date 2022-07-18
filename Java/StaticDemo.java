class StaticDemo {
    static int x;
    static {
        System.out.println("executed 1");
        x = 10;
    }

    public static void display() {
        System.out.println("in StaticDemo");
    }
}

class Static {
    private static int x;
    static {
        System.out.println("executed 2");
        x = 20;
    }

    public static void main(String[] args) throws ClassNotFoundException {

        // System.out.println("in main");
        // StaticDemo obj=new StaticDemo();
        // StaticDemo obj1=new StaticDemo();
        Class.forName("StaticDemo");
    }
}