package org.example;

public class Treygol<T> {
    private T a;
    private T b;
    private T c;

    public Treygol(T a, T b , T c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public T getX(int index){
        if (index > 2 || index < 0 ){
            throw new IndexOutOfBoundsException("Нельзя получить");
        }
        switch (index){
            case 0:
                return a;
            case 1:
                return b;
            case 2:
                return c;
        }
        return null;
    }
    public void add (int index, T elemnet){
        if (index > 2 || index < 0 ){
            throw new IndexOutOfBoundsException("Нельзя получить");
        }
        switch (index){
            case 0:
                a = elemnet;
                break;
            case 1:
                b = elemnet;
                break;
            case 2:
                c = elemnet;
                break;
        }
    }
    @Override
    public String toString(){
        return a + " " + b + " "+  c;
    }
}
