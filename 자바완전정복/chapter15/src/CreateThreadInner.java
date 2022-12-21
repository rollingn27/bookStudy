package inndeT;

public class CreateThreadInner
{
    public static void main(String[] args)
    {
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String[] strArray = {"하나", "둘", "셋", "넷", "다섯"};
                try {
                    Thread.sleep(10);
                }
                catch(InterruptedException e) {}
                for(int i = 0; i < strArray.length; i++) {
                    System.out.println(" - (자막 번호) " + strArray[i]);
                    try {
                        Thread.sleep(200);
                    }
                    catch(InterruptedException e) {}
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int[] intArray = {1, 2, 3, 4, 5};
                for(int i = 0; i < intArray.length; i++) {
                    System.out.print("(비디오 프레임) " + intArray[i]);
                    try {
                        Thread.sleep(200);
                    }
                    catch(InterruptedException e) {}
                }
            }
        });

        th1.start();
        th2.start();
    }
}