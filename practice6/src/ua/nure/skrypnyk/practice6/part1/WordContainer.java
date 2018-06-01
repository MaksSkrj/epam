package ua.nure.skrypnyk.practice6.part1;


import java.util.ArrayList;
import java.util.List;


// you can extend this class from one of the core container
// or aggregate it inside of class 
public class WordContainer {
    List<Word> wordList = new ArrayList<Word>();


    public void add(Word element) {
        boolean increase = false;
        if (wordList.size() == 0) {
            wordList.add(element);
        } else {
            for (int i = 0; i < wordList.size(); i++) {
                if (wordList.get(i).getWord().equals(element.getWord())) {
                    wordList.get(i).addFrequency();
                    increase = true;
                }
            }
            if (!increase) {
                wordList.add(element);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Word w: wordList) {
            sb.append(w.getWord()).append(":").append(w.getFrequency()).append(System.lineSeparator());

        }
        return sb.toString();
    }
}
