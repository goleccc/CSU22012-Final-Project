import java.util.ArrayList;

public class Trip {
    private int tripId = 0;
    private ArrayList<Stop> listOfStops = null;

    Trip(int tripId){
        this.tripId = tripId;
    }

    void addStop(Stop stop){
        listOfStops.add(stop);
    }
    public ArrayList<Stop> getListOfStops() {
        return listOfStops;
    }

    public int getTripId(){
        return tripId;
    }

    public boolean containsStop(Stop stop){
        if(listOfStops != null){
            int counter = 0;
            Stop temp = listOfStops.get(counter);
            while(temp != null) {
                if (temp == stop) return true;
                counter++;
                temp = listOfStops.get(counter);
            }
        }
        return false;
    }

    public int stopAtIndex(Stop stop){
        if(listOfStops != null){
            if(containsStop(stop)){
                int counter = 0;
                Stop temp = listOfStops.get(counter);
                while(temp != null) {
                    if (temp == stop) return counter;
                    counter++;
                    temp = listOfStops.get(counter);
                }
            }
            return -1;
        }
        return -1;
    }

    public ArrayList<Stop> getSublistOfStops(Stop start, Stop end){
        if(listOfStops != null){
            if(stopAtIndex(start) < stopAtIndex(end)){
                ArrayList<Stop> sublistOfStops = null;
                int counter = stopAtIndex(start);
                while(counter <= stopAtIndex(end)){
                    sublistOfStops.add(listOfStops.get(counter));
                    counter++;
                }
                return sublistOfStops;
            }
            else return null;
        }
        return null;
    }
}
