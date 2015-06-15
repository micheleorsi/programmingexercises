/**
 * 
 */
package interviewcake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * https://www.interviewcake.com/question/highest-product-of-3
 * 
 * Given an array_of_ints, find the highest_product you can get from three of the integers.
 * 
 * The input array_of_ints will always have at least three integers.
 * 
 * 
 * @author morsi
 *
 */
public class Ex03_HighestProductOf3 {
	
	// time: O(n logn)
	// space: O(1)
//	public int highestProduct(int[] array) {
//		Arrays.sort(array);
//		return array[array.length-1]*array[array.length-2]*array[array.length-3];
//	}
	
	public int highestProduct(int[] array) {
		int highest = Math.max(array[0], array[1]);
		int lowest = Math.min(array[0], array[1]);
		int highest3product = array[0]*array[1]*array[2];
		int lowest2product= array[0]*array[1];
		int highest2product= array[0]*array[1];

		for(int i=2; i<array.length; i++) {
			int current = array[i];
			
			highest3product = Math.max(highest3product, 
					Math.max(current * lowest2product, 
							current * highest2product));
			
			highest2product = Math.max(highest2product, 
					Math.max(current*highest, 
							current*lowest));
			
			lowest2product = Math.min(lowest2product, 
					Math.min(current*highest, 
							current*lowest));
			
			highest = Math.max(highest, current);
			lowest = Math.min(lowest, current);
		}
		return highest3product;
	}

	@Test
	public void test() {
		int[] test1 = {1, 7, 3, 4};
		assertEquals(7*3*4,highestProduct(test1));
		
		int[] test2 = {1, 10, 7, 3, 4};
		assertEquals(7*4*10,highestProduct(test2));
		
		int[] test3 = {1, 7, 14, 11, 3, 4};
		assertEquals(14*11*7,highestProduct(test3));
		
		int[] test4 = {-10,-10, 1, 2, 3};
		assertEquals(300,highestProduct(test4));
		
		int[] test5 = {1, 10, -5, 1, -100};
		assertEquals(500*10,highestProduct(test5));
	}
}
