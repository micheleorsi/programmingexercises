/**
 * 
 */
package codility;

/**
 * @author morsi
 *
 */
public class EquilibriumIndex {

	public int solution(int[] A) {
		int arrayLength = A.length;
		
		if (arrayLength > 0) {
			
			long[] leftSum = new long[arrayLength];
			leftSum[0] = 0;
			for (int i = 1; i < arrayLength; i++) {
				leftSum[i] = leftSum[i - 1] + A[i - 1];
			}
			
			long[] rightSum = new long[arrayLength];
			rightSum[arrayLength - 1] = 0;
			for (int i = arrayLength - 2; i >= 0; i--) {
				rightSum[i] = rightSum[i + 1] + A[i + 1];
				if (leftSum[i] == rightSum[i]) {
					return i;
				}
			}
		}
		return -1;
	}

	public int equi(int[] A) {
		long sum = 0;
		long leftSum = 0;

		for (int i = 0; i < A.length; i++) {
			leftSum += A[i];
		}
		for (int i = 0; i < A.length; i++) {
			if (sum == leftSum - A[i])
				return i;
			sum += A[i];
			leftSum -= A[i];
		}
		return -1;

	}

}
