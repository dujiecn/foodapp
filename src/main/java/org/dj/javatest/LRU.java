package org.dj.javatest;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class LRU<K, V> extends LinkedHashMap<K, V> {

	/** 最大数据存储容量 */
	private static final int LRU_MAX_CAPACITY = 1024;
	private static final float DEFAULT_LOADFATOR = 0.75f;
	/** 存储数据容量 */
	private int capacity;

	public LRU() {
		super(LRU_MAX_CAPACITY, DEFAULT_LOADFATOR, true);
		capacity = LRU_MAX_CAPACITY;
	}

	public LRU(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor, true);
		capacity = initialCapacity;
	}

	@Override
	public synchronized V put(K key, V value) {
		return super.put(key, value);
	}

	@Override
	public synchronized V get(Object key) {
		return super.get(key);
	}

	@Override
	protected synchronized boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size() > capacity;
	}

	public static void main(String[] args) {
		Map<Integer, Integer> map = new LRU<>(3, 0.75f);
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(2, 4);
		map.put(5, 3);
		map.put(2, 3);
		System.out.println(map);
	}
}
