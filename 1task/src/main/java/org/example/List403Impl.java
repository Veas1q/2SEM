package org.example;

import java.sql.SQLOutput;
import java.util.Arrays;

public class List403Impl implements List403{
    private Integer arr[];
    private int size;

    public List403Impl(){
        this.arr = new Integer[10];
        this.size = 0;
    }

    @Override
    public void sort(boolean asc){
        if (asc){
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size ; j++) {
                    if (arr[i] > arr[j]){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        else{
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size ; j++) {
                    if (arr[i] < arr[j]){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }

    }
    @Override
    public Integer get(int position) throws IndexOutOfBoundsException{
        if (position > size || position < 0 ){
            throw new IndexOutOfBoundsException("выход за пределы массива");
        }
        return arr[position];
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public Integer remove(int position) throws IndexOutOfBoundsException{
        if (position > size - 1 || position < 0){
            throw new IndexOutOfBoundsException();
        }
        Integer temp = arr[position];
        for (int i = position; i < size - 1 ; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return temp;
    }
    @Override
    public void add(Integer element, int position) throws IndexOutOfBoundsException {
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
    public void add(Integer element){
        if (size >= arr.length) {
            grow();
        }
        arr[size++] = element;
    }
    private void grow() {
        Integer[] temp = new Integer[(int) (size * 1.5)];
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
}
