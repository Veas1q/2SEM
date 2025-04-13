package org.example;

public class MapImpl<K,V> implements  Map403<K,V> {

    private Node<K,V>[] array;

    private int size;

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Entry<K, V> next() {
        return null;
    }

    private class Node<K,V> {
        Entry<K,V> value;
        Node<K,V> next;

        public Node(K key, V value) {
            this.value = new EntryImpl<>(key, value);
        }
    }

    class EntryImpl<K,V> implements Entry<K,V> {
        private K key;
        private V value;

        public EntryImpl(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }
    }

    public MapImpl(){
        array = new Node[16];
    }

    @Override
    public void put(K key, V value) {
        int index = Math.abs(key.hashCode() % 16);
        Node<K,V> temp = new Node<>(key, value);

        if (array[index] == null) {
            array[index] = temp;
        } else {
            Node<K,V> current = array[index];
            Node<K,V> prev = null;

            while (current != null) {
                if (current.value.getKey().equals(key)) {
                    current.value.setValue(value);
                    return;
                }
                prev = current;
                current = current.next;
            }

            prev.next = temp; // Добавляем в конец цепочки
        }

        size++;
    }


    @Override
    public V get(K key) {
        int index = Math.abs(key.hashCode() % 16);
        if (array[index] == null) {
            return null;
        }
        Node<K,V> current = array[index];
        while(current != null) {
            if(current.value.getKey().equals(key)) {
                return current.value.getValue();
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public Set403<K> keySet() {
        Set403<K> keySet = new Mnojestvo<>();
        for(Node<K, V> node: array){
            Node<K, V> current = node;
            while (current != null){
                keySet.add(current.value.getKey());
                current = current.next;
            }
        }
        return keySet;
    }

    @Override
    public List403U<V> values() {
        List403U<V> values = new List403ImplU<>();
        for(Node<K,V> node : array){
            Node current = node;
            while (current != null){
                values.add((V)current.value.getValue());
                current = current.next;
            }
        }
        return values;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(K key) {
        for(Node<K, V> node : array){
            Node<K, V> current = node;
            while (current != null){
                if (current.value.getKey().equals(key)){
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }


    @Override
    public boolean containsValue(V value) {
        for(Node<K, V> node : array){
            Node<K, V> current = node;
            while (current != null){
                if(current.value.getValue().equals(value)){
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public V remove(K key) {
        int index = Math.abs(key.hashCode() % 16);
        if (array[index] == null){
            return null;
        }
        Node<K, V> current = array[index];
        Node<K, V> prev = null;
        while (current != null){
            if(current.value.getKey().equals(key)){
                if(prev == null) {
                    array[index] = current.next;
                }else {
                    prev.next = current;
                }
                size--;
                return current.value.getValue();
            }
            prev = current;
            current = current.next;

        }
        return null;
    }


    @Override
    public void clear() {
        array = new Node[16];
        size = 0;
    }
}
