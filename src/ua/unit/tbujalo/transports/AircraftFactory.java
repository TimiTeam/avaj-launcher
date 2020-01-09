package ua.unit.tbujalo.transports;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws Exception {
        switch (type){
            case "Helicopter":
                return new Helicopter(name, new Coordinates(longitude, latitude, height));
            case "JetPlane":
                return  new JetPlane(name, new Coordinates(longitude, latitude, height));
            case "Baloon":
                return  new Baloon(name, new Coordinates(longitude, latitude, height));
            default:
                throw new Exception("Undefine aircraft transport");
        }
    }
}
