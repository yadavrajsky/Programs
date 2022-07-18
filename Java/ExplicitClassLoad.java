
class Static {
    static {
        System.out.println("In Static class");
    }
    public static String name="Static Class";
}

class ExplicitClassLoad {
static 
{
System.out.println("In ExplicitClassLoad ");
}
public static void main(String[] args) throws ClassNotFoundException
{
    Class.forName("Static");
    System.out.println(Static.name);

}

}

