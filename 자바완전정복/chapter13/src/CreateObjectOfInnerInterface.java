package asdfsf;

class A {
    static interface B {
        public abstract void bcd();
    }
}

class C implements A.B {
    public void bcd() {
        System.out.println("이너 인터페이스 구현 클래스 생성");
    }
}

public class CreateObjectOfInnerInterface
{
    public static void main(String[] args)
    {
        A.B ab = new C();
        C c = new C();
        c.bcd();
        A.B a = new A.B() {
            public void bcd() {
                System.out.println("익명 이너 클래스로 객체 생성");
            }
        };
        a.bcd();
    }
}
