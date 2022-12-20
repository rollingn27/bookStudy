package ex.aaa;
class A {
    void abc () {
        System.out.println("instance 메서드");
    }
    static void bcd() {
        System.out.println("static 메서드");
    }
}

public class StaticMethod
{
    public static void main(String[] args)
    {
        A a1 = new A();
        a1.abc();

        A.bcd();
        A a2 = new A();
        a2.bcd();
    }
}
