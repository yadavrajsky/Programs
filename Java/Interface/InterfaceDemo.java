package com.revision;

import java.io.Serializable;
import java.util.Scanner;
interface Pen
{
    String p="Trimax";
    default void usePen()
    {
        use();
    }
    static void display()
    {
        System.out.println("display");
    }
    private static void use()
    {
        System.out.println(p+" used");
    }

}
interface Test extends Pen, Serializable
{
    String subject="Algebra";
    void TakeTest();
    default  String studentName()
    {
        String name;
        Scanner sc=new Scanner(System.in);
        name=sc.next();
        return name;

    }

}
public class InterfaceDemo implements Test{
    @Override
    public void TakeTest() {
        System.out.println(subject+" test completed");
    }

    public static void main(String[] args) {
        Test t1=new InterfaceDemo();
        t1.TakeTest();
        Pen.display();
        t1.usePen();
    }
}
