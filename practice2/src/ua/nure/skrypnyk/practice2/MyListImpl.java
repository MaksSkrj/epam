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

        if (o == null) {

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null) {
                    System.arraycopy(arr, i + 1, arr, i, arr.length - 1);
                    arr[arr.length - 1] = null;
                    return true;
                }
            }
        } else {

            for (int i = 0; i < arr.length; i++) {
                Object[] help = new Object[arr.length - 1];
                if (o.equals(arr[i])) {
                    arr[i] = null;
                    for (int j = i; j < arr.length; j++) {
                        arr[j] = arr[i + 1];
                    }
                    System.arraycopy(arr, 0, help, 0, arr.length - 1);
                    arr = help;
                    return true;
                }
            }
        }

        return false;
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
