package interviewcake;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * https://www.interviewcake.com/question/product-of-other-numbers
 * 
 * You have an array of integers, and for each index you want to find the product 
 * of every integer except the integer at that index
 * 
 * Write a function get_products_of_all_ints_except_at_index() that takes an array of integers and returns an array of the products.
 * 
 * For example, given:
 *   [1, 7, 3, 4]
 * your function would return:
 *   [84, 12, 28, 21]
 * by calculating:
 *   [7*3*4, 1*3*4, 1*7*4, 1*7*3]
 * Do not use division in your solution.
 * 
 * @author micheleorsi
 *
 */
public class Ex02_ProductOfOtherNumbers {
	// time: O(n^2)
	// space: O(n)
//	public int[] productOfTheOtherNumber(int[] input) {
//		int[] returnArray = new int[input.length];
//		for(int i=0; i<input.length; i++) {
//			returnArray[i] = 1;
//			for(int j=0; j<input.length; j++) {
//				if(i!=j) {
//					returnArray[i] = returnArray[i]*input[j];
//				}
//			}
//		}
//		return returnArray;
//	}
	
	// time: O(2n) -> O(n)
	// space: O(n) -> O(n)
	public int[] productOfTheOtherNumber(int[] input) {
		if(input.length==0) {
			return new int[]{};
		}
		int result[] =  new int[input.length];
		result[0]=1;
		for(int i=1; i<input.length; i++) {
			result[i]= result[i-1]*input[i-1];
		}

		int rightProduct = 1;
		for(int i=input.length-2; i>=0; i--) {
			rightProduct = rightProduct*input[i+1];
			result[i]= result[i]*rightProduct;
		}

		return result;
	}
	
	@Test
	public void test() {
		int[] test1 = {1, 7, 3, 4};
		assertEquals(84,productOfTheOtherNumber(test1)[0]);
		assertEquals(12,productOfTheOtherNumber(test1)[1]);
		assertEquals(28,productOfTheOtherNumber(test1)[2]);
		assertEquals(21,productOfTheOtherNumber(test1)[3]);
				
		int[] test2 = {1, 7};
		assertEquals(7,productOfTheOtherNumber(test2)[0]);
		assertEquals(1,productOfTheOtherNumber(test2)[1]);
		
		int[] test3 = {7};
		assertEquals(1,productOfTheOtherNumber(test3)[0]);
		
		int[] test4 = {};
		assertTrue(productOfTheOtherNumber(test4).length==0);
	}
	
	
}
