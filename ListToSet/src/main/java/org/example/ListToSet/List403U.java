package org.example.ListToSet;

import java.util.Set;
import java.util.function.Function;

public interface List403U<T>{
    /**
     * Метод добавляет элемент в конец списка
     * @param element
     */
    void add(T element);

    /**
     * Метод добавляет в указанную позицию
     * @param element
     * @param position
     */
    void add(T element, int position) throws IndexOutOfBoundsException;

    /**
     *
     * @param position
     * @return
     */
    void remove(int position) throws IndexOutOfBoundsException;

    /**
     * Возвращает размер списка
     * @return
     */
    int size();

    /**
     * Возвращает элемент по индексу
     * @param position
     * @return
     */
    T get(int position) throws IndexOutOfBoundsException;

    /**
     * сортировка списка (ask = true - по возрастанию)
     */
    <R> Set<R> map(Function<T, R> function);
}


