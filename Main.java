
public class Main {
	public static void main(String[] args) {
		Time t1 = new Time(11.30);
		Time t2 = new Time(12.15);
		System.out.println(t1.minutesUntil(t2));
		System.out.println(t2.minutesUntil(t1));
		Time t3 = new Time(13.15);
		Time t4 = new Time(15.45);
		Time t5 = new Time(16.00);
		Time t6 = new Time(18.45);
		Time t7 = new Time(22.15);
		Time t8 = new Time(23.00);
		Flight f0 = new Flight(t1,t2);
		Flight f1 = new Flight(t3,t4);
		Flight f2 = new Flight(t5,t6);
		Flight f3 = new Flight(t7,t8);
		Trip vacation = new Trip();
		vacation.addFlight(f0);
		vacation.addFlight(f1);
		vacation.addFlight(f2);
		vacation.addFlight(f3);
		vacation.showList();
		System.out.println("All duration of flights is "+vacation.getDuration());
		System.out.println("The shortes layover is "+vacation.getShortestLayover());
	}
}