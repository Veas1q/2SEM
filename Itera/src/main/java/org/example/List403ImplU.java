package org.example;
import java.util.Iterator;
import java.util.ListIterator;

public class List403ImplU<T> implements List403U<T>, Iterable<T>{
    private  Object arr[];
    private int size;

    public List403ImplU(){
        this.arr = new Object[10];
        this.size = 0;
    }


    @Override
    public T get(int position) throws IndexOutOfBoundsException{
        if (position > size || position < 0 ){
            throw new IndexOutOfBoundsException("выход за пределы массива");
        }
        return (T)arr[position];
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void remove(int position) throws IndexOutOfBoundsException{
        if (position > size - 1 || position < 0){
            throw new IndexOutOfBoundsException();
        }
        T temp = (T) arr[position];
        for (int i = position; i < size - 1 ; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }
    @Override
    public void add(T element, int position) throws IndexOutOfBoundsException {
        if (size >= arr.length) {
            grow();
        }
        for (int i = size; i != position; i--) {
            arr[i] = arr[i - 1];
        }
        arr[position] = element;
        size++;
    }
    @Override
    public void add(T element){
        if (size >= arr.length) {
            grow();
        }
        arr[size++] = element;
    }
    private void grow() {
        Object[] temp = new Object[(int) (size * 1.5)];
        for (int i = 0; i < size ; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }
    public void print(){
        int i = 0;
        while (arr[i] != null){
            System.out.print(arr[i] + " ");
            i++;
        }
        System.out.println();

    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < size ; i++) {
            stringBuilder.append(arr[i]).append(" ");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext(){
            return index < size;
        }

        @Override
        public T next(){
            return (T)arr[index++];
        }


    }
}
