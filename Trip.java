import java.util.ArrayList;

public class Trip {
	private ArrayList<Flight> flights;
	
	public Trip() {
		flights = new ArrayList<Flight>();
	}
	
	public void addFlight(Flight f) {
		if (f.getArrivalTime().getTime() != -1) {
			if (flights.size() == 0) {
			flights.add(0,f);
			}
			else {
				int index = 0;
				while ((index < flights.size()) && (!f.isEarlierFlight(flights.get(index)))) {
					index++;
				}
				flights.add(index,f);
			}
		}
	}
	
	public int getDuration() {
		if (flights.size() == 0) {
			return 0;
		}
		else {
			int duration = 0;
			int index = 0;
			while (flights.size() != index) {
				Flight f = flights.get(index);
				Time t1 = f.getDepartureTime();
				Time t2 = f.getArrivalTime();
				duration = duration + t1.minutesUntil(t2);
				index++;
			}
			return duration;
		}
	}
	
	public void showList() {
		for (int i=0;i<flights.size();i++) {
			Flight f = flights.get(i);
			System.out.println("Departure time "+f.getDepartureTime().toString()+"	Arrival time "+f.getArrivalTime().toString());
		}
	}
	
	public int getShortestLayover() {
		if (flights.size() < 2) {
			return -1;
		}
		else {
			int[] layovers = new int[flights.size()-1];
			int index = 0;
			while (flights.size() != (index+1)) {
				Flight f1 = flights.get(index);
				Flight f2 = flights.get(index+1);
				Time t1 = f1.getArrivalTime();
				Time t2 = f2.getDepartureTime();
				layovers[index] = t1.minutesUntil(t2);
				index++;
			}
			for (int out = layovers.length - 1; out >= 1; out--){  
		            for (int in = 0; in < out; in++){       
		                if(layovers[in] > layovers[in + 1]) {
		                	int buff = layovers[in];
		                	layovers[in] = layovers[in+1];
		                	layovers[in+1] = buff;
		                }                         
		            }
		        }
			return layovers[0];
		}
	}
}
