package codility.lessons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PermMissingElem {

	public int solution(int[] A) {
		long expectedSum = ((A.length+1)*(A.length+2))/2;
		long realSum = 0;
		
		for (int i : A) {
			realSum = realSum + new Long(i);
		}
		return new Long(expectedSum-realSum).intValue();
	}
	
	@Test
	public void test() {
		assertEquals(4, solution(new int[] {2, 3, 1, 5}));
		assertEquals(5, solution(new int[] {2, 3, 4, 1}));
		assertEquals(1, solution(new int[] {2}));
		assertEquals(2, solution(new int[] {1}));
		int test[] = new int[99999];
		for(int i=0; i<test.length; i++) {
			test[i] = i+1;
		}
		assertEquals(100000, solution(test));
	}
}
