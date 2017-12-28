package doubleMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class AbstractDoubleMap<K extends Comparable<K>, V> implements DoubleMap<K, V> {
	
	private TreeMap<DoubleIndex<K>,V> xMap;
	private TreeMap<DoubleIndex<K>,V> yMap;
	private TreeMap<K,Integer> xSizes;
	private TreeMap<K,Integer> ySizes;
	private DoubleIndex<K> tempKey = null;
	
	public AbstractDoubleMap(){
		xMap = new TreeMap<DoubleIndex<K>,V>();
		yMap = new TreeMap<DoubleIndex<K>,V>(new DoubleIndex.InverseDoubleIndexComparator<K>());
		xSizes = new TreeMap<K,Integer>();
		ySizes = new TreeMap<K,Integer>();
	}
	
	@Override
	public V put(K k1, K k2, V v) {
		V ret;
		DoubleIndex<K> key = new DoubleIndex<K>(k1,k2);
		xMap.put(key,v);
		ret = yMap.put(key, v);
		if (ret == null) {
			xSizeIncrement(k1);
			ySizeIncrement(k2);
		}
		return ret;
	}
	
	@Override
	public V get(K k1, K k2) {
		DoubleIndex<K> searchKey = setTempIndex(k1,k2);
		return xMap.get(searchKey);
	}
	@Override
	public Set<K> keySet1() {
		return xSizes.keySet();
	}
	@Override
	public Set<K> keySet2() {
		return ySizes.keySet();
	}

	@Override
	public V remove(K k1, K k2) {
		DoubleIndex<K> searchKey = setTempIndex(k1,k2);
		V ret = xMap.remove(searchKey);
		ret = yMap.remove(searchKey);
		if(ret != null) {
			xSizeDecrement(k1);
			ySizeDecrement(k2);
		}
		return ret;
	}

	private DoubleIndex<K> setTempIndex(K k1, K k2){
		if(tempKey == null) {
			tempKey = new DoubleIndex<K>(k1,k2);
		}
		else {
			tempKey.t1 = k1;
			tempKey.t2 =  k2;
		}
		return tempKey;
	}
	
	private Integer xSizeIncrement(K key) {
		Integer ret = xSizes.get(key);
		if(ret!=null) {
			ret+=1;
			xSizes.put(key, ret);
		}
		else {
			xSizes.put(key, 1);
			ret = 1;
		}
		return ret;
	}
	
	private Integer xSizeDecrement(K key) {
		Integer ret = xSizes.get(key);
		if(ret == null) {
			throw new IllegalArgumentException("Key Doesn't exist");
		}
		if(ret>1) {
			ret-=1;
			xSizes.put(key, ret);
		}
		else {
			xSizes.remove(key);
			ret = null;
		}
		return ret;
	}
	
	private Integer ySizeIncrement(K key) {
		Integer ret = ySizes.get(key);
		if(ret!=null) {
			ret+=1;
			ySizes.put(key, ret);
		}
		else {
			ySizes.put(key, 1);
			ret = 1;
		}
		return ret;
	}
	
	private Integer ySizeDecrement(K key) {
		Integer ret = ySizes.get(key);
		if(ret == null) {
			throw new IllegalArgumentException("Key Doesn't exist");
		}
		if(ret>1) {
			ret-=1;
			ySizes.put(key, ret);
		}
		else {
			ySizes.remove(key);
			ret = null;
		}
		return ret;
	}


	@Override
	public Collection<V> getX(K x) {
		if(xSizes.get(x)==null) {
			throw new IllegalArgumentException("No Objects at X( "+x+" )");
		}
		Collection<V> ret = null;
		K yCeil, yFloor;
		yCeil= ySizes.lastKey();
		yFloor = ySizes.firstKey();
		if (yCeil!=null && yFloor != null) {
			DoubleIndex<K> floor = setTempIndex(x,yFloor);
			DoubleIndex<K> ceil = new DoubleIndex<K>(x,yCeil);
			SortedMap<DoubleIndex<K>, V> subMap = yMap.subMap(floor, ceil);
			ret = subMap.values();
		}
		return ret;
	}

	@Override
	public Collection<V> getY(K y) {
		if(ySizes.get(y)==null) {
			throw new IllegalArgumentException("No Objects at Y( "+y+" )");
		}
		Collection<V> ret = null;
		K xCeil, xFloor;
		xCeil= xSizes.lastKey();
		xFloor = xSizes.firstKey();
		if (xCeil!=null && xFloor != null) {
			DoubleIndex<K> floor = setTempIndex(xFloor,y);
			DoubleIndex<K> ceil = new DoubleIndex<K>(xCeil,y);
			SortedMap<DoubleIndex<K>, V> subMap = yMap.subMap(floor, ceil);
			ret = subMap.values();
		}
		return ret;
	}
}
