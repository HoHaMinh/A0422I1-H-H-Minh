package ss9_arraylist_exercise.ss9_arraylist_exercise_my_list;

import java.util.Arrays;
import java.util.Objects;

public class MyList<E> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    public Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    private void ensureCapacity(int minCapacity) {
        elements = Arrays.copyOf(elements, elements.length + minCapacity);
    }

    public void add(int index, E element) {
        if (index > elements.length) {
            ensureCapacity(index - elements.length);
            size = index + 1;
        } else if (index > size) {
            size = index + 1;
        } else {
            size++;
        }
        elements[index] = (E) element;
    }

    public int getSize() {
        return size;
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");
    }

    public E remove(int index) {
        checkIndex(index);
        E e = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], e)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], e)) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapacity(1);
        }
        elements[size] = e;
        size++;
        return true;
    }

    public void clear() {
        elements = new MyList[elements.length];
        size = 0;
    }

    public MyList clone() {
        MyList newList = new MyList();
        newList.elements = this.elements;
        newList.size = this.size;
        for (int i = 0; i < elements.length; i++) {
            newList.elements[i] = elements[i];
        }
        return newList;
    }
}
