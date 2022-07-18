class Box {
    private int l;
    private int b;
    private int h;

    Box(String name) {
        System.out.println("In String Box");
    }

    Box() {
        this("Ram");
        System.out.println("In Box");
    }

    Box(int l, int b, int h) {
        this.l = l;
        this.b = b;
        this.h = h;
    }

    Box(int x) {
        l = x;
        b = x;
        h = x;
    }

    Box(Box x) {
        this(x.l, x.b, x.h);
    }

    public void volume() {
        System.out.println(l * b * h);
    }

    public void manipulate() {
        l = l + 1;
        b = b + 1;
        h = h + 1;
    }
}

class BoxDemo
{

    public static void main(String[] args) {
        Box b = new Box(10);
        Box b1 = new Box(10, 20, 30);
        Box b2 = b1;
        Box b3 = new Box(b2);
        b.volume();
        b1.volume();
        b2.manipulate();
        b2.volume();
        b3.volume();

    }
}