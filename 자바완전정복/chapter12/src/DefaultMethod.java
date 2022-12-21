package tesA;

interface A {
    public abstract void abc();
    default void bcd() {
        System.out.println("A 인터페이스의 bcd()");
    }
}

class B implements A {
    public void abc() {
        System.out.println("B 클래스의 abc()");
    }
}

class C implements A {
    public void abc() {
        System.out.println("C 클래스의 abc()");
    }
    public void bcd() {
        System.out.println("C 클래스의 bcd()");
    }
}
public class DefaultMethod
{
    public static void main(String[] args)
    {
        A a1 = new B();
        A b2 = new C();
        a1.abc();
        a1.bcd();
        b2.abc();
        b2.bcd();
    }
}
