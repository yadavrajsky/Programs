class Shape {
    public void area() {
        System.out.println("Area of Shape");
    }
}

class Circle extends Shape {
    int rad = 3;

    public void area() {
        System.out.println(rad * rad * 3.14);
    }
}

class Rectangle extends Shape {
    int a = 10;
    int b = 20;

    public void area() {
        System.out.println(a * b);
    }

}

class RunTimeDemo {
    public static void main(String[] args) {
        Shape obj;
        obj = new Circle();
        obj.area();
        obj = new Rectangle();
        obj.area();
        obj = new Shape();
        obj.area();
    }
}