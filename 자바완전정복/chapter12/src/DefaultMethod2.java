package defaa;

interface A {
    public default void abc() {
        System.out.println("A 인터페이스의 abc()");
    }
}

class B implements A {
    public void abc() {
        A.super.abc();
        System.out.println("B 클래스의 abc()");
    }
}

public class DefaultMethod2
{
    public static void main(String[] args)
    {
        B b = new B();
        b.abc();
    }
}
