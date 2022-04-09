public class Stop {
    private int stopId;
    private String stopName;

    Stop(int stopId, String stopName){
        this.stopId = stopId;
        this.stopName = stopName;
        if(stopName.indexOf("FLAGSTOP ") != -1 || stopName.indexOf("WB ") != -1 ||
                stopName.indexOf("NB ") != -1 || stopName.indexOf("SB ") != -1 ||
                stopName.indexOf("EB ") != -1){
            String[] split = stopName.split("\\s", 2);
            this.stopName = split[1] + " " + split[0];
        }
    }

    int getStopId(){
        if(stopId != 0) {
            return stopId;
        }
        else return -1;
    }

    String getStopName(){
        if(stopName != null) return stopName;
        else return "null";
    }
}
