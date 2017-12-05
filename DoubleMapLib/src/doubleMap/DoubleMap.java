package doubleMap;

import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;

public interface DoubleMap<K extends Comparable<K>, V> {
	public V put(K k1, K k2, V v);
	public V get(K k1, K k2);
	public Set<K> keySet1();
	public Set<K> keySet2();
	public V remove(K k1, K k2);
	public NavigableMap<DoubleIndex<K>,V> getXValues(K x);
	public NavigableMap<DoubleIndex<K>,V> getYValues(K y);
}