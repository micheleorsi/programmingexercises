package crackingcodinginterview5.chapter6;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * A sorted array has been rotated so that the elements might appear in the order 3 4 5 6 7 1 2. 
 * How would you find the minimum element? You may assume that the array has all unique elements
 * 
 * @author micheleorsi
 *
 */
public class SolutionMinElement {
	public static int MIN_INT = 0;
	
	@Test
	public void test() {
		int[] test1 = {1, 2, 3, 4, 5, 6};
		assertEquals(1, this.minElement_linear(test1));
		int[] test2 = {2, 3, 4, 5, 6, 1};
		assertEquals(1, this.minElement_linear(test2));
		int[] test3 = {3, 4, 5, 6, 1, 2};
		assertEquals(1, this.minElement_linear(test3));
		int[] test4 = {4, 5, 6, 1, 2, 3};
		assertEquals(1, this.minElement_linear(test4));
	}
	
	// time: O(n)
	// space: O(1)
	public int minElement_linear(int[] array) {
		int prevNumber = MIN_INT;
		for (int number : array) {
			if(number<prevNumber) {
				return number;
			} else {
				prevNumber = number;
			}
		}
		return array[0];
	}
	
	@Test
	public void test2() {
		int[] test1 = {1, 2, 3, 4, 5, 6};
		assertEquals(1, this.minElement_log(test1));
		int[] test2 = {2, 3, 4, 5, 6, 1};
		assertEquals(1, this.minElement_log(test2));
		int[] test3 = {3, 4, 5, 6, 1, 2};
		assertEquals(1, this.minElement_log(test3));
		int[] test4 = {4, 5, 6, 1, 2, 3};
		assertEquals(1, this.minElement_log(test4));
	}
	/**
	 * time: O(log n)
	 * 
	 * @param array
	 * @return
	 */
	public int minElement_log(int[] array) {		
		System.out.println(Arrays.toString(array));
		if(array.length<=2) {
			return Math.min(array[0], array[1]);
		} else {
			int indexSplit = array.length/2;
			if(array.length%2==0) {
				indexSplit--;
			}
			if(array[indexSplit]>array[array.length-1]) {
				int[] tempArray = Arrays.copyOfRange(array,indexSplit,array.length);
				System.out.println("else: "+Arrays.toString(tempArray));
				return minElement_log(tempArray);
			} else {
				int[] tempArray = Arrays.copyOfRange(array,0,indexSplit+1);
				System.out.println("if: "+Arrays.toString(tempArray));
				return minElement_log(tempArray);
			}
		}
		
	}
}
