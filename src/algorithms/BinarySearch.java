package algorithms;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearch {
	int[] n = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
	
	@Test
	public void testIterativeSolution() {
		Assert.assertEquals(0, iterativeBinarySearch(1,n));
		Assert.assertEquals(15, iterativeBinarySearch(16,n));
		Assert.assertEquals(14, iterativeBinarySearch(15,n));
		Assert.assertEquals(13, iterativeBinarySearch(14,n));
		Assert.assertEquals(12, iterativeBinarySearch(13,n));
		Assert.assertEquals(11, iterativeBinarySearch(12,n));
		Assert.assertEquals(10, iterativeBinarySearch(11,n));
		Assert.assertEquals(-1, iterativeBinarySearch(100,n));
	}

	private int iterativeBinarySearch(int n, int[] array) {
		int lowIndex = 0;
		int highIndex = array.length-1;
		while(lowIndex<=highIndex) {
			int midElement = (lowIndex + highIndex) /2;
			if(array[midElement]==n) {
				return midElement;
			} else if(array[midElement]>n) {
				highIndex = midElement-1;
			} else {
				lowIndex = midElement+1;
			}
		}
		return -1;
	}
	
	@Test
	public void testRecursiveSolution() {
		Assert.assertEquals(0, recursiveBinarySearch(1,n));
		Assert.assertEquals(15, recursiveBinarySearch(16,n));
		Assert.assertEquals(14, recursiveBinarySearch(15,n));
		Assert.assertEquals(13, recursiveBinarySearch(14,n));
		Assert.assertEquals(12, recursiveBinarySearch(13,n));
		Assert.assertEquals(11, recursiveBinarySearch(12,n));
		Assert.assertEquals(10, recursiveBinarySearch(11,n));
		Assert.assertEquals(9, recursiveBinarySearch(10,n));
		Assert.assertEquals(-1, recursiveBinarySearch(100,n));
	}

	private int recursiveBinarySearch(int n, int[] array) {
		if(array.length==1) {
			if(array[0]==n) {
				return 0;
			} else {
				return -1;
			}
		} else {
			int mid = (array.length-1)/2;
			if(array[mid]==n) {
				return mid;
			} else if(array[mid]>n) {
				return recursiveBinarySearch(n, Arrays.copyOfRange(array, 0, mid));
			} else {
				int returnIndex = recursiveBinarySearch(n, Arrays.copyOfRange(array, mid+1, array.length));
				if(returnIndex>=0) {
					return returnIndex+mid+1;
				} else {
					return returnIndex;
				}
			}
		}
	}
	
	@Test
	public void testRecursiveSolution2() {
		Assert.assertEquals(0, recursiveBinarySearch2(1,n, 0, n.length-1));
		Assert.assertEquals(15, recursiveBinarySearch2(16,n, 0, n.length-1));
		Assert.assertEquals(14, recursiveBinarySearch2(15,n, 0, n.length-1));
		Assert.assertEquals(13, recursiveBinarySearch2(14,n, 0, n.length-1));
		Assert.assertEquals(12, recursiveBinarySearch2(13,n, 0, n.length-1));
		Assert.assertEquals(11, recursiveBinarySearch2(12,n, 0, n.length-1));
		Assert.assertEquals(10, recursiveBinarySearch2(11,n, 0, n.length-1));
		Assert.assertEquals(9, recursiveBinarySearch2(10,n, 0, n.length-1));
		Assert.assertEquals(-1, recursiveBinarySearch2(100,n, 0, n.length-1));
	}

	private int recursiveBinarySearch2(int n, int[] array, int lowerIndex, int higherIndex) {
		if(lowerIndex>higherIndex) {
			return -1;
		}
		int midIndex = (lowerIndex + higherIndex)/2;
		if(array[midIndex]==n) {
			return midIndex;
		} else if(array[midIndex]>n) {
			return recursiveBinarySearch2(n, array,lowerIndex,midIndex-1);
		} else {
			return recursiveBinarySearch2(n, array,midIndex+1,higherIndex);
		}
	}

}
