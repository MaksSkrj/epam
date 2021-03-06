package ua.nure.skrypnyk.practice6.part2;

import java.util.LinkedList;
import java.util.List;

public class ViaLinkedList {
    List arrayList = new LinkedList();

    public void testSpeedOfLinkedList(int k){
        int counter = 0;

        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }

        while (arrayList.size() != 1){
            counter = (counter + k - 1) % arrayList.size();
            arrayList.remove(counter);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i)).append(" ");
        }
        return sb.toString();
    }
}
