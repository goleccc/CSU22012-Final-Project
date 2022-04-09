import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ObjectCreation {
    private static ArrayList<Trip> listOfTrips = new ArrayList<>();
    public static void createAllStops(){
        ArrayList<String> stopTimesStrings = new ArrayList<>();
        String temp;
        ArrayList<Stop> listOfStops = new ArrayList<>();
        try {
            BufferedReader file = new BufferedReader(new FileReader("stops.txt"));
            temp = file.readLine();
            while((temp = file.readLine()) != null){
                stopTimesStrings.add(temp);
            }
            int counter = 0;
            String temp2;
            String[] stopChopped;
            while(counter < stopTimesStrings.size()){
                temp2 = stopTimesStrings.get(counter);
                stopChopped = temp2.split(",", 4);
                Stop tempStop = new Stop(Integer.parseInt(stopChopped[0]), stopChopped[2]);
                listOfStops.add(tempStop);
                System.out.printf("BREAKPOINT 1, CURRENT STOP: %d\n", counter);
                counter++;
            }
            file.close();
        } catch(NullPointerException e)
        {

        } catch(Exception e) {
            e.printStackTrace();
        }

        ArrayList<String[]> listOfStopTimes = new ArrayList<>();
        String[] tempArray = new String[2];
        try {
            BufferedReader file = new BufferedReader(new FileReader("stop_times.txt"));
            temp = file.readLine();
            while((temp = file.readLine()) != null){
                stopTimesStrings.add(temp);
                //System.out.printf("BREAKPOINT 2");
            }
            int counter = 0;
            String temp2;
            String[] stopChopped;
            while(counter < stopTimesStrings.size()){
                temp2 = stopTimesStrings.get(counter);
                stopChopped = temp2.split(",", 6);
                tempArray[0] = stopChopped[0];
                tempArray[1] = stopChopped[2];
                listOfStopTimes.add(tempArray);
                //System.out.printf("BREAKPOINT 3");
                counter++;
            }
            file.close();
        } catch(NullPointerException e)
        {

        } catch(Exception e) {
            e.printStackTrace();
        }

        int counter = 0;
        Stop tempStop;
        Trip tempTrip = new Trip(0);
        int stopLocation;
        int currentTripId = 0;
        if(listOfStops != null){
            while(counter < listOfStopTimes.size()){
                tempArray = listOfStopTimes.get(counter);
                if(currentTripId != Integer.parseInt(tempArray[0])){
                    if(currentTripId != 0){
                        listOfTrips.add(tempTrip);
                    }
                    currentTripId = Integer.parseInt(tempArray[0]);
                    tempTrip = new Trip(currentTripId);
                    System.out.printf("BREAKPOINT 4");
                }
                stopLocation = findStopInList(Integer.parseInt(tempArray[0]), listOfStops);
                if(stopLocation > -1){
                    tempStop = listOfStops.get(stopLocation);
                    tempTrip.addStop(tempStop);
                }
                counter++;
            }
        }
    }

    public static int findStopInList(int stopId, ArrayList<Stop> listOfStops){
        Stop temp;
        int counter = 0;
        while(counter < listOfStops.size()){
            temp = listOfStops.get(counter);
            if(temp.getStopId() == stopId) return counter;
            counter++;
            //System.out.printf("BREAKPOINT 5, CURRENT COUNTER: %d\n", counter);
        }
        return -1;
    }
    public static int findTripInList(int stopId, ArrayList<Trip> listOfTrip){
        Trip temp;
        int counter = 0;
        while(counter < listOfTrip.size()){
            temp = listOfTrip.get(counter);
            if(temp.getTripId() == stopId) return counter;
            counter++;
            System.out.printf("BREAKPOINT 6");
        }
        return -1;
    }

    public static Trip getTrip(int tripId){
        int tripLocation = findTripInList(tripId, listOfTrips);
        Trip tempTrip = null;
        if(tripLocation > -1){
            tempTrip = listOfTrips.get(tripLocation);
        }
        return tempTrip;
    }
}

