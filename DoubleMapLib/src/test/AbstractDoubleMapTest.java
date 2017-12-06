package test;

import java.util.HashSet;
import java.util.Random;

import doubleMap.AbstractDoubleMap;

public class AbstractDoubleMapTest {
	public static void main(String args[]) {
		AbstractDoubleMap<Integer,Integer> map = new AbstractDoubleMap<Integer,Integer>();
		int xlimit = 100;
		int ylimit = 100;
		
		int k = 0;
		for (int i = 0 ; i< ylimit ; i++) {
			for(int j = 0 ; j < xlimit ; j++) {
				map.put(i, j, k++);	
			}		
		}
		for (int i = 0 ; i< ylimit ; i++) {
			for (int j = 0 ; j < xlimit ; j++) {
				System.out.println(map.get(i, j));	
			}		
		}
		for (int i = 0 ; i<100 ; i++ ) {
			for(Integer ci : map.getX(i)) {
				System.out.print(ci+" ");
			}
			System.out.println();
		}
		
		for (int i = 0 ; i<100 ; i++ ) {
			for(Integer ci : map.getY(i)) {
				System.out.print(ci+" ");
			}
			System.out.println();
		}
		
		HashSet<Integer> removed = new HashSet<Integer>();
		Random rando = new Random(System.nanoTime());
		int count=0,limit=100;
		while(count < limit) {
			int index = rando.nextInt(xlimit*ylimit);
			Integer value = map.remove(index/xlimit,index%ylimit);
			if(value!=null) {
				removed.add(value);
				count++;
			}
		}
		
		for(Integer r : removed) {
			System.out.println("TEST");
			if(null!=map.get(r/xlimit, r%ylimit+1)) {
				System.out.println("MISS");
			}
		}
		
		
		
	}
}
