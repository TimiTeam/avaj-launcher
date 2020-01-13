package ua.unit.tbujalo.transports;

import ua.unit.tbujalo.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions(){
        if (weatherTower == null)
            return;
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather){
            case "SUN":
                outputWriter.writeMessage(this+": *Who loves the sun? Pa-pa-pa-pa. Who loves the sun?* (sing 'Velvet Underground - Who Loves the Sun')");
                coordinates.setHeight(coordinates.getHeight() + 2 < 100 ? coordinates.getHeight() + 2 : 100);
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                break;
            case "RAIN":
                outputWriter.writeMessage(this+": I think i'm going South...");
                coordinates.setLatitude(coordinates.getLatitude() + 5);
                break;
            case "SNOW":
                outputWriter.writeMessage(this+": Shit i'm going down.. oh shit!!");
                coordinates.setHeight(coordinates.getHeight() - 7);
                break;
            case "FOG":
                outputWriter.writeMessage(this+": I don't scare the fog");
                coordinates.setLatitude(coordinates.getLatitude() + 1);
                break;
            default:
                System.out.println("Unknown weather  "+name);
                break;
        }
        if (coordinates.getHeight() <= 0){
            outputWriter.writeMessage(this+": Wshuh!");
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
        return "JetPlane#"+name+"("+id+")";
    }
}
