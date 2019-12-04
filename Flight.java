
public class Flight {
	protected Time DepTime;
	protected Time ArrTime;
	
	public Flight(Time t1, Time t2) {
		if (t1.minutesUntil(t2) < 0) {
			this.DepTime = new Time(-1);
			this.ArrTime = new Time(-1);
		}
		else {
			this.DepTime = t1;
			this.ArrTime = t2;
		}
	}
	
	
	public Time getDepartureTime() {
		return DepTime;
	}
	
	public Time getArrivalTime() {
		return ArrTime;
	}
	
	public boolean isEarlierFlight(Flight f) {
		if (ArrTime.minutesUntil(f.getDepartureTime()) > 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
