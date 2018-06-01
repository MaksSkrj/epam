package ua.nure.skrypnyk.practice6.part2;

public class Part2 {

    public static void main(String[] args) {
        ViaArrayList val = new ViaArrayList();
        ViaLinkedList vll = new ViaLinkedList();
        int k = 7;
        Long before;
        Long after;


        before = System.currentTimeMillis();
        val.testSpeedOfArrayList(k);
        after = System.currentTimeMillis() - before;
        System.out.println(val.toString());
        System.out.println("ArrayList time: " + after);


        before = System.currentTimeMillis();
        vll.testSpeedOfLinkedList(k);
        after = System.currentTimeMillis() - before;
        System.out.println(vll.toString());
        System.out.println("LinkedList time: " + after);
    }

}
