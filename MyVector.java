import java.util.Arrays;

public class MyVector<E> extends MyAbstractList<E> {

    private E[] myList;
    private int capacityIncrement;

    @SuppressWarnings("unchecked")
    public MyVector() {
        myList = (E[]) new Object[10];
        size = 0;
        capacityIncrement = 5;
    }

    @SuppressWarnings("unchecked")
    public MyVector(int initialCapacity){
        myList = (E[]) new Object[initialCapacity];
        size = 0;
        capacityIncrement = 5;
    }

    @SuppressWarnings("unchecked")
    public MyVector(int initialCapacity, int capacityIncrement){
        myList = (E[]) new Object[initialCapacity];
        size = 0;
        this.capacityIncrement = capacityIncrement;
    }

    public int getCapacity(){
        return myList.length;
    }

    public int getIncrement(){
        return capacityIncrement;
    }

    /**
     * Appends the specified element to the end of this list,
     * The list capacity should be resized based on a capacity
     * increment variable once the current capacity is filled (capacity == size).
     * @param data - parameter
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean add(E data) {

        if(size == myList.length){
            E[] newList = (E[]) new Object[myList.length + capacityIncrement];
            for(int i = 0; i < myList.length; i++){
                newList[i] = myList[i];
            }
            myList = newList;
        }

        myList[size] = data;
        size++;


        return false;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements by adding one to their indices.
     * The list capacity should be resized based on a capacity
     * increment variable once the current capacity is filled (capacity == size).
     * @param index - index at which the specified element is to be inserted
     * @param data - element to be inserted
     * @return boolean
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean add(int index, E data) throws IndexOutOfBoundsException {


            if(size == myList.length){


                E[] newList = (E[]) new Object[myList.length + capacityIncrement];
                for(int i = 0; i < myList.length; i++){
                    newList[i] = myList[i];
                }
                myList = newList;
            }else{


                E[] newList = (E[]) new Object[myList.length + 1];
                int tempSize = 0;
                for(int i = 0; i < newList.length; i++){
                    if(i != index) {
                        newList[i] = myList[tempSize];
                        tempSize++;
                    }else{
                        newList[i] = data;
                    }
                }
                myList = newList;
            }

            size++;

        return false;
    }

    /**
     * Removes all of the elements from this list
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list
     * @param index
     * @return E
     */
    @Override
    public E get(int index) {
        return myList[index];
    }

    /**
     * Removes the  element at the specified position in this list.
     * Shifts any subsequent elements by subtracting one from their indices.
     * @param index - index of the element to be removed
     * @return E - the element that was removed from the list
     * IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("d");
        }

        E removedData = myList[index];
        E[] newList = (E[]) new Object[myList.length - 1];

        int temp = 0;
        for(int i = 0; i < myList.length; i++){

            if(i != index){
                newList[temp] = myList[i];
                temp++;
            }

        }
        myList = newList;
        size--;

        return removedData;
    }

    /**
     * Trims the capacity of this MyVector instance to be the list's current size. An application
     * can use this operation to minimize the storage of a MyVector instance.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void trimToSize() {
        E[] newList = (E[]) new Object[size];
        for(int i = 0; i < newList.length; i++){
            newList[i] = myList[i];
        }
        myList = newList;
    }

    @Override
    public String toString(){
        trimToSize();
        return Arrays.toString(myList);
    }

}
