package MyPackage_1;

import MyPackage_2.*;

class Package1Demo {
  public static void main(String[] args) {
    System.out.println("In MyPackage1 Main");
    Package2Demo obj = new Package2Demo();
    obj.greet();
  }
}
