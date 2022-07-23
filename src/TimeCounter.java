
import java.lang.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimeCounter extends Thread
{
    public int time_interval = 1;

    private void increaseTimeInterval(){
        time_interval += 1;
    }
    public void run()
    {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                increaseTimeInterval();
            }
        }, 0, 1000);

    }

    // the main method
    public static void main(String argvs[]) throws Exception {
        TimeCounter timeCounter = new TimeCounter();
        timeCounter.run();
    }
}