import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String fileName = args[0];
        HashMap<String, DoublyLinkedList<String>> lanesList = readLanes(fileName);
        runCommands(lanesList);
    }

    private static void runCommands(HashMap<String, DoublyLinkedList<String>> lanesList) {
        String regex = "^\\/(?<command>[^\\s]+)( (?<lane>([^\"\\s]*)|(\"[^\"]+\")))?( (?<station>([^\\s]*)|(\"[^\"]+\")))?$";
        Pattern pattern = Pattern.compile(regex);

        Scanner sc = new Scanner(System.in);
        String input = null;

        while ((input = sc.nextLine()) != null) {
            Matcher matcher = pattern.matcher(input);
            matcher.find();

            String command = sanitize(matcher.group("command"));
            String laneName = sanitize(matcher.group("lane"));
            String stationName = sanitize(matcher.group("station"));

            DoublyLinkedList<String> stationsList = lanesList.get(laneName);

            switch (command) {
                case "append" : {
                    stationsList.addLast(stationName);
                    break;
                }
                case "add-head" : {
                    stationsList.addFirst(stationName);
                    break;
                }
                case "remove" : {
                    lanesList.remove(laneName);
                    break;
                }
                case "output" : {
                    printLane(lanesList.get(laneName));
                    break;
                }
                default: {
                    System.out.println("Invalid command");
                }
            }
        }
    }

    private static HashMap<String, DoublyLinkedList<String>> readLanes(String fileName) {
        HashMap<String, DoublyLinkedList<String>> lanesList = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            JsonParser parser = new JsonParser();
            JsonObject parent = parser.parse(reader).getAsJsonObject();
            Set<String> lanes = parent.keySet();

            lanes.forEach(lane -> lanesList.put(lane, readLane(parent.get(lane).getAsJsonObject())));

        } catch (IOException e) {
            System.out.println(" Error : File doesn't exist");
        }

        return lanesList;
    }

    private static DoublyLinkedList<String> readLane(JsonObject laneObject) {
        DoublyLinkedList<String> stations = new DoublyLinkedList<String>();

        Set<Map.Entry<String, JsonElement>> lane = laneObject.entrySet();
        lane.forEach(station -> stations.addLast(station.getValue().getAsString()));

        return stations;
    }


    private static void printLane(DoublyLinkedList<String> stationsList) {

        String previousStation = "depot";
        String nextStation = "depot";
        Node<String> iterator = stationsList.getHead();

        while (iterator != null) {
            String currStation = iterator.getValue();
            iterator = iterator.getNext();

            if (iterator != null) {
                nextStation = iterator.getValue();
            } else {
                nextStation = "depot";
            }

            System.out.println(previousStation + " - " + currStation + " - " + nextStation);

            previousStation = currStation;
        }
    }

    private static String sanitize(String str) {
        return (str != null ? str.replace("\"", "").trim() : null);
    }
}
