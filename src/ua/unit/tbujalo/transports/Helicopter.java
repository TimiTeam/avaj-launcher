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
                System.out.println("It's Sun "+name);
                coordinates.setHeight(coordinates.getHeight() + 2);
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                break;
            case "RAIN":
                System.out.println("It's rain now "+name);
                coordinates.setLongitude(coordinates.getLongitude() + 5);
                break;
            case "SNOW":
                System.out.println("It's show now "+name);
                coordinates.setHeight(coordinates.getHeight() - 12);
                break;
            case "FOG":
                System.out.println("It's fog now "+name);
                coordinates.setLongitude(coordinates.getLongitude() + 1);
                break;
            default:
                System.out.println("Unknown weather  "+name);
                break;
        }
        if (coordinates.getHeight() <= 0){
            System.out.println("Good by");
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
