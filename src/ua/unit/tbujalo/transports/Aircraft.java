package ua.unit.tbujalo.transports;

import ua.unit.tbujalo.fileWorker.OutputWriter;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;
    protected OutputWriter outputWriter;


    protected Aircraft() {
    }

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
        outputWriter = OutputWriter.getInstance();
    }

    private long nextId(){
        return ++idCounter;
    }
}
