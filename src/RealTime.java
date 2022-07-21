import java.time.*;
import java.time.temporal.*;
import java.lang.*;

public class RealTime extends Thread{
    private int baseHour;
    private int baseMinute;

    public static void showTime(int timeInterval){
        LocalTime localtime
                = LocalTime.of(6, 5, 40).plusSeconds(timeInterval);

        System.out.println("TIME: "
                + localtime);

    }

    public static void main(String[] args) {
        showTime(1);
    }
}
