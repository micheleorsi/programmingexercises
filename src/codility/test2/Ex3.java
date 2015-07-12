package codility.test2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ex3 {
	
	public int solution(int[] A) {
		if(A.length>=2) {
			int prevprevInt = A[0];
			int prevInt = A[1];
			int actualSlice = 2;
			int largestSlice = actualSlice;
			for (int i=2; i<A.length; i++) {
				if(A[i]==prevprevInt || A[i]==prevInt) {
					largestSlice++;
				} else {
					actualSlice = 2;
					prevprevInt = prevInt;
					prevInt = A[i];
					if(actualSlice>largestSlice) {
						largestSlice = actualSlice;
					}
				}
			}
			return largestSlice;
		} else if(A.length==1) {
			return 1;
		} else {
			return 0;
		}
		
	}
	
	@Test
	public void test() {
		assertEquals(2, solution(new int[]{5,4}));
		assertEquals(1, solution(new int[]{4}));
		assertEquals(0, solution(new int[]{}));
		assertEquals(4, solution(new int[]{5,4,4,5,0,12}));
		assertEquals(5, solution(new int[]{5,4,4,5,5,0,12}));
		assertEquals(5, solution(new int[]{1,2,3,5,4,4,5,5,0,12}));
		assertEquals(6, solution(new int[]{1,2,3,4,5,4,4,5,5,0,12}));
		
		assertEquals(4, solution(new int[]{2147483647,2147483646,2147483646,2147483647,0,12}));

	}

}
