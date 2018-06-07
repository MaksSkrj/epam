package ua.nure.skrypnyk.practice6.part7;

public class Part7 {
	
	public static void main(String[] args) {
		Range range = new Range(3, 10);

		for (Integer el : range) {
			System.out.printf("%d ", el);
		}
		System.out.println();

		range = new Range(3,10,true);
		System.out.println("reverse range:");
		for (Integer el : range) {
			System.out.printf("%d ", el);
		}
		System.out.println();
	}

}
