class AA {
    int m;
    void work() {
        System.out.println(m);
    }
}

class BB {
    int m;
    void work() {
        System.out.println(m);
    }
    BB() {

    }
}

class CC {
    int m;
    void work() {
        System.out.println(m);
    }
    CC(int a) {
        m = a;
    }
}

public class DefaultConstructor
{
    public static void main(String[] args)
    {
        AA a = new AA();
        BB b = new BB();
        CC c = new CC(3);
        a.work();
        b.work();
        c.work();
    }

}
