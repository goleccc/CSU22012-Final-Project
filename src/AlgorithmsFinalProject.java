import java.util.ArrayList;

public class AlgorithmsFinalProject {
    public static void main(String[] args) {
        ObjectCreation.createAllStops();
        Trip tempTrip = ObjectCreation.getTrip(9017927);
        ArrayList<Stop> listOfStops = tempTrip.getListOfStops();
        ArrayList<Stop> sublistOfStops = tempTrip.getSublistOfStops(381, 68);
        NecessaryFunctions.printListOfStops(listOfStops);
        NecessaryFunctions.printListOfStops(sublistOfStops);
    }
}
