package doubleMap;

import java.util.Comparator;

public class DoubleIndex<T extends Comparable<T>> implements Comparable<DoubleIndex<T>>{
	T t1;
	T t2;
	
	public DoubleIndex(T t1, T t2) {
		this.t1=t1;
		this.t2=t2;
	}

	public int compareTo(DoubleIndex<T> o) {
		int ret;
		if(t1.compareTo(o.t1)==0) {
			ret = t2.compareTo(o.t2);
		}
		else {
			ret = t1.compareTo(o.t1);
		}
		return ret;
	}
	
	public  Comparator<DoubleIndex<T>> getInverseComparator(){
		return new InverseDoubleIndexComparator<T>();
	}
	
	public  Comparator<DoubleIndex<T>> getXComparator(){
		return new XComparator<T>();
	}
	
	public  Comparator<DoubleIndex<T>> getYComparator(){
		return new YComparator<T>();
	}
	
	public static class InverseDoubleIndexComparator<T extends Comparable<T>> implements Comparator<DoubleIndex<T>>{

		@Override
		public int compare(DoubleIndex<T> o1, DoubleIndex<T> o2) {
			int ret;
			if(o1.t2.compareTo(o2.t2)==0) {
				ret = o1.t1.compareTo(o2.t1);
			}
			else {
				ret = o1.t2.compareTo(o2.t2);
			}
			return ret;
		}	
	}
	public static class XComparator<T extends Comparable<T>> implements Comparator<DoubleIndex<T>>{

		@Override
		public int compare(DoubleIndex<T> o1, DoubleIndex<T> o2) {
			return o1.t1.compareTo(o2.t1);
		}
	}
	public static class YComparator<T extends Comparable<T>> implements Comparator<DoubleIndex<T>>{

		@Override
		public int compare(DoubleIndex<T> o1, DoubleIndex<T> o2) {
			return o1.t2.compareTo(o2.t2);
		}
		
	}
}
