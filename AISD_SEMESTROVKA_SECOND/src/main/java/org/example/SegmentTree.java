package org.example;

/**
 * Класс SegmentTree реализует дерево отрезков для выполнения операций:
 * - сумма на отрезке
 * - минимум на отрезке
 * - максимум на отрезке
 * - обновление элемента
 * - добавление элемента
 * - удаление элемента
 */
public class SegmentTree {
    // Основные массивы данных
    private int[] tree;       // Дерево для хранения сумм на отрезках
    private int[] minTree;    // Дерево для хранения минимумов на отрезках
    private int[] maxTree;    // Дерево для хранения максимумов на отрезках
    private int n;            // Количество элементов в исходном массиве
    private int[] data;       // Исходный массив данных

    /**
     * Конструктор класса SegmentTree
     * @param data исходный массив для построения дерева
     */
    public SegmentTree(int[] data) {
        this.n = data.length;
        this.data = data;

        // Инициализация деревьев (размер 2n для хранения всех узлов)
        this.tree = new int[2 * n];
        this.minTree = new int[2 * n];
        this.maxTree = new int[2 * n];

        // Заполнение листьев деревьев (базовый уровень)
        for (int i = 0; i < n; i++) {
            tree[n + i] = data[i];    // Сумма элемента = сам элемент
            minTree[n + i] = data[i]; // Минимум одного элемента = сам элемент
            maxTree[n + i] = data[i]; // Максимум одного элемента = сам элемент
        }

        // Построение внутренних узлов деревьев (от листьев к корню)
        for (int i = n - 1; i > 0; i--) {
            // Сумма в узле = сумма левого и правого потомков
            tree[i] = tree[2 * i] + tree[2 * i + 1];
            // Минимум в узле = минимум из минимумов потомков
            minTree[i] = Math.min(minTree[2 * i], minTree[2 * i + 1]);
            // Максимум в узле = максимум из максимумов потомков
            maxTree[i] = Math.max(maxTree[2 * i], maxTree[2 * i + 1]);
        }
    }

    /**
     * Добавляет новый элемент в указанную позицию
     * @param value значение нового элемента
     * @param index позиция для вставки
     */
    public void add(int value, int index) {
        // Создаем новый массив с увеличенным размером
        int[] newData = new int[n + 1];

        // Копируем элементы до позиции вставки
        System.arraycopy(data, 0, newData, 0, index);
        // Вставляем новый элемент
        newData[index] = value;
        // Копируем оставшиеся элементы
        System.arraycopy(data, index, newData, index + 1, n - index);

        // Перестраиваем все деревья с новыми данными
        SegmentTree st = new SegmentTree(newData);
        this.tree = st.tree;
        this.minTree = st.minTree;
        this.maxTree = st.maxTree;
        this.data = newData;
        this.n = newData.length;
    }

    /**
     * Удаляет элемент по указанному индексу
     * @param index позиция удаляемого элемента
     */
    public void remove(int index) {
        // Создаем новый массив с уменьшенным размером
        int[] newData = new int[n - 1];

        // Копируем элементы до удаляемого
        System.arraycopy(data, 0, newData, 0, index);
        // Копируем элементы после удаляемого (пропуская его)
        System.arraycopy(data, index + 1, newData, index, n - index - 1);

        // Перестраиваем все деревья с новыми данными
        SegmentTree st = new SegmentTree(newData);
        this.tree = st.tree;
        this.minTree = st.minTree;
        this.maxTree = st.maxTree;
        this.data = newData;
        this.n = newData.length;
    }

    /**
     * Обновляет значение элемента по указанному индексу
     * @param index позиция обновляемого элемента
     * @param value новое значение
     */
    public void update(int index, int value) {
        if (index < 0 || index >= n) {
            throw new IndexOutOfBoundsException();
        }

        // Находим позицию элемента в дереве
        int pos = index + n;

        // Обновляем значение во всех деревьях
        tree[pos] = value;
        minTree[pos] = value;
        maxTree[pos] = value;


        // Обновляем всех родителей (поднимаемся от листа к корню)
        for (int i = pos / 2; i > 0; i /= 2) {
            // Пересчитываем сумму для текущего узла
            tree[i] = tree[2 * i] + tree[2 * i + 1];
            // Пересчитываем минимум для текущего узла
            minTree[i] = Math.min(minTree[2 * i], minTree[2 * i + 1]);
            // Пересчитываем максимум для текущего узла
            maxTree[i] = Math.max(maxTree[2 * i], maxTree[2 * i + 1]);
        }
    }
    /**
     * Вычисляет сумму элементов на отрезке [leftIndex, rightIndex]
     * @param leftIndex левая граница отрезка
     * @param rightIndex правая граница отрезка
     * @return сумма элементов на отрезке
     */
    public int querySum(int leftIndex, int rightIndex) {
        if (leftIndex < 0 || rightIndex >= n || leftIndex > rightIndex) {
            throw new IllegalArgumentException();
        }

        int sum = 0;
        leftIndex += n;  // Переходим к листьям дерева
        rightIndex += n;

        // Поднимаемся по дереву, пока границы не пересекутся
        while (leftIndex <= rightIndex) {
            // Если левая граница - правый потомок, добавляем его значение
            if ((leftIndex % 2) == 1) {
                sum += tree[leftIndex++];
            }
            // Если правая граница - левый потомок, добавляем его значение
            if ((rightIndex % 2) == 0) {
                sum += tree[rightIndex--];
            }
            // Поднимаемся на уровень выше
            leftIndex /= 2;
            rightIndex /= 2;
        }
        return sum;
    }

    /**
     * Находит минимальный элемент на отрезке [leftIndex, rightIndex]
     * @param leftIndex левая граница отрезка
     * @param rightIndex правая граница отрезка
     * @return минимальный элемент на отрезке
     */
    public int queryMin(int leftIndex, int rightIndex) {
        if (leftIndex < 0 || rightIndex >= n || leftIndex > rightIndex) {
            throw new IllegalArgumentException();
        }

        int min = Integer.MAX_VALUE;
        leftIndex += n;
        rightIndex += n;

        while (leftIndex <= rightIndex) {
            if ((leftIndex % 2) == 1) {
                min = Math.min(min, minTree[leftIndex++]);
            }
            if ((rightIndex % 2) == 0) {
                min = Math.min(min, minTree[rightIndex--]);
            }
            leftIndex /= 2;
            rightIndex /= 2;
        }
        return min;
    }

    /**
     * Находит максимальный элемент на отрезке [leftIndex, rightIndex]
     * @param leftIndex левая граница отрезка
     * @param rightIndex правая граница отрезка
     * @return максимальный элемент на отрезке
     */
    public int queryMax(int leftIndex, int rightIndex) {
        if (leftIndex < 0 || rightIndex >= n || leftIndex > rightIndex) {
            throw new IllegalArgumentException();
        }

        int max = Integer.MIN_VALUE;
        leftIndex += n;
        rightIndex += n;

        while (leftIndex <= rightIndex) {
            if ((leftIndex % 2) == 1) {
                max = Math.max(max, maxTree[leftIndex++]);
            }
            if ((rightIndex % 2) == 0) {
                max = Math.max(max, maxTree[rightIndex--]);
            }
            leftIndex /= 2;
            rightIndex /= 2;
        }
        return max;
    }
}
