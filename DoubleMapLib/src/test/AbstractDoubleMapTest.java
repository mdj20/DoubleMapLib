package test;

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
		
	}
}
