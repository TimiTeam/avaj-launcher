package ua.unit.tbujalo;

import ua.unit.tbujalo.transports.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {
            "SUN",
            "RAIN",
            "SNOW",
            "FOG"
    };

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider(){
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        return weather[(coordinates.getLatitude() + coordinates.getLongitude() + coordinates.getHeight()) % 4];
    }
}
