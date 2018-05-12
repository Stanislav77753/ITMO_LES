package HomeTaskObserver;

import java.util.ArrayList;
import java.util.List;

public class Sensor implements Observable {
    private int temp;
    List<Observer> observers = new ArrayList<>();

    void tempChanged(int temp){
        this.temp = temp;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.handleEvent(temp);
        }
    }
}
