import java.util.ArrayList;

public class NecessaryFunctions {
    public static void printListOfStops(ArrayList<Stop> listOfStops){
        Stop tempStop;
        int counter = 0;
        while((tempStop = listOfStops.get(counter)) != null){
            System.out.printf("Stop %d \n", tempStop.getStopId());
        }
    }
}
