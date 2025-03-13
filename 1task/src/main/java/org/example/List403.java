package org.example;

public interface List403 {
    /**
     * Метод добавляет элемент в конец списка
     * @param element
     */
    void add(Integer element);

    /**
     * Метод добавляет в указанную позицию
     * @param element
     * @param position
     */
    void add(Integer element, int position) throws IndexOutOfBoundsException;

    /**
     *
     * @param position
     * @return
     */
    Integer remove(int position) throws IndexOutOfBoundsException;

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
    Integer get(int position) throws IndexOutOfBoundsException;

    /**
     * сортировка списка (ask = true - по возрастанию)
     */
    void sort(boolean asc);
}

