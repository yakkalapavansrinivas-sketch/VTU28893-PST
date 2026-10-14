
import java.util.*;

class UndergroundSystem {

    private Map<Integer, CheckIn> checkIns;
    private Map<String, int[]> journeys;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        journeys = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkIns.remove(id);

        String route = checkIn.station + "->" + stationName;
        int travelTime = t - checkIn.time;

        int[] data = journeys.getOrDefault(route, new int[2]);
        data[0] += travelTime;
        data[1]++;

        journeys.put(route, data);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        int[] data = journeys.get(route);

        return (double) data[0] / data[1];
    }

    private static class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}
