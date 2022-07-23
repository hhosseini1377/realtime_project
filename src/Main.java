import java.time.LocalTime;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        TimeCounter timeCounter = new TimeCounter();
        timeCounter.start();
        LocalTime initialTime = LocalTime.now();
        int initialHour = initialTime.getHour(), initialMinute = initialTime.getMinute(),
                initialSecond = initialTime.getSecond();

        ArrayList<Thread> timeThreads = new ArrayList<>();

        //Initializing the threads
        timeThreads.add(new RealTime(initialHour, initialMinute, initialSecond,"Iran", timeCounter));
        timeThreads.add(new RealTime(initialHour, initialMinute,initialSecond, "Italy", timeCounter));
        timeThreads.add(new RealTime(initialHour, initialMinute, initialSecond,"Germany", timeCounter));
        timeThreads.add(new RealTime(initialHour, initialMinute,initialSecond, "England", timeCounter));

        //Initializing the priority of the threads
        timeThreads.get(0).setPriority(1);
        timeThreads.get(1).setPriority(2);
        timeThreads.get(2).setPriority(3);
        timeThreads.get(3).setPriority(4);
        ThreadsManager threadsManager = new ThreadsManager(timeThreads);
        threadsManager.start();

    }
}
