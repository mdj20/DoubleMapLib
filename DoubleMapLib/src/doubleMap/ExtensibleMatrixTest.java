package doubleMap;

public class ExtensibleMatrixTest {
	ExtensibleMatrix<Integer> em = new ExtensibleMatrix<Integer>();
	int x = 50;
	int y = 30;
	
	public static void main(String args[]) {
		ExtensibleMatrixTest emt = new ExtensibleMatrixTest();
		emt.smoke();
	}
	
	private void smoke() {
		this.loadInts();
		for(int i= 0; i < x ; i++) {
			for (int j = 0 ; j<y; j++){		
				System.out.println(em.get(i,j));
			}
		}
		
		
	}
	
	
	private void loadInts() {
		int k = 0;
		for(int i= 0; i < x ; i++) {
			for (int j = 0 ; j<y; j++){		
				em.put(i, j,  k++);

				
			}
		}
	}
}
