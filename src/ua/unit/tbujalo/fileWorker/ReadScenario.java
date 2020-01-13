package ua.unit.tbujalo.fileWorker;

import ua.unit.tbujalo.WeatherTower;
import ua.unit.tbujalo.transports.AircraftFactory;
import ua.unit.tbujalo.transports.Flyable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class ReadScenario {
    private static ReadScenario readScenario = new ReadScenario();
    private AircraftFactory factory;
    private String fileName;
    private int repeatTimes;
    private WeatherTower weatherTower;

    private ReadScenario() {
        fileName = "";
        repeatTimes = 0;
        weatherTower = new WeatherTower();
        factory = new AircraftFactory();
    }

    private Flyable getAircraftFromString(String line, int numLine) throws Exception {
        String splitted[] = line.split(" ");
        if (splitted.length != 5)
            throw new ParseException("Wrong aircraft properties", numLine);
        return factory.newAircraft(splitted[0], splitted[1], Integer.parseInt(splitted[2]), Integer.parseInt(splitted[3]), Integer.parseInt(splitted[4]));
    }

    public static boolean readFile(String fileName){
        readScenario.fileName = fileName;
        WeatherTower weatherTower = new WeatherTower();
        String line = "";
        int i = 1;
        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))){
           line = bf.readLine();
            readScenario.repeatTimes = Integer.parseInt(line);
            for (; (line = bf.readLine()) != null; ++i){
                readScenario.getAircraftFromString(line, i).registerTower(weatherTower);
            }
        }catch (IOException e){
            System.err.println("Error opening file: "+fileName);
            return false;
        }
        catch (Exception e){
            System.out.println("Error reading from file: "+fileName+" at line: "+i+": "+line);
            return false;
        }
        readScenario.weatherTower = weatherTower;
        return true;
    }

    public static int getNumbersOfTheTimeNeedSimulate(){
        return readScenario.repeatTimes;
    }

    public static WeatherTower getWeatherTower(){
        return readScenario.weatherTower;
    }
}