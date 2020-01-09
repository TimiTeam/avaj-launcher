package ua.unit.tbujalo;

import ua.unit.tbujalo.transports.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable)
    {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    protected void conditionsChanged(){
        this.observers.forEach(Flyable::updateConditions);

    }
}
