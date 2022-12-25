package adfs;

class A {}
class B extends A {}
class C extends B {}
class D extends C {}

class Goods<T> {
    private T t;
    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }
}

class Test {
    void method1(Goods<A> g) {}
    void method2(Goods<?> g) {}
    void method3(Goods<? extends B> g) {}
    void method4(Goods<? super B> g) {}
}

public class BoundedTypeOfInputArguments
{
    public static void main(String[] args)
    {
        Test t = new Test();

        t.method1(new Goods<A>());

        t.method2(new Goods<A>());
        t.method2(new Goods<B>());
        t.method2(new Goods<C>());
        t.method2(new Goods<D>());

        t.method3(new Goods<B>());
        t.method3(new Goods<C>());
        t.method3(new Goods<D>());

        t.method4(new Goods<A>());
        t.method4(new Goods<B>());
    }
}
