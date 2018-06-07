package ua.nure.skrypnyk.practice6.part7;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {

    private int[] elements;

    public Range(int n, int m) {
        this(n, m, false);
    }

    public Range(int n, int m, boolean reverse) {
        if (m <= n)
            throw new IllegalArgumentException();

        int length = m - n + 1;
        elements = new int[length];

        if (reverse) {
            for (int i = 0; i < length; i++) {
                elements[i] = m--;
            }
        } else {
            for (int i = 0; i < length; i++) {
                elements[i] = n++;
            }
        }

    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }

    private class RangeIterator implements Iterator<Integer>{
        private int cursor = -1;
        private int lastReturnedIndex = -1;

        @Override
        public boolean hasNext() {
            return cursor < elements.length - 1;
        }

        @Override
        public Integer next() {
            if (cursor + 1 >= elements.length)
                throw new NoSuchElementException();
            lastReturnedIndex = cursor + 1;
            return elements[++cursor];
        }

    }


}
