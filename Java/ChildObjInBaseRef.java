class Base {
    public void show() {
        System.out.println("Base");
    }
}

class Child extends Base {
    public void display() {
        System.out.println("Hola Child");
    }
}

class ChildObjInBaseRef {
    public static void main(String[] args) {
        Base b = new Child();
        b.show();
        b.display();
    }
}