package growable.array;

public class DataStructuresUsingJava {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
        GrowableArray ga = new GrowableArray();
        ga.add(10);
        ga.add(20);
        ga.add(30);
        ga.add(40);
        ga.add(50);
        ga.add(60);
        ga.add(70);
//        System.out.println();
        ga.add(7, 80);
        System.out.println(ga);
//        System.out.println(ga.remove(10));
//        System.out.println(ga.remove(0));
//        System.out.println(ga.remove(3));
//        System.out.println(ga.remove((Integer) 3));
//        System.out.println(ga.remove((Integer) 30));

//        for (int i = 0; i < ga.size(); i++) {
//            System.out.println(ga.get(i));
//        }
        System.out.println("Size: " + ga.size());
        System.out.println("Capacity: " + ga.capacity());

    }
}
