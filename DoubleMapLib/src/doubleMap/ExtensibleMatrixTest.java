package doubleMap;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ExtensibleMatrixTest {

	@Test
	public void testPut() {
		int x = 10, y =10;
		ExtensibleMatrix<Integer> ret = createTestEM(x,y);
		for (int i = 0 ; i<y ; i++) {
			for (int j = 0 ; j<x ; j++) {
				assertTrue(ret.get(i, j)==i*x+j);
			}
		}
		
	}

	@Test
	public void testGet() {
		int x = 10, y =10;
		ExtensibleMatrix<Integer> ret = createTestEM(x,y);
		for (int i = 0 ; i<y ; i++) {
			for (int j = 0 ; j<x ; j++) {
				assertTrue(ret.get(i, j)==i*x+j);
			}
		}
	}

	@Test
	public void testKeySet1() {
		int x = 10, y =10;
		ExtensibleMatrix<Integer> testMatrix = createTestEM(x,y);
		Set<Integer> expected = new HashSet<Integer>();
 		int i = 0;
		while(i<x) {
			expected.add(i++);
		}
		for(Integer key:testMatrix.keySet1()) {
			if(expected.contains(key)) {
				assertTrue(expected.contains(key));
				expected.remove(key);
			}
			
		}
	}

	@Test
	public void testKeySet2() {
		int x = 10, y =10;
		ExtensibleMatrix<Integer> testMatrix = createTestEM(x,y);
		Set<Integer> expected = new HashSet<Integer>();
 		int i = 0;
		while(i<x) {
			expected.add(i++);
		}
		for(Integer key:testMatrix.keySet1()) {
			if(expected.contains(key)) {
				assertTrue(expected.contains(key));
				expected.remove(key);
			}
		}
	}

	@Test
	public void testRemove() {
		int x = 10, y =10;
		ExtensibleMatrix<Integer> testMatrix = createTestEM(x,y);
		int i = 0;
		Set<Integer> removed = new HashSet<Integer>();
		while (i<(x*y)) {
			if(i%2==0) {
				removed.add(testMatrix.get(i%x, i/y));
			}
		}
		System.out.println(removed.size());
		
	}

	@Test
	public void testGetX() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetY() {
		fail("Not yet implemented");
	}

	protected ExtensibleMatrix<Integer> createTestEM(int x, int y){
		ExtensibleMatrix<Integer> ret = new ExtensibleMatrix<Integer>();
		for(int i = 0 ; i < y ; i++) {
			for(int j = 0 ; j < x ; j++) {
				ret.put(i,j,(i*x)+j);
			}
		}
		return ret;
	}
	
}
