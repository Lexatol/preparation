package HomeWork2.Task2;
/*
Реализовать собственный ArrayList.
*/

public class MyArray<T> {
    private Object[] array;
    private int capacity = 10;
    private int size = 0;

    public MyArray() {
        array = new Object[capacity];
    }

    public void add(T obj) {
        if (size == capacity - 1) {
           array = copyArray(array,capacity * 2);
        }
        array[size++] = obj;
    }

    public T get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("The requested index is outside the bounds of massive");
        }
        return (T) array[index];
    }

    public void remove(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("The requested index is outside the bounds of massive");
        }
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
            array[size] = null;
        }
        size--;
        if (size < capacity / 2) {
            array = copyArray(array,capacity / 2);
        }
    }

    public int size() {
        return size;
    }

    private Object[] copyArray(Object[] array, int index) {
        Object[] newArray = new Object[index];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
        newArray = null;
        return array;
    }


}
