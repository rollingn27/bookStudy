package runaad;

class SMIFileRunnable implements Runnable {
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
}

class VideoFileRunnable implements Runnable {
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
}

public class CreateAndStartThreadRun
{
    public static void main(String[] args)
    {
        Runnable smi = new SMIFileRunnable();
        Runnable vid = new VideoFileRunnable();
        Thread th1 = new Thread(smi);
        Thread th2 = new Thread(vid);
        th2.start();
        th1.start();

    }
}
