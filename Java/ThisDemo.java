class ThisDemo {
    private int a;
    private int b;

    ThisDemo(int a, int b) {
        this.a = a;
        this.b = b;

    }

    public void display() {
        System.out.println(a + " " + b);
    }
}

class ThisDemo1 {
    public static void main(String args[]) {
        ThisDemo obj = new ThisDemo(10, 20);
        obj.display();
    }
}