package com.revision;
abstract class Demo
{
    static int count;
     int a;
     abstract void display();
     Demo(){
         a=10;
         count++;
     }
}
public class AbstractDemo extends Demo {
//    Demo d=new AbstractDemo();

    @Override
    void display()
    {
        int b=2;
        System.out.println(b);
    }
    public static void main(String[] args) {
        Demo d1=new AbstractDemo();
//        d.display();
        d1.display();
        System.out.println(Demo.count);
    }

}
