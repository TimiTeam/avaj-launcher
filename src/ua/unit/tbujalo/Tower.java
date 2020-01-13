package ua.unit.tbujalo;

import ua.unit.tbujalo.transports.Flyable;

import java.util.*;

public class Tower {
    private List<Flyable> observers = new LinkedList<>();

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
        Set<Flyable> set = new HashSet<>(observers);

        set.forEach(Flyable::updateConditions);
    }
}
