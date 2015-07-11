package codility.lessons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PermMissingElem {

	public int solution(int[] A) {
		int expectedSum = ((A.length+1)*(A.length+2))/2;
		int realSum = 0;
		
		for (int i : A) {
			realSum+=i;
		}
		return expectedSum-realSum;
	}
	
	@Test
	public void test() {
		assertEquals(4, solution(new int[] {2, 3, 1, 5}));
		assertEquals(5, solution(new int[] {2, 3, 4, 1}));
		assertEquals(1, solution(new int[] {2}));
		assertEquals(2, solution(new int[] {1}));
	}
}
