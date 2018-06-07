package ua.nure.skrypnyk.practice7.entity;

import java.util.ArrayList;
import java.util.List;

public class OldCards {
    List<OldCard> oldCards;

    public List<OldCard> getOldCards() {
        if (oldCards == null)
            oldCards = new ArrayList<>();
        return oldCards;
    }

    @Override
    public String toString() {
        if(oldCards == null || oldCards.size() == 0){
            return "no old cards";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < oldCards.size(); i++) {
            sb.append(i+1).append(". ").append(oldCards.get(i)).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
