public class main {

    public static void main(String[] args) {

        TimeCounter timeCounter = new TimeCounter();
        RealTime iranTime = new RealTime(6, 30, "iran", timeCounter);
        RealTime italyTime = new RealTime(10, 30, "italy", timeCounter);
        timeCounter.start();
        iranTime.start();
        italyTime.start();
    }
}
