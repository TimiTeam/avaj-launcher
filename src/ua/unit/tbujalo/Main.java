package ua.unit.tbujalo;

import ua.unit.tbujalo.transports.AircraftFactory;
import ua.unit.tbujalo.transports.Flyable;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        WeatherTower weatherTower = new WeatherTower();
        AircraftFactory factory = new AircraftFactory();
        String aircraftNames[] = {"Helicopter", "Baloon", "JetPlane"};
        String transportNames[] = {"H1", "B1", "J1"};
        try {
            for (int i = 0; i < aircraftNames.length; ++i) {
                factory.newAircraft(aircraftNames[i], transportNames[i], new Random().nextInt(100), new Random().nextInt(100), new Random().nextInt(100)).registerTower(weatherTower);
            }
        }
        catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
        weatherTower.changeWeather();
    }
}
