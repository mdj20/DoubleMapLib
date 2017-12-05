package doubleMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class TreeMapTest {
	
	static int x = 10;
	static int y = 10;
	
	public static void main(String args[]) {
		TreeMap<DoubleIndex<Integer>,Integer> norm = new TreeMap<DoubleIndex<Integer>,Integer>();
		TreeMap<DoubleIndex<Integer>,Integer> inv = new TreeMap<DoubleIndex<Integer>,Integer>();
		ArrayList<DoubleIndex<Integer>> dv = new ArrayList<DoubleIndex<Integer>>();
		for(int i = 0 ; i <x ; i++ ) {
			for(int j = 0 ; j < y ; j++) {
				dv.add(new DoubleIndex<Integer>(i,j));
			}
		}
		//System.out.println(dv.size());
		
		inv = new TreeMap<DoubleIndex<Integer>,Integer>(dv.get(0).getInverseComparator());
		int i=0;
		for(DoubleIndex<Integer> di: dv) {
			System.out.println(di.t1+" "+di.t2+" "+i);
			norm.put(di, i);
			inv.put(di, i++);
		}
	/*	Collections.sort(dv,dv.get(0).getInverseComparator());
		for(DoubleIndex<Integer> di: dv) {
			System.out.println(di.t1+" "+di.t2);
		}
		
		*/
		//System.out.println(norm.size());
		
		
		for(DoubleIndex<Integer> di:norm.keySet()) {
			System.out.println(di.t1+" "+di.t2+" "+norm.get(di));
		}
	
		for(DoubleIndex<Integer> di:inv.keySet()) {
			System.out.println(di.t1+" "+di.t2+" "+inv.get(di));
		}
		
		
		
		for(Integer in:norm.values()) {
			System.out.println(in);
		}
	
		
		for(Integer in:inv.values()) {
			System.out.println(in);
		}
		
		
	}

}
