package interviewcake;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * Each order is represented by an "order id" (an integer).
 * We have our lists of orders sorted numerically already, in arrays. 
 * Write a function to merge our arrays of orders into one sorted array.
 * 
 * For example:
 * my_array     = [3,4,6,10,11,15]
 * alices_array = [1,5,8,12,14,19]
 * print merge_arrays(my_array, alices_array)
 * # prints [1,3,4,5,6,8,10,11,12,14,15,19]
 * 
 * @author micheleorsi
 *
 */
public class Ex42_MergeSortedArrays {

	@Test
	public void test() {
		int[] array1 = new int[] {3,4,6,10,11,15};
		int[] array2 = new int[] {1,5,8,12,14,19};
		
		int[] result = new int[] {1,3,4,5,6,8,10,11,12,14,15,19};
		assertEquals(Arrays.toString(result), 
				Arrays.toString(this.merge_arrays(array1, array2)));
	}
	// O(n1+n2)
	public int[] merge_arrays(int[] arr1, int[] arr2) {
		int idx1 = 0;
		int idx2 = 0;
		int[] result = new int[arr1.length + arr2.length];
		for(int i=0; i<result.length; i++) {
			if(idx1<arr1.length && idx2<arr2.length) {
				if(arr1[idx1]<=arr2[idx2]) {
					result[i]=arr1[idx1];
					idx1++;
				} else {
					result[i]=arr2[idx2];
					idx2++;
				}
			} else if(idx1>=arr1.length) {
				result[i]=arr2[idx2];
				idx2++;
			} else if(idx2>=arr2.length) {
				result[i]=arr1[idx1];
				idx1++;
			} 
		}
		return result;
	}

}
