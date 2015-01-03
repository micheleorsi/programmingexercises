package crackingcodinginterview.chapter6;

import static org.junit.Assert.*;
import org.junit.Test;

public class SolutionMinElement {
	public static int MIN_INT = 0;
	
	@Test
	public void test() {
		int[] test1 = {1, 2, 3, 4, 5, 6};
		assertEquals(1, this.minElement(test1));
		int[] test2 = {2, 3, 4, 5, 6, 1};
		assertEquals(1, this.minElement(test2));
		int[] test3 = {3, 4, 5, 6, 1, 2};
		assertEquals(1, this.minElement(test3));
		int[] test4 = {4, 5, 6, 1, 2, 3};
		assertEquals(1, this.minElement(test4));
	}
	
	public int minElement (int[] array) {
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
}
