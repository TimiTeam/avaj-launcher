package ua.unit.tbujalo.transports;

import ua.unit.tbujalo.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions(){
        if (weatherTower == null)
            return;
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather){
            case "SUN":
                outputWriter.writeMessage(this+": Great clear sky, i'm moving up");
                coordinates.setHeight(coordinates.getHeight() + 4);
                coordinates.setLongitude(coordinates.getLongitude() + 2);
                break;
            case "RAIN":
                outputWriter.writeMessage(this+": I will be strong, I will stand");
                coordinates.setHeight(coordinates.getHeight() - 5);
                break;
            case "SNOW":
                outputWriter.writeMessage(this+": Noo, snow is kill me...");
                coordinates.setHeight(coordinates.getHeight() - 15);
                break;
            case "FOG":
                outputWriter.writeMessage(this+": Don't see the earth...it's scared");
                coordinates.setHeight(coordinates.getHeight() - 3);
                break;
            default:
                System.out.println("Unknown weather  "+name);
                break;
        }
        if (coordinates.getHeight() <= 0){
            outputWriter.writeMessage(this+":   Goodbye I'm down");
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
        return "Baloon#" + name +"("+id+")";
    }
}
