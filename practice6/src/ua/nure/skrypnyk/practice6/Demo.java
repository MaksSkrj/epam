package ua.nure.skrypnyk.practice6;


import ua.nure.skrypnyk.practice6.part1.Part1;
import ua.nure.skrypnyk.practice6.part2.Part2;
import ua.nure.skrypnyk.practice6.part3.Part3;
import ua.nure.skrypnyk.practice6.part4.Part4;
import ua.nure.skrypnyk.practice6.part5.Part5;
import ua.nure.skrypnyk.practice6.part6.Part6;

public class Demo {
	
	public static void main(String[] args) throws Exception {
		System.out.println("~~~~~~~~~~~~Part1");
		Part1.main(args);

		System.out.println("~~~~~~~~~~~~Part2");
		Part2.main(args);

		System.out.println("~~~~~~~~~~~~Part3");
		Part3.main(args);

		System.out.println("~~~~~~~~~~~~Part4");
		Part4.main(args);

		System.out.println("~~~~~~~~~~~~Part5");
		Part5.main(args);


		System.out.println("~~~~~~~~~~~~Part6");
		System.out.println("frequency: ");
		Part6.main(new String[]{"-i", "practice6part6.txt", "-t", "frequency"});
		System.out.println();
		System.out.println("length: ");
		Part6.main(new String[]{"-i", "practice6part6.txt", "-t", "length"});
		System.out.println();
		System.out.println("duplicates: ");
		Part6.main(new String[]{"-i", "practice6part6.txt", "-t", "duplicates"});
//
//		System.out.println("~~~~~~~~~~~~Part7");
//		ua.nure.your_last_name.Practice6.part7.Part7.main(args);
	}

}