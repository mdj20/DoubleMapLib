package doubleMap;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NavigableMap;
import java.util.Set;

import org.junit.Test;

public class ExtensibleMatrixTest {

	@Test
	public void testPut() {
		int x = 10, y =10;
		ExtensibleMatrix<Integer> ret = createTestEM(x,y);
		for (int i = 0 ; i<y ; i++) {
			for (int j = 0 ; j<x ; j++) {
				assertTrue(ret.get(j, i)==mapValue(j,i,x,y));
			}
		}	
	}

	@Test
	public void testGet() {
		int x = 10, y =10;
		ExtensibleMatrix<Integer> ret = createTestEM(x,y);
		for (int i = 0 ; i<y ; i++) {
			for (int j = 0 ; j<x ; j++) {
				assertTrue(ret.get(j, i)==mapValue(j,i,x,y));
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
				assertTrue(testMatrix.get(i%x,i/y)==null);
			}
			else{
				assertTrue(!removed.contains(testMatrix.get(i%x,i/y)));
			}
			i++;
		}
	}

	@Test
	public void testGetX() {
		int x=10,y=10;
		ExtensibleMatrix<Integer> testMatrix = createTestEM(x,y);
		for(int i = 0 ; i < x; i++){
			Collection<Integer> line = testMatrix.getX(i);
			int j = 0;
			for(Integer k:line){
				assertTrue(k==mapValue(i,j,x,y));
				j++;
			}
		}
	}

	@Test
	public void testGetY() {
		int x=10,y=10;
		ExtensibleMatrix<Integer> testMatrix = createTestEM(x,y);
		for(int i = 0 ; i < y; i++){
			Collection<Integer> line = testMatrix.getY(i);
			int j = 0;
			for(Integer k:line){
				assertTrue(k==mapValue(j,i,x,y));
				j++;
			}
		}
		
		HashSet<Integer> removed = new HashSet<Integer>(); 
		//remove some values
		for(int i = 0; i < x ; i++) {
			if(i%2==0) {
				removed.add(testMatrix.remove(i, 3));
			}
		}
		Collection<Integer> line = testMatrix.getY(3);
		for(Integer i: line) {
			assertTrue(!removed.contains(i));
		}
		
	}
	
	
	@Test
	public void testGetXMappedValues() {
		int x=10,y=10;
		ExtensibleMatrix<Integer> testMatrix = createTestEM(x,y);
		for(int i = 0 ; i < x; i++){
			NavigableMap<Integer,Integer> line = testMatrix.getXMappedValues(i);
			for(Integer j:line.keySet()){
				assertTrue(line.get(j)==mapValue(i,j,x,y));		
			}
		}
	}
	
	@Test
	public void testGetYMappedValues() {
		int x=10,y=10;
		ExtensibleMatrix<Integer> testMatrix = createTestEM(x,y);
		for(int i = 0 ; i < y; i++){
			NavigableMap<Integer,Integer> line = testMatrix.getYMappedValues(i);
			for(Integer j:line.keySet()){
				assertTrue(line.get(j)==mapValue(j,i,x,y));		
			}
		}
	}
	
	@Test
	public void testPutX(){
		int x=10,y=10, xIndex = 3;
		ExtensibleMatrix<Integer> testMatrix = createTestEM(x,y);
		HashMap<Integer,Integer> values = new HashMap<Integer,Integer>();
		for(int i = 0 ; i < y ; i++ ){ // set up the values
			values.put(i, mapValue(xIndex,i,x,y));
		}
		// insert values
		testMatrix.putX(xIndex, values);
		//check values
		for(int i = 0 ; i < x+1 ; i++){
			for( int j = 0 ; j < y ; j++){
				int expectedXValue = (i<=xIndex)?i:i-1;
				assertTrue(testMatrix.get(i, j) == mapValue(expectedXValue,j,x,y));
			}
		}
		
	}

	@Test
	public void testPutY(){
		int x=10,y=10, yIndex = 3;
		ExtensibleMatrix<Integer> testMatrix = createTestEM(x,y);
		HashMap<Integer,Integer> values = new HashMap<Integer,Integer>();
		for(int i = 0 ; i < x ; i++ ){ // set up the values
			values.put(i, mapValue(i,yIndex,x,y));
		}
		// insert values
		testMatrix.putY(yIndex, values);
		//check values
		for(int i = 0 ; i < x ; i++){
			for( int j = 0 ; j < y+1 ; j++){
				int expectedYValue = (j<=yIndex)?j:j-1;
				//System.out.println(i+" "+j+" "+expectedYValue+" "+mapValue(i,expectedYValue,x,y)+" "+testMatrix.get(i, j));
				assertTrue(testMatrix.get(i, j) == mapValue(i,expectedYValue,x,y));
			}
		}
		
	}


	protected ExtensibleMatrix<Integer> createTestEM(int x, int y){
		ExtensibleMatrix<Integer> ret = new ExtensibleMatrix<Integer>();
		for(int i = 0 ; i < y ; i++) {
			for(int j = 0 ; j < x ; j++) {
				ret.put(j,i,mapValue(j,i,x,y));
			}
		}
		return ret;
	}
	
	
	// this method produces consistent and unique testing values 
	protected Integer mapValue(int x, int y, int xDim, int yDim){
		return (y*xDim)+x;
	}
	
}
