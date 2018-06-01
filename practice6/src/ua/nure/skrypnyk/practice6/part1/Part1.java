package ua.nure.skrypnyk.practice6.part1;

public class Part1 {

	public static void main(String[] args) {
		WordContainer wc = new WordContainer();

		String s = "asd asdf asd asdf asdf 43 asdsf 43 43 434";
		System.out.println(s);

		String[] splitArray = s.split(" ");

		for (String s1: splitArray) {
			wc.add(new Word(s1));
		}

		System.out.println(wc.toString());


	}

}
