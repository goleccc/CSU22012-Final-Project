import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ObjectCreation {
    public void createAllStops(){
        ArrayList<String> stopTimesStrings = null;
        String temp;
        try {
            BufferedReader file = new BufferedReader(new FileReader("stops.txt"));
            while((temp = file.readLine()) != null){
                stopTimesStrings.add(temp);
            }
            int counter = 0;
            String temp2;
            String[] stopChopped;
            ArrayList<Stop> listOfStops = null;
            while(stopTimesStrings.get(counter) != null){
                temp2 = stopTimesStrings.get(counter);
                stopChopped = temp2.split(", ", 4);
                Stop tempStop = new Stop(Integer.parseInt(stopChopped[0]), stopChopped[2]);
                listOfStops.add(tempStop);
            }
            file.close();
        } catch(NullPointerException e)
        {

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
