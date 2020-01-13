package ua.unit.tbujalo;

import ua.unit.tbujalo.fileWorker.OutputWriter;
import ua.unit.tbujalo.transports.Flyable;

import java.util.*;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable)
    {
        observers.add(flyable);
        OutputWriter.getInstance().writeMessage("Tower says: "+flyable+" registered to weather tower.");
    }

    public void unregister(Flyable flyable){
        if(observers.remove(flyable))
            OutputWriter.getInstance().writeMessage("Tower says: "+flyable+" unregistered to weather tower.");
    }

    protected void conditionsChanged(){
        ArrayList<Flyable> list = new ArrayList<>(observers);
        list.forEach(Flyable::updateConditions);
    }
}
