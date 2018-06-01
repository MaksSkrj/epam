package ua.nure.skrypnyk.practice6.part1;

public class Word {
	
	private String word;
	
	private int frequency;

	public Word(String word) {
		this.word = word;
		frequency = 1;
	}

	public void addFrequency(){
		setFrequency(getFrequency() + 1);
	}

	public String getWord() {
		return word;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return  word + ":" + frequency + System.lineSeparator();
	}
}
