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
                System.out.println("It's Sun "+name);
                coordinates.setHeight(coordinates.getHeight() + 4);
                coordinates.setLongitude(coordinates.getLongitude() + 2);
                break;
            case "RAIN":
                System.out.println("It's rain now "+name);
                coordinates.setHeight(coordinates.getHeight() - 5);
                break;
            case "SNOW":
                System.out.println("It's show now "+name);
                coordinates.setHeight(coordinates.getHeight() - 15);
                break;
            case "FOG":
                System.out.println("It's fog now "+name);
                coordinates.setHeight(coordinates.getHeight() - 3);
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
        return "Baloon#" + name +"("+id+")";
    }
}
