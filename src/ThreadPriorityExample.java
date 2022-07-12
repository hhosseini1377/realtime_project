// Importing the required classes
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.*;
import java.lang.management.ManagementFactory;

public class ThreadPriorityExample extends Thread
{
    public int time = 0;

    public static double getProcessCpuLoad() throws Exception {

        MBeanServer mbs    = ManagementFactory.getPlatformMBeanServer();
        ObjectName name    = ObjectName.getInstance("java.lang:type=OperatingSystem");
        AttributeList list = mbs.getAttributes(name, new String[]{ "ProcessCpuLoad" });

        if (list.isEmpty())     return Double.NaN;

        Attribute att = (Attribute)list.get(0);
        Double value  = (Double)att.getValue();

        // usually takes a couple of seconds before we get real values
        if (value == -1.0)      return Double.NaN;
        System.out.println(value);
        // returns a percentage value with 1 decimal point precision
        return ((int)(value * 1000) / 10.0);
    }

    public void run()
    {
        System.out.println("Inside the run() method");
    }

    // the main method
    public static void main(String argvs[]) throws Exception {
        ThreadPriorityExample th1 = new ThreadPriorityExample();
        ThreadPriorityExample th2 = new ThreadPriorityExample();
        ThreadPriorityExample th3 = new ThreadPriorityExample();

        th1.setPriority(6);
        th2.setPriority(3);
        th3.setPriority(9);

        System.out.println(th1.time);


        Thread.currentThread().setPriority(10);
    }
}