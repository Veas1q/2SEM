package org.example;

import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;

public interface Map403<K, V> extends Iterable<Map403.Entry<K, V>> {
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
    <R> List403U<R> map(Function<V, R> function);
    interface  Entry<K, V>{
        void setKey(K key);
        void setValue(V value);
        K getKey();
        V getValue();
    }



}

