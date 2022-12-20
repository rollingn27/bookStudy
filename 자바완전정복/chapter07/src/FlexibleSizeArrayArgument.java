public class FlexibleSizeArrayArgument
{
    public static void main(String[] args)
    {
        method1(1, 2);
        method1(1, 2, 3);
        method1();
        method2("안녕", "방가");
        method2("땡큐", "베리", "감사");
        method2();
        method3(1, 2, 3, 5.5, 6.0);
    }

    public static void method1(int... values) {
        System.out.println("배열의 길이: " + values.length);

        for(int k: values) {
            System.out.print(k + " ");
        }
        System.out.println();
    }

    public static void method2(String...values) {
        System.out.println("배열의 길이: " + values.length);
        for(String k: values) {
            System.out.print(k + " ");
        }
        System.out.println();
    }

    public static void method3(int values, double...dValues) {
        System.out.println("배열의 길이: " + (values + dValues.length));
    }

}
