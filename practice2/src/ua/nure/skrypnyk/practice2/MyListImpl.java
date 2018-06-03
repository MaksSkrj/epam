package ua.nure.skrypnyk.practice2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyListImpl implements MyList, ListIterable {

    private Object[] arr = new Object[0];

    @Override
    public void add(Object o) {
        grow(arr.length + 1);
        arr[arr.length - 1] = o;
    }

    public void grow(int newSize) {
        Object[] newArr = new Object[newSize];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    @Override
    public void clear() {
        arr = new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        Object[] newData = new Object[arr.length - 1];
        int index = getFirstIndexOfExistingElement(o);
        if (index == -1)
            return false;
        Object[] dataFirstHalf = Arrays.copyOf(arr, index);
        if (index == arr.length - 1) {
            System.arraycopy(arr, 0, newData, 0, arr.length - 1);
        } else {
            Object[] dataSecondHalf = Arrays.copyOfRange(arr, index + 1, arr.length);
            System.arraycopy(dataFirstHalf, 0, newData, 0, dataFirstHalf.length);
            System.arraycopy(dataSecondHalf, 0, newData, dataFirstHalf.length, dataSecondHalf.length);
        }
        arr = newData;
        return true;
    }

    private int getFirstIndexOfExistingElement(Object o) {
        for (int i = 0; i < arr.length; i++) {
            if (o == null) {
                if (arr[i] == null)
                    return i;
            } else {
                if (o.equals(arr[i]))
                    return i;
            }
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
       return arr;
    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public boolean contains(Object o) {
        for (Object x : arr) {
            if (o.equals(x)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(MyList c) {
        Object[] inputList = c.toArray();
        boolean containsAll = true;
        for (Object element : inputList) {
            if (!contains(element))
                containsAll = false;
        }
        return containsAll;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        int current = -1;
        int indexOfLastReturned = -1;

        public boolean hasNext() {
            return current < arr.length - 1;
        }

        public Object next() {
            if (current + 1 >= arr.length)
                throw new NoSuchElementException();
            indexOfLastReturned = current + 1;
            return arr[++current];
        }

        public void remove() {
            if (indexOfLastReturned == -1)
                throw new IllegalStateException();
            MyListImpl.this.remove(arr[indexOfLastReturned]);
            current--;
            indexOfLastReturned = -1;
        }
    }

    @Override
    public ListIterator listIterator() {
        return new ListIteratorImpl();
    }

    private class ListIteratorImpl extends IteratorImpl implements ListIterator {
        @Override
        public boolean hasPrevious() {
            return current != -1;
        }

        @Override
        public Object previous() {
            if (current == -1)
                throw new NoSuchElementException();
            indexOfLastReturned = current;
            return arr[current--];
        }

        @Override
        public void set(Object e) {
            if (indexOfLastReturned == -1)
                throw new IllegalStateException();
            arr[indexOfLastReturned] = e;
            indexOfLastReturned = -1;
        }
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                s += arr[i] + " ";
            } else {
                s += arr[i];
            }
        }
        s += "]";
        return s;
    }


}
