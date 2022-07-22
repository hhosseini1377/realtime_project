import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int MAX_T = 4;

    public static void main(String[] args) {

        TimeCounter timeCounter = new TimeCounter();
        LocalTime initialTime = LocalTime.now();
        int initialHour = initialTime.getHour(), initialMinute = initialTime.getMinute(),
                initialSecond = initialTime.getSecond();

        Thread[] timeThreads = new Thread[MAX_T];
        timeThreads[0] = new RealTime(initialHour, initialMinute, initialSecond,"iran", timeCounter);
        timeThreads[1] = new RealTime(initialHour, initialMinute,initialSecond, "italy", timeCounter);
        timeThreads[2] = new RealTime(initialHour, initialMinute, initialSecond,"germany", timeCounter);
        timeThreads[3] = new RealTime(initialHour, initialMinute,initialSecond, "englandTime", timeCounter);
        ThreadsManager threadsManager = new ThreadsManager(timeThreads);
        threadsManager.start();

    }
}
