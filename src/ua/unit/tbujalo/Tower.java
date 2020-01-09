package ua.unit.tbujalo;

import ua.unit.tbujalo.transports.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable)
    {
        observers.add(flyable);
        System.out.println("Tower says: "+flyable+" registered to weather tower.");
    }

    public void unregister(Flyable flyable){
        if(observers.remove(flyable))
            System.out.println("Tower says: "+flyable+" unregistered to weather tower.");
    }

    protected void conditionsChanged(){
        //this.observers.forEach(Flyable::updateConditions);
        for(Flyable flyable : observers){
            flyable.updateConditions();
        }
    }
}
