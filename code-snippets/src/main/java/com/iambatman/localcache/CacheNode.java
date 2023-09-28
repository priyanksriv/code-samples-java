package com.iambatman.localcache;

public interface CacheNode<K, V> {

    K key();

    V val();

    V setVal(V val);
}
