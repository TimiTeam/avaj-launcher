package ua.unit.tbujalo.transports;

import ua.unit.tbujalo.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}
