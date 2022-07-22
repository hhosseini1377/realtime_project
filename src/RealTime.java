import java.sql.Time;
import java.time.*;
import java.lang.*;

public class RealTime extends Thread{
    private final String name;
    private final int baseHour;
    private final int baseMinute;
    private final int baseSecond;
    public final TimeCounter timeCounter;

    public void run(){
        while(true) {
            LocalTime localtime
                    = LocalTime.of(baseHour, baseMinute, baseSecond).plusSeconds(timeCounter.time_interval);

            System.out.println("time in " + name + ": "
                    + localtime);
        }

    }
    public RealTime(int baseHour, int baseMinute, int baseSecond, String name, TimeCounter timeCounter){
        this.baseHour = baseHour;
        this.baseMinute = baseMinute;
        this.baseSecond = baseSecond;
        this.name = name;
        this.timeCounter = timeCounter;
    }
}
