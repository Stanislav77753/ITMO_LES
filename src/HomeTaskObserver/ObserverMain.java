package HomeTaskObserver;

public class ObserverMain {
    public static void main(String[] args) {
        Sensor sensor = new Sensor();
        sensor.addObserver(new Alarm("Green"));
        sensor.addObserver(new Alarm("Yellow"));
        sensor.addObserver(new Alarm("Red"));
        sensor.tempChanged(100);
        sensor.tempChanged(200);
        sensor.tempChanged(300);
        sensor.tempChanged(400);
        sensor.tempChanged(500);
        sensor.tempChanged(600);
        sensor.tempChanged(90);
        sensor.tempChanged(100);
        sensor.tempChanged(350);
        sensor.tempChanged(650);
    }
}
