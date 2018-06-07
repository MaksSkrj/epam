package ua.nure.skrypnyk.practice6.part3;

public class Part3 {
	
	public static void main(String[] args) {
		Parking parking = new Parking(10);
		System.out.println(parking.toString());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		parking.add("car1");
		parking.add("car2");
		parking.add("car3");
		parking.add("car4");
		parking.add("car5");
		parking.add("car6");
		System.out.println(parking.toString());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		parking.remove("car3");
		parking.remove("car5");
		System.out.println(parking.toString());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		parking.add("car7");
		System.out.println(parking.toString());

	}

}
