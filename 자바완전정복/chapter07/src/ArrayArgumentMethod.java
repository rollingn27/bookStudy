import java.util.Arrays;

public class ArrayArgumentMethod
{
    public static void main(String[] args)
    {
        int[] a = new int[] {1, 2, 3};
        printArray(a);
        printArray(new int[]{3, 4, 5});
    }

    public static void printArray(int[] a) {
        System.out.println(Arrays.toString(a));
    }
}
