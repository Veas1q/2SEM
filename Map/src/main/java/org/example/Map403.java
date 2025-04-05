package org.example;

public interface Map403<K, V> {
    void put (K key, V value);

    V get(K key);

    Set403<K> keySet();

    List403U<V> values();

    int size();

    boolean containsKey(K key);

    boolean isEmpty();

    boolean containsValue(V value);

    V remove (K key);

    void clear();

    interface  Entry<K, V>{
        void setKey(K key);
        void setValue(V value);
        K getKey();
        V getValue();
    }
}

