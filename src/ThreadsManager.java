import java.lang.*;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;

import com.sun.management.OperatingSystemMXBean;

public class ThreadsManager extends Thread
{
    final ArrayList<Thread> timeThreads;
    ArrayList<Thread> suspendedThreads= new ArrayList<>();
    ArrayList<Thread> runningThreads = new ArrayList<>();
    enum State{
        LOW,
        MEDIUM,
        HIGH,
    }

    private void suspendThread(){
        Thread lowPriorityThread = findLowestPriorityThread(runningThreads);
        lowPriorityThread.suspend();
        runningThreads.remove(lowPriorityThread);
        suspendedThreads.add(lowPriorityThread);
    }
    private void resumeThread(){
        Thread highPriorityThread = findHighestPriorityThread(suspendedThreads);
        highPriorityThread.suspend();
        runningThreads.add(highPriorityThread);
        suspendedThreads.remove(highPriorityThread);
    }

    private Thread findHighestPriorityThread(ArrayList<Thread> threads){
        Thread highestPriorityThread = threads.get(0);
        for (Thread t:
                threads) {
            if (highestPriorityThread.getPriority() > t.getPriority()) {
                highestPriorityThread = t;
            }
        }
        return highestPriorityThread;
    }

    private Thread findLowestPriorityThread(ArrayList<Thread> threads){
        Thread highestPriorityThread = threads.get(0);
        for (Thread t:
                threads) {
            if(highestPriorityThread.getPriority() < t.getPriority()){
                highestPriorityThread = t;
            }
        }
        return highestPriorityThread;
    }

    public void run()
    {
        for (Thread t:
             timeThreads) {
            runningThreads.add(t);
            t.start();
        }


        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class);

        State state = State.LOW;

        while(true){
            double cpuLoad = osBean.getSystemCpuLoad();
            if(!Double.isNaN(cpuLoad)){
                switch (state){
                    case LOW:
                        if(cpuLoad > 0.7){
                           state = State.MEDIUM;
                           suspendThread();
                           suspendThread();
                        }
                    case MEDIUM:
                        if(cpuLoad < 0.7){
                            state = State.LOW;
                            resumeThread();
                            resumeThread();
                        } else if (cpuLoad > 0.9) {
                            state = State.HIGH;
                            suspendThread();
                        }
                    case HIGH:
                        if(cpuLoad < 0.9){
                            state = State.MEDIUM;
                            resumeThread();
                        }
                }
            }
        }


    }


    public ThreadsManager(ArrayList<Thread> timeThreads){
        this.timeThreads = timeThreads;
    }
}