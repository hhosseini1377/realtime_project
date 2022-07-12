// Importing the required classes
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.*;
import java.lang.management.ManagementFactory;
import java.sql.Time;
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
            System.out.println(time_interval);
        }
    }

    // the main method
    public static void main(String argvs[]) throws Exception {
        TimeCounter timeCounter = new TimeCounter();
        timeCounter.run();
    }
}