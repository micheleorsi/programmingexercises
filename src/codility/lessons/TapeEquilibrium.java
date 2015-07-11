/**
 * 
 */
package codility.lessons;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Problem with 2-lenght array
 * 
 * @author morsi
 *
 */
public class TapeEquilibrium { 
	
	public int solution(int[] A) {
		if(A.length>2) {
			int minDiff = 100000;

			int[] leftSum = new int[A.length-1];
			leftSum[0] = A[0];
			
			int[] rightSum = new int[A.length-1];
			rightSum[rightSum.length-1]=A[A.length-1];
			
			for (int i=1; i<A.length-1; i++) {
				leftSum[i] = leftSum[i-1] + A[i];			
			}
			for (int i=A.length-3; i>=0; i--) {
				rightSum[i] = rightSum[i+1] + A[i+1];
				int tempDiff = rightSum[i]-leftSum[i];
				if(Math.abs(tempDiff)<minDiff) {
					minDiff = Math.abs(tempDiff);
				}
			}
			return minDiff;
		} else {
			return -1;
		}
		
	}
	
	@Test
	public void test() {
		assertEquals(1, solution(new int[] {3, 1, 2, 4, 3}));
		assertEquals(2, solution(new int[] {2, 1, 2, 4, 3}));
		assertEquals(-1, solution(new int[] {3}));
		assertEquals(-1, solution(new int[] {3,2}));
	}
	
}