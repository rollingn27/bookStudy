package mialf;

public class MultiCatch3
{
    public static void main(String[] args)
    {
        try {
            System.out.println(3 / 0);
            int num = Integer.parseInt("10A");
        }
        catch(ArithmeticException | NumberFormatException e) {
            System.out.println("예외 발생");
        }
    }
}
