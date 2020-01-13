package ua.unit.tbujalo.transports;

import ua.unit.tbujalo.fileWorker.readException.SyntaxErrorException;
import ua.unit.tbujalo.fileWorker.readException.UnknownTransportException;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws UnknownTransportException, SyntaxErrorException {
        switch (type){
            case "Helicopter":
                return new Helicopter(name, new Coordinates(longitude, latitude, height));
            case "JetPlane":
                return  new JetPlane(name, new Coordinates(longitude, latitude, height));
            case "Baloon":
                return  new Baloon(name, new Coordinates(longitude, latitude, height));
            default:
                throw new UnknownTransportException(type);
        }
    }
}
