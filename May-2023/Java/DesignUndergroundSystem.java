// 1396. Design Underground System
// Algorithm 
// find the difference between the time if both station
// add the time to the totalTime and divide by total count
class UndergroundSystem {
	Map<Integer, Pair<String, Integer>> checkIn;
	Map<String, Pair<Integer, Integer>> checkOut;

	public UndergroundSystem() {
		checkIn = new HashMap<>();
		checkOut = new HashMap<>();
	}

	public void checkIn(int id, String stationName, int t) {

		checkIn.put(id, new Pair<>(stationName, t));
	}

	public void checkOut(int id, String stationName, int t) {

		String entryStation = checkIn.get(id).getKey();
		int entryTime = checkIn.get(id).getValue();
		int totalTime = t - entryTime;
		String route = entryStation + "-" + stationName;

		checkOut.putIfAbsent(route, new Pair<>(0, 0));
		int totalT = checkOut.get(route).getKey() + totalTime;

		int count = checkOut.get(route).getValue() + 1;

		checkOut.put(route, new Pair<>(totalT, count));

		checkIn.remove(id);

	}

	public double getAverageTime(String startStation, String endStation) {
		return (double)(checkOut.get(startStation + "-" + endStation).getKey()) / (checkOut.get(startStation + "-" + endStation).getValue());
	}
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
