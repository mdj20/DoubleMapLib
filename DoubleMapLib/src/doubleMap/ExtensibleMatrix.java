package doubleMap;

import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedSet;

public class ExtensibleMatrix<V> extends AbstractDoubleMap<Integer, V> implements DoubleMap<Integer, V> {
	
	
	public void putX(int xIndex, Map<Integer,V> entries) {
		if(!xSizes.containsKey(xIndex)) {
			insertAllX(xIndex, entries);
		}
		else {
			NavigableMap<Integer, Integer> tailMap = xSizes.tailMap(xIndex,true);  //Map<xIndex,NUMBER_ENTRIES>
			tailMap = tailMap.descendingMap();
			for(Integer i:tailMap.keySet()){
				//super.
			}
			
		}
	}
	
	
	
	public void putY(int yIndex, Map<Integer,V> entries) {
		if(!xSizes.containsKey(yIndex)) {
			insertAllY(yIndex, entries);
		}
		else {
		
			
		}
	}
	
	
	private void insertAllX(int x, Map<Integer,V> entries) {
		for(Integer i: entries.keySet()) {
			super.put(x, i, entries.get(i));
		}
	}
	
	private void insertAllY(int y, Map<Integer,V> entries) {
		for(Integer i: entries.keySet()) {
			super.put(i, y, entries.get(i));
		}
	}
	
	
}
