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
                break;
            case "RAIN":
                System.out.println("It's rain now "+name);
                break;
            case "SNOW":
                System.out.println("It's show now "+name);
                break;
            case "FOG":
                System.out.println("It's fog now "+name);
                break;
            default:
                System.out.println(" Unknown weather  "+name);
                break;
        }
    }

    @Override
    public void registerTower(WeatherTower tower){
        this.weatherTower = tower;
        tower.register(this);
    }
}
