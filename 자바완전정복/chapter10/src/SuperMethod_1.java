package superA;

class A {
    A() {
        System.out.println("A 생성자");
    }
}

class B extends A{
    B() {
        super();
        System.out.println("B 생성자");
    }
}

class C {
    C(int a) {
        System.out.println("C 생성자");
    }
}

class D extends C {
    D() {
        super(3);
    }
}

public class SuperMethod_1
{
    public static void main(String[] args)
    {
        A aa = new A();
        System.out.println();
        B bb = new B();
    }
}
