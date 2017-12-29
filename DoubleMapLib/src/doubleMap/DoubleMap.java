package doubleMap;

import java.util.Collection;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;

public interface DoubleMap<K extends Comparable<K>, V> {
	public V put(K k1, K k2, V v);
	public V get(K k1, K k2);
	public Set<K> keySet1();
	public Set<K> keySet2();
	public V remove(K k1, K k2);
	public Collection<V> getX(K x);
	public Collection<V> getY(K y);
}
