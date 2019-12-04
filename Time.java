
public class Time {
	protected double t;
	protected int hour;
	protected int min;
	
	public Time(double t) {
		this.t=t;
		setTime();
	}
	
	private void setTime() {
		int res=(int)t;
		double res1=t;
		this.hour=res;
		this.min=(int)((res1-res)*100);
	}
	
	public int minutesUntil(Time other) {
		int div;
		div=(other.hour-this.hour)*60+(other.min-this.min);
		return div;
	}
	
	public double getTime() {
		return this.t;
	}
	
	public String toString() {
		String time = hour+":"+min;
		return time;	
	}
}
