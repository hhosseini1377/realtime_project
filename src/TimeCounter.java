
import java.lang.*;
import java.util.concurrent.TimeUnit;

public class TimeCounter extends Thread
{
    public int time_interval = 0;
    public void run()
    {
        while(true){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            time_interval += 1;
        }
    }

    // the main method
    public static void main(String argvs[]) throws Exception {
        TimeCounter timeCounter = new TimeCounter();
        timeCounter.run();
    }
}