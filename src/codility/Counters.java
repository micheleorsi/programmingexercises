package codility;

//you can also use imports, for example:
import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Counters {
	public int[] solution(int N, int[] A) {
		int[] returnArray = new int[N];
		Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
		int lowerBound = 0;
		int maxValue = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > N) {
				lowerBound = maxValue;
			} else {
				if (cache.containsKey(A[i])) {
					int prevValue = cache.get(A[i]);
					if (prevValue < lowerBound) {
						prevValue = lowerBound;
					}
					prevValue++;
					if (prevValue > maxValue) {
						maxValue = prevValue;
					}
					cache.put(A[i], prevValue);
				} else {
					cache.put(A[i], 1 + lowerBound);
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if (cache.containsKey(i)) {
				returnArray[i - 1] = cache.get(i);
				if (returnArray[i - 1] < lowerBound) {
					returnArray[i - 1] = lowerBound;
				}
			} else {
				returnArray[i - 1] = lowerBound;
			}
		}
		return returnArray;
	}
}