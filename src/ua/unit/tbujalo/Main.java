package ua.unit.tbujalo;

import ua.unit.tbujalo.fileWorker.ReadScenario;

public class Main {

    public static void main(String[] args) {
        if (args.length == 1){
            ReadScenario.readFile(args[0]);
            WeatherTower wt = ReadScenario.getWeatherTower();
            for(int i = 0; i < ReadScenario.getNumbersOfTheTimeNeedSimulate(); ++i){
                wt.changeWeather();
            }
        }else{
            System.out.println("Need enter file name as program arguments");
        }
    }
}
