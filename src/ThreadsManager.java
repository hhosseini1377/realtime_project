import java.lang.*;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class ThreadsManager extends Thread
{
    private final Thread[] timeThreads;

    public void run()
    {
        for (Thread t:
             timeThreads) {
            t.start();
        }
    }

    // the main method
    public static void main(String argvs[]) throws Exception {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class);

        while(true) {
            Double CpuUsage = osBean.getSystemCpuLoad();
            if(!Double.isNaN(CpuUsage))
                System.out.println(CpuUsage);
        }
    }

    public ThreadsManager(Thread[] timeThreads){
        this.timeThreads = timeThreads;
    }
}