import java.util.Arrays;

public class EffectOfReferenceDataArgument
{
    public static void main(String[] args)
    {
        int[] a = new int[]{3, 4, 5};
        printArray(a);
        modifyData(a);
        printArray(a);
    }

    public static void modifyData(int[] a) {
        a[0] = 4;
        a[1] = 5;
        a[2] = 6;
    }

    public static void printArray(int[] a) {
        System.out.println(Arrays.toString(a));
    }
}
