package doubleMap;

import static org.junit.Assert.*;

import java.util.Collection;
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
				removed.add(testMatrix.remove(i%x, i/y));
			}
			i++;
		}
		i=0;
		while (i<(x*y)) {
			if(i%2==0) {
				//Integer attempt = testMatrix.get(i%x,i/y);
				//System.out.println(attempt);
				assertTrue(testMatrix.get(i%x,i/y)==null);
			}
			else{
				assertTrue(!removed.contains(testMatrix.get(i%x,i/y)));
			}
			i++;
		}
		
		
		//System.out.println(removed.size());
		
	}

	@Test
	public void testGetX() {
		System.out.println("TEST GETX:");
		int x=10,y=10;
		ExtensibleMatrix<Integer> testMatrix = createTestEM(x,y);
		for(int i = 0 ; i < x ; i++){
			Collection<Integer> line = testMatrix.getX(i);
			int j = 0;
			for(Integer k:line){
				System.out.println(k+" "+(j*x+i));
				assertTrue(k==(j*x+i));
				j++;
			}
		}
		//fail();
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
				//System.out.println((i*x)+j);
			}
		}
		return ret;
	}
	
}
