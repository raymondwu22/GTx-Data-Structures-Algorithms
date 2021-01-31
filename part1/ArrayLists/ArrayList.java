/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {

    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayList.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) throw new IllegalArgumentException();
        if (size + 1 > backingArray.length) {
            resize();
        }
        if (size > 0) {
            shiftToRight(0);
        }
        backingArray[0] = data;
        size++;
    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) throw new IllegalArgumentException();
        if (size + 1 > backingArray.length) {
            resize();
        }
        if (size == 0) addToFront(data);
        else backingArray[size++] = data;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) throw new java.util.NoSuchElementException();
        T item = backingArray[0];
        backingArray[0] = null;
        shiftToLeft(1);
        backingArray[--size] = null;
        return item;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) throw new java.util.NoSuchElementException();
        T removedELement = backingArray[size-1];
        backingArray[--size] = null;
        return removedELement;
    }

    /**
     *
     * Resizes our backing array by doubling the current capacity
     * and copying over previous elements.
     *
     */
    private void resize() {
        T[] newArray = (T[]) new Object[backingArray.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = backingArray[i];
        }
        backingArray = newArray;
    }

    /**
     *
     * Shift items to the left in Array starting at index.
     *
     */
    private void shiftToLeft(int index) {
        for (int i = index; i < size; i++) {
            backingArray[i-1] = backingArray[i];
        }
    }

    /**
     *
     * Shift items to the right in Array ending at index.
     *
     */
    private void shiftToRight(int index) {
        for (int i = size; i > index; i--) {
            backingArray[i] = backingArray[i-1];
        }
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    public int length() {
        return backingArray.length;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < backingArray.length; i++) {
            if (i == backingArray.length-1) {
                sb.append(backingArray[i]);
            } else {
                sb.append(backingArray[i] + " > ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("length: " + list.length());
        list.addToFront(1);
        System.out.println(list.toString());
        list.addToBack(2);
        System.out.println(list.toString());
        list.addToFront(3);
        System.out.println("size: " + list.size());
        System.out.println(list.toString());
        list.removeFromBack();
        System.out.println("removed from back: " + list.toString());
        list.removeFromFront();
        System.out.println("removed from front " + list.toString());
        System.out.println("size: " + list.size());
        list.addToFront(1);
        list.addToBack(33);
        list.addToFront(11);
        list.addToBack(22);
        System.out.println("size: " + list.size());
        System.out.println("length: " + list.length());
        list.addToFront(12);
        list.addToBack(23);
        list.addToFront(14);
        list.addToBack(26);
        System.out.println("size: " + list.size());
        System.out.println("length: " + list.length());
        list.addToFront(71);
        System.out.println("size: " + list.size());
        System.out.println("length: " + list.length());
        list.addToBack(28);
        System.out.println(list.toString());
        System.out.println(list.size());
    }
}