package creObj;

interface A {
    public static final int a = 3;
    public abstract void abc();
}

class B implements A {
    public void abc() {
        System.out.println("방법 1. 자식 클래스 생성자로 객체 생성");
    }
}

public class CreateOb
{
    public static void main(String[] args)
    {
        A b1 = new B();
        A a1 = new A() {
            public void abc() {
                System.out.println("방법 2. 익명 이너 클래스를 이용한 객체 생성");
            }
        };
        b1.abc();
        a1.abc();
    }
}
