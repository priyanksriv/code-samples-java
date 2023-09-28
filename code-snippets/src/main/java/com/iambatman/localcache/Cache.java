package com.iambatman.localcache;


public interface Cache<K, V> {

    void set(K key, V val);

    V get(K key);

    V remove(K key);
}
