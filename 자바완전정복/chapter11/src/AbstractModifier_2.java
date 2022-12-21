package absT;

abstract class Animal {
    abstract void cry();
}

class Cat extends Animal {
    void cry() {
        System.out.println("야옹");
    }
}

class Dog extends Animal {
    void cry() {
        System.out.println("멍멍");
    }
}

public class AbstractModifier_2
{
    public static void main(String[] args)
    {
        Animal ani1 = new Cat();
        Animal ani2 = new Dog();
        ani1.cry();
        ani2.cry();
    }
}
