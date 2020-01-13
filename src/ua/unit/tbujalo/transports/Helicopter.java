package ua.unit.tbujalo.transports;

import ua.unit.tbujalo.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions(){
        if (weatherTower == null)
            return;
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather){
            case "SUN":
                outputWriter.writeMessage(this+": Sky is clear ");
                coordinates.setHeight(coordinates.getHeight() + 2 < 100 ? coordinates.getHeight() + 2 : 100);
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                break;
            case "RAIN":
                outputWriter.writeMessage(this+": Brings me..");
                coordinates.setLongitude(coordinates.getLongitude() + 5);
                break;
            case "SNOW":
                outputWriter.writeMessage(this+": Snow is not good for me");
                coordinates.setHeight(coordinates.getHeight() - 12);
                break;
            case "FOG":
                outputWriter.writeMessage(this+": Everything is so gray");
                coordinates.setLongitude(coordinates.getLongitude() + 1);
                break;
            default:
                System.out.println("Unknown weather  "+name);
                break;
        }
        if (coordinates.getHeight() <= 0){
            outputWriter.writeMessage(this+": I'm going down");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower tower){
        this.weatherTower = tower;
        tower.register(this);
    }

    @Override
    public String toString() {
        return "Helicopter#"+name+"("+id+")";
    }
}
