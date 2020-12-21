import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileName = args[0];
        Station stationsList = stationsInCurrentLine(fileName);
        printStations(stationsList);
    }

    private static Station stationsInCurrentLine(String file) {

        Station iterator = Station.from("", null);
        Station stationsInLine = iterator;

        try (BufferedReader buff = new BufferedReader(new FileReader(file))) {
            String stationName = null;
            while ((stationName = buff.readLine()) != null) {
                iterator.setNextStation(Station.from(stationName, null));
                iterator = iterator.getNextStation();
            }
        } catch (IOException e) {
            System.out.println(" Error : File doesn't exist");
        }

        return stationsInLine.getNextStation();
    }

    private static void printStations(Station stationsList) {

        String previousStation = "depot";
        String nextStation = "depot";

        while (stationsList != null) {
            String currStation = stationsList.getName();
            stationsList = stationsList.getNextStation();

            if (stationsList != null) {
                nextStation = stationsList.getName();
            } else {
                nextStation = "depot";
            }

            System.out.println(previousStation + " - " + currStation + " - " + nextStation);

            previousStation = currStation;
        }
    }
}
