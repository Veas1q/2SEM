package Homework;

public class Mnojestvo<T> implements Set403<T>{
    private Object[] mnojestvo;
    private int size;

    public Mnojestvo(){
        this.mnojestvo = new Object[1];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size ; i++) {
            if (mnojestvo[i] == element){
                 return true;
            }
        }
        return false;
    }

    @Override
    public void add(T element) {
        for (int i = 0; i < size; i++) {
            if (mnojestvo[i].equals(element)) {
                return;
            }
        }
        if (size == mnojestvo.length) {
            T[] newArray = (T[]) new Object[mnojestvo.length * 2];
            System.arraycopy(mnojestvo, 0, newArray, 0, mnojestvo.length);
            mnojestvo = newArray;
        }
        mnojestvo[size] = element;
        size++;
    }

    @Override
    public T[] getAll() {
        return (T[]) mnojestvo;
    }
    public T get(int index){
        return (T)(mnojestvo[index]);
    }
    @Override
    public T remove(T element) {
        for (int i = 0; i < size ; i++) {
            if (mnojestvo[i].equals(element)){
                mnojestvo[i] = null;
                size--;
                return element;
            }
        }
        return null;
    }

}
